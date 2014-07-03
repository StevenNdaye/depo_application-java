package com.depot.app.service;

import com.depot.app.model.Account;
import org.springframework.validation.Errors;

public interface AccountDetailsService {
    boolean registerAccount(Account account, String password, Errors errors);
    Account getAccountByUsername(String username);
}
