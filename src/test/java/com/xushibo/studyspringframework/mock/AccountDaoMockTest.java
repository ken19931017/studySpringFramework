package com.xushibo.studyspringframework.mock;

import com.xushibo.studyspringframework.di.beans.AccountDao;
import com.xushibo.studyspringframework.di.beans.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountDaoMockTest {

    @Mock
    private AccountDao accountDao;

    @InjectMocks
    private AccountDao accountDaoIn;
    /**
     * 打桩
     * */
    @Test public void testStubbing(){

       when(accountDao.getAccountAmount()).thenReturn(1000l);
       System.out.println(accountDao.getAccountAmount());

    }

    /**
     * 注入mock对象
     * */
    @Test public void testInject(){
        accountDaoIn.setAccountAmount(10l);
        accountDaoIn.setAccountName("xushibo");

        System.out.println(accountDaoIn.getAccountName());
        System.out.println(accountDaoIn.getAccountAmount());

    }

}
