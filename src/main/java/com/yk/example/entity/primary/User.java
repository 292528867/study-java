package com.yk.example.entity.primary;


import com.yk.example.entity.primary.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yk on 15/12/8.
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = -5554308939380869754L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String tel;

    private String remark;

    private String token;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
     joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Role> getRoles() {
        if (roles != null) {
            return new HashSet<Role>(roles);
        }
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
