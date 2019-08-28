package top.hkf.demo.redistest.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.hkf.demo.dao.StudentMapper;
import top.hkf.demo.entity.Student;

public class MybatisPlusTest {

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void test(){
        Student student=new Student();
        student.setName("李青");
        studentMapper.insert(student);
    }
}
