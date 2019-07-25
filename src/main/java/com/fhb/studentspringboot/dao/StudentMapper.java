package com.fhb.studentspringboot.dao;

import com.fhb.studentspringboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Map<String, Object>> AllStudent();
    List<Map<String, Object>> realAllStudent();
    List<Map<String, Object>> GetById(int id);
    List<Map<String, Object>> GetByName(Student student);
    void insert(Student student);
    void update(Student student);
    void delete(int id);
    void tombstone(int id);
    void recoverUser(int id);
    boolean findDS(int id);
}
