package Service;

import Model.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/dome?userSSL=false&useUnicode=yes&characterEncoding=UTF-8";
    private String jdbcUserName = "root";
    private String jdbcPassWord = "Kanze9152";

    private static final String INSERT_USERS_SQL = "insert into users (username,password,email,country) value (?,?,?,?);";
    private static final String select_user_by_id = "select id,username,password,email,country from users where id = ?;";
    private static final String select_all_users = "select * from users;";
    private static final String delete_users_sql = "delete from users where id=?;";
    private static final String update_user_sql = "update users set username =?,password=?,email=?,country=? where id=?;";
    private static final String sort_by_name = "select * from users order by username asc;";
    private static final String select_user_by_country = "select id,username,password,email,country from users where country = ?;";
    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(user user) {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public user selectUser(int id) {
        user user = null;
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(select_user_by_id);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new user(id, username, password, email, country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<user> selectAllUsers() {
        List<user> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(select_all_users);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new user(id, username, password, email,country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(delete_users_sql)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(user user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(update_user_sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getCountry());
            statement.setInt(5, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public List<user> selectUserByCountry(String countries) {
        List<user> users = new ArrayList<>();
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(select_user_by_country);
            preparedStatement.setString(1, countries);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new user(id, username, password, email,country));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<user> sortUser() {
        List<user> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sort_by_name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new user(id, username, password, email,country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private void printSQLException(SQLException ex){
        for(Throwable e: ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: " +((SQLException) e).getSQLState());
                System.err.println("Error Code: " +((SQLException) e).getErrorCode());
                System.err.println("Message: " +e.getMessage());
                Throwable t = ex.getCause() ;
                while (t!= null){
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
