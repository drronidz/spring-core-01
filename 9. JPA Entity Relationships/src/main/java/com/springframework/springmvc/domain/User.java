package com.springframework.springmvc.domain;

/*
PROJECT NAME : 9. JPA Entity Relationships
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 3/2/2022 2:58 PM
*/

import javax.persistence.*;

@Entity(name = "User")
public class User implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String username;

    @Transient
    // Temporary State element (is not stored in the DB).
    // Bad practice to store an encrypted password into the DB.
    private String password;

    private String encryptedPassword;
    private Boolean enabled = true;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
