package top.hkf.demo.service;

import top.hkf.demo.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hkf
 * @since 2019-08-15
 */
public interface StudentService extends IService<Student> {
    List<Student> loadStudent();

    Student findStudent();

    void del();
}
