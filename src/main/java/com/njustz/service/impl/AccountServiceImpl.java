package com.njustz.service.impl;

import com.njustz.dao.IAccountDao;
import com.njustz.domain.Account;
import com.njustz.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {



    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //1.根据名称查询转出账户，转入账户
        Account account1 = accountDao.findAccountByName(sourceName);
        Account account2 = accountDao.findAccountByName(targetName);
        //2.转出减钱，转入加钱
        account1.setMoney(account1.getMoney() - money);
        account2.setMoney(account2.getMoney() + money);
        //更新转出和转入账户
        accountDao.updateAccount(account1);
        accountDao.updateAccount(account2);

    }
}
