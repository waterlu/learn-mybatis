package cn.lu.learn.base1;

import org.springframework.stereotype.Service;

/**
 * @author lutiehua
 * @date 2018/1/8
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName(String userUuid) {
        int len = userUuid.length();
        return userUuid.substring(len - 8, len);
    }
}