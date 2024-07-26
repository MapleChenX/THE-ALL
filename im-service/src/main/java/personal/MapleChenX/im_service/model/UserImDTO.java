package personal.MapleChenX.im_service.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@Data
@TableName("user")
public class UserImDTO {
    @TableId
    private String id;

    @TableField("alias")
    private String alias;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    @TableField("gender")
    private String gender;

    @TableField("type")
    private String type;


}
