/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab10.dao;

import com.joseph.bab10.entity.DaoService;
import com.joseph.bab10.entity.MySQLConnection;
import com.joseph.bab9.Jurusan;
import com.joseph.bab9.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements DaoService<Student> {


    @Override
    public List<Student> fetchAll() throws SQLException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT s.noUnik,s.namaOrang,s.gender,j.id,j.namaJurusan FROM jdbcdemodb.student s " +
                "Inner join jdbcdemodb.jurusan j on s.Jurusan_id = j.id;";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Student student = new Student(
                                rs.getString("s.noUnik"),
                                rs.getString("s.namaOrang"),
                                rs.getString("s.gender"),
                                new Jurusan(rs.getInt("j.id"),rs.getString("j.namaJurusan"))
                        );
                        studentList.add(student);
                    }
                }
            }
        }

        return studentList;
    }

    @Override
    public int addData(Student student) throws SQLException, ClassNotFoundException {
        int result = 0;
        return result;
    }

    @Override
    public int updateData(Student student) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int deleteData(Student student) throws SQLException, ClassNotFoundException {
        return 0;
    }
}
