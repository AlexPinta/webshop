package dao.api.service;

import dao.api.model.Account;

import java.util.List;

public interface DaoAccountService {

    Account getAccount(String userName, String password);
    boolean createAccount(String userName, String password, String email);
    Account getProfileInfoByUserId(Integer userId);
    List<? extends Account> getListOfAccounts();
}