package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@EnableCircuitBreaker  //服务熔断
@EnableDiscoveryClient
@SpringBootApplication*/

@EnableFeignClients
@SpringCloudApplication //包含以上三种注解
public class ConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);

    }

    @Bean
    @LoadBalanced   //拦截所有restTemplate调用的对象
    public RestTemplate restTemplate() {

        return new RestTemplate();

    }
}
