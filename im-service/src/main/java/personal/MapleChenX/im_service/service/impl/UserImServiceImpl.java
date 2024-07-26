package personal.MapleChenX.im_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import personal.MapleChenX.im_service.mapper.UserImMapper;
import personal.MapleChenX.im_service.model.UserImDTO;
import personal.MapleChenX.im_service.service.UserImService;

@Service
public class UserImServiceImpl extends ServiceImpl<UserImMapper, UserImDTO> implements UserImService {
    @Override
    public String getUserInfo() {
        return "";
    }
}
