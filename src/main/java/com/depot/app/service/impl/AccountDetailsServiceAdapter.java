package com.depot.app.service.impl;

import com.depot.app.dao.AccountDetailsDao;
import com.depot.app.model.Account;
import com.depot.app.model.AccountDetailsAdapter;
import com.depot.app.service.AccountDetailsService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountDetailsServiceAdapter")
@Transactional(readOnly = true)
public class AccountDetailsServiceAdapter implements UserDetailsService {

    private AccountDetailsService accountDetailsService;
    private AccountDetailsDao accountDetailsDao;

    public AccountDetailsServiceAdapter(AccountDetailsService accountDetailsService, AccountDetailsDao accountDetailsDao) {
        this.accountDetailsService = accountDetailsService;
        this.accountDetailsDao = accountDetailsDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        Account account = accountDetailsService.getAccountByUsername(username);

        if(account == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        } else if (account.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("User "+ username + " has no authorities");
        }
        AccountDetailsAdapter accountDetailsAdapter = new AccountDetailsAdapter(account);
        accountDetailsAdapter.setPassword(accountDetailsDao.findPasswordByUsername(username));
        return accountDetailsAdapter;
    }
}
