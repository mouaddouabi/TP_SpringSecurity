package com.banksystem.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //private long userId;
    @Id
    private String username;
    private String password;
    private boolean enabled;
    @OneToMany(mappedBy = "user")
    private List<Authorities> authorities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
