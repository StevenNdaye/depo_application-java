package com.depot.app.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
public class AccountDetailsAdapter implements UserDetails {
    private Account account;
    private String password;

    public AccountDetailsAdapter(Account account) { this.account = account; }

    public Account getAccount() { return account; }

    public Integer getId() { return account.getAccountId(); }

    public String getFirstName() { return account.getFirstName(); }

    public String getLastName() { return account.getLastName(); }

    public String getEmail() { return account.getEmail(); }

    public String getPhoneNumber() { return account.getPhoneNumber(); }


    public boolean isFlagActive() { return account.isActiveFlag(); }

    @Override
    public String getUsername() { return account.getUserName(); }

    @Override
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return account.isActiveFlag(); }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (Role role : account.getRoles()) {
            authorities.add(new GrantedAuthorityImpl(role.getName()));
        }
        return authorities;
    }

    public String getFullName() {
        return account.getFirstName()+ " " +account.getLastName();
    }

    public boolean isAdmin() {
        Collection<Role> accountRoles = account.getRoles();
        for (Role role : accountRoles) {
            if(role.getName().equals("admin")){
                return true;
            }
        }
        return false;
    }
}