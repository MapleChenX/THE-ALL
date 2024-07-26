package personal.MapleChenX.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import personal.MapleChenX.dao.ImportMapper;
import personal.MapleChenX.entity.Import;
import personal.MapleChenX.entity.ImportRecord;
import personal.MapleChenX.service.ImportRecordService;
import personal.MapleChenX.service.ImportService;
import personal.MapleChenX.utils.MQUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ImportServiceImpl extends ServiceImpl<ImportMapper, Import> implements ImportService {

    @Resource
    ImportRecordService importRecordService;

    @Resource
    MQUtils mqUtils;

    public final static String QUEUE_NAME = "import_queue";

    @Override
    public void insert100w() {
        Random random = new Random(); // Create a random number generator

        for (int i = 0; i < 1000000; i++) {
            Import import1 = new Import();

            // Generate unique name using random characters
            String name = generateRandomName(random);
            import1.setName(name);

            // Generate unique gender using random value
            String gender = random.nextBoolean() ? "male" : "female";
            import1.setGender(gender);

            // Set other attributes if needed

            this.save(import1); // Save the generated import object
            System.out.println("插入第" + i + "条数据 name is " + name);
        }
    }

    @Override
    public void import2record() {
        // 0 清空record表
        importRecordService.remove(null);
        final int[] count = {1};
        // 1 分页查询，每次都从import表取出500条数据
        for(int i =1;i<50;i++) {
            QueryWrapper<Import> q = new QueryWrapper<>();
            q.last(String.format("limit %d,%d", (i - 1) * 500, 500));


            // 2 将查询出来的数据插入到record表中

            List<ImportRecord> IRList = new ArrayList<>();

            this.list(q).forEach(import1 -> {
                LambdaQueryWrapper<ImportRecord> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(ImportRecord::getId, import1.getId());
                if (importRecordService.getOne(queryWrapper) == null) {
                    ImportRecord importRecord = new ImportRecord();
                    importRecord.setId(import1.getId());
                    importRecord.setName(import1.getName());
                    importRecord.setSex(import1.getGender());

                    // MQ
                    mqUtils.sendMessage(QUEUE_NAME, JSON.toJSONString(importRecord));
                    System.out.println("发送了第" + count[0] + "条数据");
                    count[0]++;
//                    IRList.add(importRecord);
                }
            });


//            importRecordService.saveBatch(IRList);
//            System.out.println("插入第" + i + "批数据；大小为：" + IRList.size());

        }



    }

    // 监听队列
    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(String message) {
        AtomicInteger count = new AtomicInteger(1);
        System.out.println("Received message: " + message);
        // 反序列化为ImportRecord对象
        ImportRecord importRecord = JSONObject.parseObject(message, ImportRecord.class);
        importRecordService.save(importRecord);
        System.out.println("插入了第" + count.getAndIncrement() + "条数据");
    }

    private String generateRandomName(Random random) {
        // Define a character set for name generation (e.g., letters, numbers, symbols)
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        // Set a desired name length
        int nameLength = 10; // Adjust as needed

        StringBuilder nameBuilder = new StringBuilder();
        for (int j = 0; j < nameLength; j++) {
            int randomIndex = random.nextInt(charSet.length());
            nameBuilder.append(charSet.charAt(randomIndex));
        }

        return nameBuilder.toString();
    }

}

// 1 同步方式
// 2 mq方式
    // · 单个对象
    // · 批量对象
// 3 多线程方式