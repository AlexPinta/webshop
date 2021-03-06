package dao.layer.dao;

import dao.api.model.Account;
import dao.api.service.DaoAccountService;
import dao.layer.dao.adapter.AccountEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class postgresImpl implements DaoAccountService{
    private EntityManager entityManager;

    @Override
    public Account getAccount(String userName, String password) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from AccountEntity where userName = :userName and password = :password");
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        AccountEntity result = (AccountEntity)query.getSingleResult();
        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    public boolean createAccount(String userName, String password, String email) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from AccountEntity where email = :email");
        query.setParameter("email", email);

        boolean checkAbility = query.getResultList().size() == 0;
        if (checkAbility){
            entityManager.persist(new AccountEntity(userName, password, email, new Date()));
        }
        entityManager.getTransaction().commit();
        return checkAbility;
    }

    @Override
    public Account getProfileInfoByUserId(Integer userId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from AccountEntity where id = :id");
        query.setParameter("id", userId);
        AccountEntity result = (AccountEntity)query.getSingleResult();
        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    public List<? extends Account> getListOfAccounts() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from AccountEntity", AccountEntity.class);
        List<AccountEntity> result = query.getResultList();
        entityManager.getTransaction().commit();
//        entityManager.close();
        return result;
    }

    public postgresImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public postgresImpl() {
    }
}