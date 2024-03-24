package org.example.crud;

import java.sql.*;
import java.util.ArrayList;

public class PersonDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/shop";
    static final String USER = "postgres";
    static final String PASS = "8697E591rn";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Подключение прошло успешно");

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return connection;
    }

    public static int save(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into crud_example (userName,userPass,userEmail,userCountry,role) values(?,?,?,?,?)");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getUserPass());
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setString(5, String.valueOf(person.getRole()));
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    public static ArrayList<Person> getAllPersons() {
        ArrayList<Person> arrayList = new ArrayList<>();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                person.setRole(Person.ROLE.valueOf(resultSet.getString(6)));
                arrayList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayList;
    }

    public static int delete(Person person) {
        int status = 0;

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from crud_example where id =?");
            preparedStatement.setInt(1, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    public static Person getPersonById(int id) {
        Person person = new Person();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                person.setRole(Person.ROLE.valueOf(resultSet.getString(6)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public static int update(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update crud_example set userName=?,userPass=?,userEmail=?,userCountry=?,role=? where id=?");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, Hesh_Password.HeshPassword(person.getUserPass()));
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setString(5, String.valueOf(person.getRole()));
            preparedStatement.setInt(6, person.getId());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
    public static Person getPersonByIdUser(int id) {
        Person person = new Person();

        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public static int updateUser(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update crud_example set userName=?,userPass=?,userEmail=?,userCountry=? where id=?");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, Hesh_Password.HeshPassword(person.getUserPass()));
            preparedStatement.setString(3, person.getUserEmail());
            preparedStatement.setString(4, person.getUserCountry());
            preparedStatement.setInt(5, person.getId());

            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static Person checkPersonIfExists(Person person) {
        int status = 0;
        try {
            Connection connection = PersonDao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from crud_example where userEmail=? and userPass=?");
            preparedStatement.setString(1, person.getUserEmail());
            preparedStatement.setString(2, person.getUserPass());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                person.setUserName(resultSet.getString(2));
                person.setUserPass(resultSet.getString(3));
                person.setUserEmail(resultSet.getString(4));
                person.setUserCountry(resultSet.getString(5));
                person.setRole(Person.ROLE.valueOf(resultSet.getString(6)));
                return person;

            }
            return null;
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
