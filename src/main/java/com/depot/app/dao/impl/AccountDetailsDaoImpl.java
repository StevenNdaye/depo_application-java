package com.depot.app.dao.impl;

import com.depot.app.dao.AccountDetailsDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDetailsDaoImpl implements AccountDetailsDao {

    private JdbcTemplate jdbcTemplate;
    private static final String FIND_PASSWORD_SQL = "select password from account where username = ?";

    //Important for the test to pass. Do not remove
    public AccountDetailsDaoImpl() {
    }

    public AccountDetailsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findPasswordByUsername(String username) {
        return jdbcTemplate.queryForObject(FIND_PASSWORD_SQL, new Object[] { username }, String.class);
    }
}
