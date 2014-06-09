package com.depot.app.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDetailsAdapterTest {

    private AccountFactory accountFactory = AccountFactory.instance();
    private AccountDetailsAdapter accountDetailsAdapter;
    private Account account;

    @Before
    public void setUp() {
        this.account = accountFactory.getAccount();
        accountDetailsAdapter = new AccountDetailsAdapter(account);
        accountDetailsAdapter.setPassword("password");
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
        assertEquals("email@email.com", accountDetailsAdapter.getEmail());
        assertEquals("password", accountDetailsAdapter.getPassword());
        assertEquals("phoneNumber", accountDetailsAdapter.getPhoneNumber());
        assertEquals(1, accountDetailsAdapter.getAuthorities().size());
    }

    @After
    public void tearDown(){
        this.account = null;
        this.accountDetailsAdapter = null;
    }

}
