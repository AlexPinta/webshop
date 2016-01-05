package dao.api.service;

import dao.api.model.Account;

public interface DaoAccountService {

    public Account getAccount(String userName, String password);
    public boolean createAccount(String userName, String password, String email);
    public Account getProfileInfoByUserId(Integer userId);

}