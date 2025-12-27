package org.mapper;

import org.beans.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student std1 = new Student();
        std1.setRoll(rs.getInt("std_roll"));
        std1.setName(rs.getString("std_name"));
        std1.setMarks(rs.getFloat("std_marks"));
        return std1;
    }
}
