package com.example.MazeGameProject.repository;

import com.example.MazeGameProject.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDAOInMemory implements RoomDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Room getRoomByID(int id) {
       String sql = "SELECT * FROM Room WHERE id = ?";
       Room room = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Room.class));
        System.out.println(room.getId());
       return room;


    }
}
