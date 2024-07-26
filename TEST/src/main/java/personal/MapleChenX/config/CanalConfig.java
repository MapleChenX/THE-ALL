package personal.MapleChenX.config;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
public class CanalConfig {

    @Bean
    public CanalConnector canalConnector() {
        return CanalConnectors.newSingleConnector(
                new InetSocketAddress("127.0.0.1", 11111), // Canal服务器的地址和端口
                "example", // Canal实例的名称
                "", // Canal用户名（如果有的话）
                ""  // Canal密码（如果有的话）
        );
    }
}
