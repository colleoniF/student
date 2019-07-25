package com.fhb.studentspringboot.service;

import com.fhb.studentspringboot.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Map<String, Object>> GetAllStudent();
    List<Map<String, Object>> GetRealAllStudent();
    List<Map<String, Object>> GetById(int id);
    List<Map<String, Object>> GetByName(Student student);
    void Insert(Student student);
    void Update(Student student);
    void Delete(int id);
    void Tombstone(int id);
    void Recover(int id);
    boolean findDS(int id);
}
