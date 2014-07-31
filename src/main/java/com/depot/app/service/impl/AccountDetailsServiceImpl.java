package com.depot.app.service.impl;

import com.depot.app.dao.AccountDao;
import com.depot.app.dao.RoleDao;
import com.depot.app.model.Account;
import com.depot.app.model.Role;
import com.depot.app.service.AccountDetailsService;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.HashSet;
import java.util.Set;

@Transactional(readOnly = true)
@Component
public class AccountDetailsServiceImpl implements AccountDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AccountDetailsServiceImpl.class);

    private AccountDao accountDao;
    private RoleDao roleDao;

    public AccountDetailsServiceImpl() {
    }

    @Autowired
    public AccountDetailsServiceImpl(AccountDao accountDao, RoleDao roleDao) {
        this.accountDao = accountDao;
        this.roleDao = roleDao;
    }

    @Override
    public boolean registerAccount(Account account, String password, Errors errors) {
        validateUsername(account.getUserName(), errors);
        boolean valid = !errors.hasErrors();

        if (valid) {
            Set<Role> roles = new HashSet<Role>();
            roles.add(roleDao.findByName("user"));
            account.setRoles(roles);
            accountDao.create(account, password);
        }

        return valid;
    }

    private void validateUsername(String username, Errors errors) {
        if(accountDao.findByUsername(username) != null ) {
            logger.debug("Validation failed: duplicate username");
            errors.rejectValue("username", "error.duplicate", new String[]{username}, null);
        }

    }

    @Override
    public Account getAccountByUsername(String username) {
        Account account = accountDao.findByUsername(username);
        if (account != null) {
            Hibernate.initialize(account.getRoles());
        }
        return account;
    }
}
