package personal.MapleChenX.service;

import com.baomidou.mybatisplus.extension.service.IService;
import personal.MapleChenX.entity.Import;

public interface ImportService extends IService<Import> {
    void insert100w();

    void import2record();
}
