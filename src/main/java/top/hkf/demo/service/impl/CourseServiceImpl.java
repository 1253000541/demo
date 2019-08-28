package top.hkf.demo.service.impl;

import top.hkf.demo.entity.Course;
import top.hkf.demo.dao.CourseMapper;
import top.hkf.demo.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hkf
 * @since 2019-08-15
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
