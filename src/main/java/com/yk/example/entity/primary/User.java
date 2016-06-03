package com.yk.example.entity.primary;


import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yk on 15/12/8.
 */
@Entity
@Table(name = "t_user")
@JsonFilter("user")
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //只是一个优化
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return this.id == user.getId();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = (int) (PRIME * result + getId());
        return result;
    }
/*
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();

        user.setId(100);
        user1.setId(100);

        System.out.println(user.equals(user1));


        Set<User> users = new HashSet<User>();
        users.add(user);
        users.add(user1);
        System.out.println(users);

    }*/
}
