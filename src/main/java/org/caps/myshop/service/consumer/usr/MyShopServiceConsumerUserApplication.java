package org.caps.myshop.service.consumer.usr;

/**
 * @author caps
 * @Date 2019/5/30 14:15
 * @Description
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "org.caps.myshop", exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
public class MyShopServiceConsumerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceConsumerUserApplication.class, args);
    }
}