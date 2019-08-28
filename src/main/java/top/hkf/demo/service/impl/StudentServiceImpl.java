package top.hkf.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityWriter;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.hkf.demo.entity.Student;
import top.hkf.demo.dao.StudentMapper;
import top.hkf.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.hkf.demo.utils.RedisOperator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hkf
 * @since 2019-08-15
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisOperator redisOperator;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<Student> loadStudent() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Student::getName, "张三");
        List<Student> list = list(wrapper);
        String stuJson = JSON.toJSONString(list);
        System.out.println(stuJson);
        //redisTemplate.opsForValue().set("stuMes", stuJson);
        //redisTemplate.opsForValue().set("name","zs");
        //redisTemplate.expire("name", 20, TimeUnit.SECONDS);
        list.forEach(System.out::println);
        return list;
    }

    public Student findStudent() {
     Student students= studentMapper.selectOne(new QueryWrapper<Student>().eq("name","张三").
             eq("id","1"));
     return students;

    }
    public void del(){
        Map map=new HashMap<>();
       map.put("name","李青");
        studentMapper.deleteByMap(map);
    }
}
