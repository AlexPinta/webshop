package dao.layer.dao.adapter;

import dao.api.model.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts") //, schema = "public", catalog = "webshop")
public class AccountEntity extends Account{
//    private int id;
//    private String userName;
//    private String password;
//    private String email;
//    private Double amount;
//    private Date lastLogin;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "amount", nullable = true, insertable = true, updatable = true)
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "last_login", nullable = false, insertable = true, updatable = true)
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public AccountEntity(String pUserName, String pPassword, String pEmail, Date pLastLogin) {
        userName = pUserName;
        password = pPassword;
        email = pEmail;
        lastLogin = pLastLogin;
    }

    public AccountEntity() {
    }
}
