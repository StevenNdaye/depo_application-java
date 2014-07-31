package com.depot.app.dao.impl;

import com.depot.app.dao.AccountDao;
import com.depot.app.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao{

    private static final Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);
    private static final String UPDATE_PASSWORD_SQL = "update account set password = ? where username = ?";

    private JdbcTemplate jdbcTemplate;

    public AccountDaoImpl() {
    }

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Account account, String password) {
        jdbcTemplate.update(UPDATE_PASSWORD_SQL, password, account.getUserName());
    }

    @Override
    public Account findByUsername(String username) {
        return (Account) getSession()
                .getNamedQuery("findAccountByUsername")
                .setParameter("username", username)
                .uniqueResult();
    }
}
