package com.yk.example.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yk on 16/6/3.
 */
@Entity
@Table(name = "t_user_relation")
@JsonIgnoreProperties("new")
public class UserRelation extends AbstractPersistable<Long> {

  private String tel;
  private String address;
  private int age;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
