package cn.itcast.consumer.web;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "queryByIdFallBack")
public class ConsumerController {

   /* @Autowired
    RestTemplate restTemplate;*/

    @Autowired
    UserClient userClient;

   /* @Autowired
    DiscoveryClient discoveryClient;*/

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {

        return userClient.queryById(id);

    }


    public String queryByIdFallBack(Long id) {

        return "对不起，网络太拥挤";

    }

    public String queryByIdFallBack() {

        return "对不起，网络太拥挤";

    }
    /*   @GetMapping("/{id}")
     *//* @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})*//*
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")})
    public String queryById(@PathVariable("id") Long id) {

        if (id % 2 == 0) {

            throw new RuntimeException("");

        }


        String url = "http://user-service/user/" + id;


        return restTemplate.getForObject(url, String.class);

    }*/
       /* List<ServiceInstance> instances = discoveryClient.getInstances("user-service");

        ServiceInstance instance = instances.get(0);
*/

/*
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
*/
}
