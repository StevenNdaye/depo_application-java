package com.depot.app.model;


import javax.persistence.*;

@Entity
@Table(name = "role")
@NamedQuery(name = "findRoleByName", query = "from Role where name= :name")
public class Role {
    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() { return id; }

    @SuppressWarnings("unused")
    private void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
