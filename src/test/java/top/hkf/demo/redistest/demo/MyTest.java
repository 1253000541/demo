package top.hkf.demo.redistest.demo;

import lombok.Data;
import org.junit.Test;
import top.hkf.demo.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {
    @Test
    public void contextLoads() {

        List list=new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Integer pageSize=4;
        Integer pageNum=1;
        filterByPage(list,pageNum,pageSize).forEach(System.out::print);
    }

    public static List filterByPage(List list, Integer pageNum, Integer pageSize) {
        Object collect = list.stream().skip(pageSize*(pageNum-1)).limit(pageSize).collect(Collectors.toList());
        return (List) collect;
    }

    public static List filterByPage1(List<Student> list,Integer pageNum, Integer pageSize) {

        List<Student> collect = list.stream().filter(num -> num.getId() > 3).skip(pageSize).limit(pageSize * (pageNum - 1)).collect(Collectors.toList());
        return collect;
    }
    @Test
    public void test(){

    }
}
