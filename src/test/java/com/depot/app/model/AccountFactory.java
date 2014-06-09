package com.depot.app.model;

import java.util.HashSet;
import java.util.Set;

public final class AccountFactory {

    private static final AccountFactory accountFactory = new AccountFactory();
    public static AccountFactory instance() {
        return accountFactory;
    }

    public Account getAccount(){
        Account account = new Account();
        account.setAccountId(1);
        account.setActiveFlag(true);
        account.setEmail("email@email.com");
        account.setFirstName("firstName");
        account.setLastName("lastName");
        account.setPassWord("password");
        account.setPhoneNumber("phoneNumber");
        account.setRoles(createRole());
        return account;
    }

    private Set<Role> createRole() {
        Set<Role> roles = new HashSet<Role>();
        Role role = new Role();
        role.setName("name");
        roles.add(role);
        return roles;
    }

}
