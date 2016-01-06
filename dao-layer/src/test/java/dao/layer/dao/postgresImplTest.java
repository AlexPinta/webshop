package dao.layer.dao;

import dao.api.model.Account;
import dao.api.service.DaoAccountService;
import dao.layer.dao.adapter.AccountEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class postgresImplTest {
    @Autowired
    DaoAccountService daoAccountService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetAccount() throws Exception {
        boolean creationStatus = daoAccountService.createAccount("test", "test", "test");
        List<? extends Account> accounts = daoAccountService.getListOfAccounts();

        Assert.assertEquals("test", ((AccountEntity) accounts.get(0)).getUserName());
        Assert.assertEquals("test", ((AccountEntity) accounts.get(0)).getPassword());
        Assert.assertEquals("test", ((AccountEntity) accounts.get(0)).getEmail());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateAccount() throws Exception {
        boolean creationStatus = daoAccountService.createAccount("test", "test", "test");
        List<? extends Account> accounts = daoAccountService.getListOfAccounts();
        Assert.assertEquals(1, accounts.size());
        Assert.assertTrue(creationStatus);
    }
    @Test
    @Transactional
    @Rollback(true)
    public void testCreateAccountTwice() throws Exception {
        boolean creationStatus = daoAccountService.createAccount("test", "test", "test");

        creationStatus = daoAccountService.createAccount("test", "test", "test");
        Assert.assertFalse(creationStatus);
        List<? extends Account> accounts = daoAccountService.getListOfAccounts();
        Assert.assertEquals(1, accounts.size());

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetProfileInfoByUserId() throws Exception {
        boolean creationStatus = daoAccountService.createAccount("test", "test", "test");
        List<? extends Account> accounts = daoAccountService.getListOfAccounts();
        Assert.assertEquals(((AccountEntity) accounts.get(0)).getId(), ((AccountEntity)daoAccountService.getProfileInfoByUserId(((AccountEntity) accounts.get(0)).getId())).getId());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetListOfAccounts() throws Exception {
        boolean creationStatus = daoAccountService.createAccount("test", "test", "test");
        creationStatus = daoAccountService.createAccount("test2", "test2", "test2");
        List<? extends Account> accounts = daoAccountService.getListOfAccounts();
        Assert.assertEquals(2, accounts.size());
    }

}