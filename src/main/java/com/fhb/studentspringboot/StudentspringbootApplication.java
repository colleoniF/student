package com.fhb.studentspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fhb.studentspringboot.dao")
public class StudentspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentspringbootApplication.class, args);
    }

}
