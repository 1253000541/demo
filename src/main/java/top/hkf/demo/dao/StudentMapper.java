package top.hkf.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.hkf.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hkf
 * @since 2019-08-15
 */
@Component
public interface StudentMapper extends BaseMapper<Student> {

}
