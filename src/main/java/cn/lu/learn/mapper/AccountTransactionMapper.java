package cn.lu.learn.mapper;

import cn.lu.learn.entity.AccountTransaction;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AccountTransactionMapper extends Mapper<AccountTransaction> {

    int restore(AccountTransaction accountTransaction);
}