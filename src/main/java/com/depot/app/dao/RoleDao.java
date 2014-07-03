package com.depot.app.dao;

import com.depot.app.model.Role;

public interface RoleDao extends Dao<Role>{
    Role findByName(String name);
}
