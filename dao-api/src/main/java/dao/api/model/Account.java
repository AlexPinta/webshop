package dao.api.model;

import java.util.Date;

public abstract class Account {
    protected int id;
    protected String userName;
    protected String email;
    protected String password;
    protected float amount;
    protected Date lastLogin;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (userName != null ? !userName.equals(account.userName) : account.userName != null) return false;
        if (email != null ? !email.equals(account.email) : account.email != null) return false;
//        if (password != null ? !password.equals(account.password) : account.password != null) return false;
//        if (lastLogin != null ? !lastLogin.equals(account.lastLogin) : account.lastLogin != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        return result;
    }
}