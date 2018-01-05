package cn.lu.learn.demo2;

import cn.lu.learn.entity.User;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
@RestController
@RequestMapping("dbcp")
public class DbcpController {

    private final Logger logger = LoggerFactory.getLogger(DbcpController.class);

    private DruidDataSource dataSource;

    public DbcpController() {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("zj_admin");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://10.10.10.174:3306/luth?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10);
    }

    @RequestMapping("/query")
    public User query(@RequestParam String userUuid) {
        if (Strings.isNullOrEmpty(userUuid)) {
            return null;
        }

        return getUser(userUuid);
    }

    private User getUser(String userUuid) {
        Connection connection = getConnection();
        if (null == connection) {
            return null;
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select user_uuid, user_mobile, user_type, user_pay_password, user_status, user_trade_status, " +
                "delete_flag, create_time, update_time from `user` where user_uuid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, userUuid);
            rs = ps.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setUserUuid(rs.getString("user_uuid"));
                user.setUserMobile(rs.getString("user_mobile"));
                user.setUserType(rs.getInt("user_type"));
                user.setUserPayPassword(rs.getString("user_pay_password"));
                user.setUserStatus(rs.getInt("user_status"));
                user.setUserTradeStatus(rs.getInt("user_trade_status"));
                user.setDeleteFlag(rs.getInt("delete_flag"));
                user.setCreateTime(rs.getDate("create_time"));
                user.setUpdateTime(rs.getDate("update_time"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }

                if (null != ps) {
                    ps.close();
                }

                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }

        return null;
    }

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return null;
    }

}
