package cn.lu.learn.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
@Getter
@Setter
@ToString
public class User {

    private String userUuid;

    private String userMobile;

    private Integer userType;

    private String userPayPassword;

    private Integer userStatus;

    private Integer userTradeStatus;

    private Integer deleteFlag;

    private Date createTime;

    private Date updateTime;
}
