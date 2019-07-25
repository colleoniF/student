package com.fhb.studentspringboot.service.impl;

import com.fhb.studentspringboot.dao.StudentMapper;
import com.fhb.studentspringboot.entity.Student;
import com.fhb.studentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceimpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Object>> GetAllStudent() {
        return studentMapper.AllStudent();
    }

    @Override
    public List<Map<String, Object>> GetRealAllStudent() {
        return studentMapper.realAllStudent();
    }

    @Override
    public List<Map<String, Object>> GetById(int id) {
        return studentMapper.GetById(id);
    }

    @Override
    public List<Map<String, Object>> GetByName(Student student) {
        return studentMapper.GetByName(student);
    }

    @Override
    public void Insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void Update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void Delete(int id) {
        studentMapper.delete(id);
    }

    @Override
    public void Tombstone(int id) {
        studentMapper.tombstone(id);
    }

    @Override
    public void Recover(int id) {
        studentMapper.recoverUser(id);
    }

    @Override
    public boolean findDS(int id) {
        return studentMapper.findDS(id);
    }

}
