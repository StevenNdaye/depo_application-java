package com.depot.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class AccountDetailsAdapterTest {

    private AccountFactory accountFactory = AccountFactory.instance();
    private AccountDetailsAdapter accountDetailsAdapter;
    private Account account;

    @Before
    public void setUp() {
        this.account = accountFactory.getAccount();
        account.setRoles(getRoles());
        accountDetailsAdapter = new AccountDetailsAdapter(account);
        accountDetailsAdapter.setPassword("password");
    }

    private Collection<Role> getRoles() {
        Collection<Role> roles = new ArrayList<Role>();
        Role role  = new Role();
        role.setName("admin");
        roles.add(role);
        return roles;
    }

    @Test
    public void itShouldCreateAccountDetailsAdapter() {
        assertSame(account, accountDetailsAdapter.getAccount());
        assertTrue(accountDetailsAdapter.isEnabled());
        assertTrue(accountDetailsAdapter.isAccountNonExpired());
        assertTrue(accountDetailsAdapter.isAccountNonLocked());
        assertTrue(accountDetailsAdapter.isCredentialsNonExpired());
        assertTrue(accountDetailsAdapter.isFlagActive());
        assertEquals("firstName", accountDetailsAdapter.getFirstName());
        assertEquals("lastName", accountDetailsAdapter.getLastName());
        assertEquals("firstName lastName", accountDetailsAdapter.getFullName());
        assertEquals("email@email.com", accountDetailsAdapter.getEmail());
        assertEquals("password", accountDetailsAdapter.getPassword());
        assertEquals("phoneNumber", accountDetailsAdapter.getPhoneNumber());
        assertEquals(1, accountDetailsAdapter.getAuthorities().size());
    }

    @Test
    public void itShouldAssertThatUserIsAdmin(){
        assertTrue(accountDetailsAdapter.isAdmin());
    }

    @After
    public void tearDown(){
        this.account = null;
        this.accountDetailsAdapter = null;
    }

}
