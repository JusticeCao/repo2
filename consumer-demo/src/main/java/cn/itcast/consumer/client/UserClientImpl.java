package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public User queryById(Long id) {

        User user = new User();

        user.setId(id);

        user.setUserName("未知的用戶名，查詢異常");

        return user;
    }
}
