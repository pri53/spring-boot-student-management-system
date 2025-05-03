package com.example.studentjdbcproject.dao;

import com.example.studentjdbcproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Student student) {
        return jdbcTemplate.update("""
            INSERT INTO student(name, dob, gender, course, phone, parent_phone, father_name, mother_name, address, email)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """,
            student.getName(), student.getDob(), student.getGender(), student.getCourse(),
            student.getPhone(), student.getParentPhone(), student.getFatherName(),
            student.getMotherName(), student.getAddress(), student.getEmail());
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM student", (rs, rowNum) -> {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setDob(rs.getString("dob"));
            s.setGender(rs.getString("gender"));
            s.setCourse(rs.getString("course"));
            s.setPhone(rs.getString("phone"));
            s.setParentPhone(rs.getString("parent_phone"));
            s.setFatherName(rs.getString("father_name"));
            s.setMotherName(rs.getString("mother_name"));
            s.setAddress(rs.getString("address"));
            s.setEmail(rs.getString("email"));
            return s;
        });
    }
}
