package personal.MapleChenX.web;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.MapleChenX.service.ImportRecordService;
import personal.MapleChenX.service.ImportService;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Resource
    ImportService importService;

    @RequestMapping("/insert100w")
    public void importData() {
        importService.insert100w();
    }

    @RequestMapping("/import2record")
    public void import2record() {
        importService.import2record();
    }


}
