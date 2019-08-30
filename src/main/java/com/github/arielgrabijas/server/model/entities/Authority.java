package com.github.arielgrabijas.server.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author noran
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "role")
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "authoritiesCollection")
    private List<CustomUser> users = new ArrayList<>();

    public Authority() {
    }

    @Override
    public String getAuthority() {
        return this.role;
    }

    public Authority(Integer id) {
        this.id = id;
    }

    public Authority(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsers(List<CustomUser> users) {
        this.users = users;
    }
}
