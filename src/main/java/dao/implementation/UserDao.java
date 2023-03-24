package dao.implementation;

import dao.IUserDao;
import db.connection.PoolConnection;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private final PoolConnection poolConnection;

    public UserDao(PoolConnection poolConnection) {
        this.poolConnection = poolConnection;
    }

    @Override
    public void create(User user) {

        String sql = "INSERT INTO USERS (first_name, last_name, email, phone, balance, login, password, role_id)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = poolConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setBigDecimal(5, user.getBalance());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setInt(8, user.getRoleId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(" Can't create user into DataBase", e);
        }
    }

    @Override
    public List<User> getAll() {

        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, first_name, last_name, email, phone, balance, login, password, role_id from users ";
        try (Statement statement = poolConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                userList.add(extractUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Can't get users from DataBase ", e);
        }
        return userList;
    }

    @Override
    public User getById(int id) {

        String sql = "SELECT id, first_name, last_name, email, phone, balance, login, password, " +
                "role_id from users where id = ?";
        try (PreparedStatement preparedStatement = poolConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractUser(resultSet);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(" Can't get user by id from DataBase ", e);
        }

    }

    @Override
    public User getByLogin(String login) {

        String sql = "SELECT id, first_name, last_name, email, phone, balance, login, password, " +
                "role_id from users where login = ?";
        try (PreparedStatement preparedStatement = poolConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractUser(resultSet);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(" Can't get user by Login from DataBase", e);
        }

    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setBalance(resultSet.getBigDecimal("balance"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRoleId(resultSet.getInt("role_id"));
        return user;
    }

}
