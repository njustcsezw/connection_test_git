package com.njustz.dao;

import com.njustz.domain.Account;

import java.util.List;



/**
 * 账户的持久层接口
 */

public interface IAccountDao {

    //查询所有
    List<Account> findAllAccount();

    //查询一个
    Account findAccountById(Integer id);

    //保存
    void saveAccount(Account account);

    //更新
    void updateAccount(Account account);

    //删除
    void deleteAccount(Integer accountId);

    //查询账户
    //如果有唯一的结果就返回，如果没有就返回null，超过一个就抛出异常
    Account findAccountByName(String accountName);
}
