package com.fhb.studentspringboot.controller;

import com.fhb.studentspringboot.entity.Student;
import com.fhb.studentspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getAll")
    public List<Map<String, Object>> getAllStudent() {
        try {
            return studentService.GetAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getAllnohide")
    public List<Map<String, Object>> getAllStudentReal() {
        try {
            return studentService.GetRealAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getUserById/{id}")
    public List<Map<String, Object>> getById(@PathVariable("id") Integer id) {
        try {
            return studentService.GetById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping("/adduser")
    public  List<Map<String, Object>> addUser(Student student, Model model) {
        if (!studentService.GetByName(student).isEmpty()) {
            String str = "you cannot add a user with duplicated name";
            System.out.println("you cannot add a user with duplicated name");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                studentService.Insert(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return studentService.GetAllStudent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
    public  List<Map<String, Object>> updateUser(Student student, Model model) {
        if (!studentService.GetByName(student).isEmpty()) {
            String str = "you cannot update a user with duplicated name";
            System.out.println("you cannot update a user with duplicated name");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                studentService.Update(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return studentService.GetAllStudent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    //    delete specific user
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Map<String, Object>> deleteUser(@PathVariable("id") Integer id, Model model) {
        if(!studentService.findDS(id)) {
            String str = "you cannot delete this user without put into tombstone first";
            System.out.println("you cannot delete this user without put into tombstone first");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                studentService.Delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return studentService.GetAllStudent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @RequestMapping(value = "/tombstone/{id}", method = RequestMethod.GET)
    public List<Map<String, Object>> tombstone(@PathVariable("id") Integer id, Model model) {
        if(studentService.findDS(id)) {
            String str = "you cannot put this user into tombstone";
            System.out.println("you cannot put this user into tombstone");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                studentService.Tombstone(id);
                System.out.println("this user is marked in tombstone");
                String str = "this user is marked in tombstone";
                model.addAttribute("str", str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return studentService.GetAllStudent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    @RequestMapping(value = "/recover/{id}", method = RequestMethod.GET)
    public List<Map<String, Object>> recoverTheUser(@PathVariable("id") Integer id, Model model) {
        if(!studentService.findDS(id)) {
            String str = "you cannot recover this user without put into tombstone first";
            System.out.println("you cannot recover this user without put into tombstone first");
            model.addAttribute("str", str);
            return null;
        } else {
            try {
                studentService.Recover(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return studentService.GetAllStudent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

//    @RequestMapping("/findds/{id}")
//    public boolean findDS(@PathVariable("id") Integer id) {
//        return studentService.findDS(id);
//    }


}
