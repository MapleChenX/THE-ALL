package personal.MapleChenX.im_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import personal.MapleChenX.im_service.model.UserImDTO;

public interface UserImService extends IService<UserImDTO> {

    public String getUserInfo();


}
