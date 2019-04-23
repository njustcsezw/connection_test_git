package com.njustz.test;

import com.njustz.domain.Account;
import com.njustz.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
        as.transfer("aaa","bbb",100f);
        List<Account> accounts1 = as.findAllAccount();
        for (Account account:accounts1){
            System.out.println(account);
        }
    }

}
