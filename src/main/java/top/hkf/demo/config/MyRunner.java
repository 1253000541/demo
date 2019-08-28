package top.hkf.demo.config;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.hkf.demo.dao.StudentMapper;
import top.hkf.demo.entity.Student;
import top.hkf.demo.service.StudentService;

import java.util.List;

@Component
//项目启动后第一运行
@Order(1)
public class MyRunner {//implements CommandLineRunner
//
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//    @Override
//    public void run(String... args) throws Exception {
//        List<Student> students = studentService.loadStudent();
//        redisTemplate.opsForValue().set("stuMes", JSON.toJSONString(students));
//    }
}
