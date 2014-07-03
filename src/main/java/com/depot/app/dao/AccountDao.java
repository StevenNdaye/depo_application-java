package com.depot.app.dao;

import com.depot.app.model.Account;

public interface AccountDao extends Dao<Account>{
    void create(Account account, String password);
    Account findByUsername(String username);
}
