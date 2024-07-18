package personal.MapleChenX.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import personal.MapleChenX.dao.ImportRecordMapper;
import personal.MapleChenX.entity.ImportRecord;
import personal.MapleChenX.service.ImportRecordService;

@Service
public class ImportRecordServiceImpl extends ServiceImpl<ImportRecordMapper, ImportRecord> implements ImportRecordService {
}
