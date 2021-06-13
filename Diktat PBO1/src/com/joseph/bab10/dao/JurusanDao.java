/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab10.dao;

import com.joseph.bab10.entity.DaoService;
import com.joseph.bab10.entity.MySQLConnection;
import com.joseph.bab9.Jurusan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurusanDao implements DaoService<Jurusan> {
    @Override
    public List<Jurusan> fetchAll() throws SQLException, ClassNotFoundException {
        List<Jurusan> jurusanList = new ArrayList<>();
        String query = "SELECT j.id,j.namaJurusan FROM jdbcdemodb.jurusan j;";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()){
                        Jurusan jurusan = new Jurusan(rs.getInt("j.id"),rs.getString("j.namaJurusan"));
                        jurusanList.add(jurusan);
                    }
                }
            }
        }
        return jurusanList;
    }

    @Override
    public int addData(Jurusan jurusan) throws SQLException, ClassNotFoundException {
        int result = 0;
        String query = "INSERT INTO jurusan(namaJurusan) VALUES(?)";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, jurusan.getNamaJurusan());
                if(ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }
                else{connection.rollback();}
            }
        }return  result;
    }

    @Override
    public int updateData(Jurusan jurusan) throws SQLException, ClassNotFoundException {
        int result = 0;
        String query = "UPDATE `jdbcdemodb`.`jurusan` SET `namaJurusan` = ? " +
                "WHERE `id` = ?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, jurusan.getNamaJurusan());
                ps.setInt(2,jurusan.getId());
                if(ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }
                else{connection.rollback();}
            }
        }return result;
    }

    @Override
    public int deleteData(Jurusan jurusan) throws SQLException, ClassNotFoundException {
        int result = 0;
        String query = "DELETE jurusan WHERE id = ?";
        try (Connection connection = MySQLConnection.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1,jurusan.getId());
                if(ps.executeUpdate()!=0){
                    connection.commit();
                    result=1;
                }
                else{connection.rollback();}
            }
        }return result;
    }
}
