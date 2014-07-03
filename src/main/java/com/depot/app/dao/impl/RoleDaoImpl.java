package com.depot.app.dao.impl;

import com.depot.app.dao.RoleDao;
import com.depot.app.model.Role;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao{

    @Override
    public Role findByName(String name) {
        Query query = getSession().getNamedQuery("findRoleByName");
        query.setParameter("name", name);
        return (Role)query.uniqueResult();
    }
}
