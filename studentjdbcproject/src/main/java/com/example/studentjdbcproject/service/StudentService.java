package com.example.studentjdbcproject.service;

import com.example.studentjdbcproject.dao.StudentDAO;
import com.example.studentjdbcproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public int addStudent(Student student) {
        return studentDAO.save(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }
}
