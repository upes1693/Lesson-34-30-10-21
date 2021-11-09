package com.jdbc_demo;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO implements  DAO{
    @Override
    public Student get(String email) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlite:C:\\Users\\markf\\IdeaProjects\\FirstJDBCDemo\\DB\\myfirstdb.db");
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM students WHERE email=?");) {
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();

            Student student=null;

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int phone = resultSet.getInt("phone");
                student=new Student(name,phone,email);
            }
            return student;
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Student> getAll() {
        return null;
    }

    @Override
    public void create(String name, int phone, String email) {

    }
}
