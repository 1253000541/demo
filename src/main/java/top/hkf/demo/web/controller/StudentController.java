package top.hkf.demo.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.hkf.demo.entity.Student;
import top.hkf.demo.service.StudentService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hkf
 * @since 2019-08-15
 */
@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/get")
    public Student getAllStudents(){
       Student student=studentService.findStudent();

        return student;
    }
    @RequestMapping("/del")
    public void inser(){
        studentService.del();
    }
}

