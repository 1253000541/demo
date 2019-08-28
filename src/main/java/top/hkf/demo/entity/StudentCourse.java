package top.hkf.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hkf
 * @since 2019-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentCourse extends Model<StudentCourse> {

    private static final long serialVersionUID=1L;

    private Integer sid;

    private Integer cid;

    private Integer score;


    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

}
