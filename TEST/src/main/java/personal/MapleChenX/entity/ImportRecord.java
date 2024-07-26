package personal.MapleChenX.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("import_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportRecord {
    private Integer id;
    private String name;
    private String sex;
}
