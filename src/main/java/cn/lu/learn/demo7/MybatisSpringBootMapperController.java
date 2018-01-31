package cn.lu.learn.demo7;

import cn.lu.learn.dto.PayDTO;
import cn.lu.learn.entity.Account;
import cn.lu.learn.entity.Pay;
import cn.lu.learn.mapper.AccountMapper;
import cn.lu.learn.mapper.PayMapper;
import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lutiehua
 * @date 2018/1/16
 */
@RestController
@RequestMapping("mybatis/spring/boot/mapper")
public class MybatisSpringBootMapperController {

    private final Logger logger = LoggerFactory.getLogger(MybatisSpringBootMapperController.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PayMapper payMapper;

//    @Autowired
//    private UserMapper2 userMapper;
//
//    @RequestMapping("/query")
//    public User query(@RequestParam String userUuid) {
//        if (Strings.isNullOrEmpty(userUuid)) {
//            return null;
//        }
//
//        return userMapper.selectByPrimaryKey(userUuid);
//    }

    @PostMapping("/pay")
    public long insertPay(PayDTO payDTO) {
        payDTO.setOrderBillCode("WDX201709071459015050410");
        payDTO.setUserUuid("418a3d76b4284431bd884e7b9ebf950b");
        payDTO.setProductUuid("a7bfa016845e4d2ca31a3a26f7524e67");
        payDTO.setPayAmount(new BigDecimal("1000"));
        payDTO.setPayStatus(0);
        payDTO.setPayType(3);
        String jsonString = JSON.toJSONString(payDTO);
        Pay pay = JSON.parseObject(jsonString, Pay.class);
//        return payMapper.insert(pay);
        payMapper.insertSelective(pay);


        Pay pay1 = new Pay();
        pay.setOrderBillCode("1123");
        payMapper.select(pay);

        Example condition = new Example(Account.class);

        payMapper.selectByExample(condition);



        return pay.getPayId();
    }

//
//    @GetMapping("/account/query")
//    public PageInfo<Account> queryAccount() {
//        // 分页（第几页，每页多少条数据），
//        PageHelper.startPage(1, 5);
//
//        // 排序
////        PageHelper.orderBy("user_uuid DESC");
//
//        // 只有相等的查询条件
////        Account account = new Account();
////        account.setAccountType("21");
////        account.setAccountStatus(1);
////        List<Account> accountList = accountMapper.select(account);
//
//        // 复杂的查询条件
////        Example condition = new Example(Account.class);
////        condition.createCriteria().andEqualTo("accountType", "21").andEqualTo("accountStatus", "1").
////                andGreaterThanOrEqualTo("accountAmount", "10000");
////        List<Account> accountList = accountMapper.selectByExample(condition);
//
//        //
//        Example condition = new Example(Account.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria = criteria.andEqualTo("accountType", "21").andEqualTo("accountStatus", "1").
//                andGreaterThanOrEqualTo("accountAmount", "10000");
//        condition.setOrderByClause("user_uuid DESC");
//        List<Account> accountList = accountMapper.selectByExample(condition);
//
//        // 构造结果集
//        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
//        return pageInfo;
//    }

    @GetMapping("/account/{accountUuid}")
    public Account getAccount(@PathVariable String accountUuid) {
        accountMapper.deleteById(accountUuid);
        return accountMapper.selectById(accountUuid);
    }
}
