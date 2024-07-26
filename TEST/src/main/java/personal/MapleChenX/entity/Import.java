package personal.MapleChenX.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("import")
@Data
public class Import {
    Integer id;
    String name;
    String gender;
}
