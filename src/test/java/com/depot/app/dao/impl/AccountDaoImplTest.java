package com.depot.app.dao.impl;

import com.depot.app.dao.AccountDao;
import com.depot.app.model.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AccountDaoImplTest {

    private static final String PASSWORD = "password";
    public static final String USERNAME = "username";
    private JdbcTemplate jdbcTemplate;
    private AbstractDao abstractDao;
    private AccountDao accountDao;
    private Session session;
    private Query query;
    private Query insideQuery;
    private Object object;
    private SessionFactory sessionFactory;
    private static final String UPDATE_PASSWORD_SQL = "update account set password = ? where username = ?";

    private Account account = new Account(){{
       setUserName(USERNAME);
    }};
    private org.hibernate.classic.Session sessionOther;

    @Before
    public void setUp(){
        jdbcTemplate = mock(JdbcTemplate.class);
        abstractDao = mock(AbstractDao.class);
        session = mock(Session.class);
        query = mock(Query.class);
        sessionFactory = mock(SessionFactory.class);
        sessionOther = mock(org.hibernate.classic.Session.class);
        insideQuery = mock(Query.class);
        object = mock(Query.class);
        accountDao = new AccountDaoImpl(jdbcTemplate);
    }

    @Test
    public void itShouldCreateAccount(){
        accountDao.create(account, PASSWORD);
        verify(jdbcTemplate).update(UPDATE_PASSWORD_SQL, PASSWORD, account.getUserName());
    }

    //TODO
    /*@Test
    @Ignore
    public void itShouldFindAccountByUsername() {
        when(sessionFactory.getCurrentSession()).thenReturn(sessionOther);
        when(abstractDao.getSession()).thenReturn(session);
        when(session.getNamedQuery("findAccountByUsername")).thenReturn(query);
        when(query.setParameter("username", USERNAME)).thenReturn(insideQuery);
        when(insideQuery.uniqueResult()).thenReturn(object);

        Account account = accountDao.findByUsername(USERNAME);
        assertEquals(USERNAME, account.getUserName());
    }*/
}
