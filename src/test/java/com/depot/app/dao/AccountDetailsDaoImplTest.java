package com.depot.app.dao;

import com.depot.app.dao.impl.AccountDetailsDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountDetailsDaoImplTest{

    public static final String QUERY = "select password from account where username = ?";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    private AccountDetailsDao accountDetailsDao;
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp(){
        jdbcTemplate = mock(JdbcTemplate.class);
        this.accountDetailsDao = new AccountDetailsDaoImpl(jdbcTemplate);
        MockitoAnnotations.initMocks(accountDetailsDao);
    }

    @Test
    public void itShouldRetrievePasswordBasedOnUsername(){
        when(jdbcTemplate.queryForObject(QUERY,
                new Object[] {USERNAME}, String.class)).thenReturn(PASSWORD);
        assertEquals(PASSWORD, accountDetailsDao.findPasswordByUsername(USERNAME));
    }
}
