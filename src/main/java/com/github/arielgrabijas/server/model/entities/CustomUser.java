package com.github.arielgrabijas.server.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author noran
 */
@Entity
@Table(name = "custom_user")
public class CustomUser implements Serializable, UserDetails {

    /*
     * User can only have one role, ROLE_FREE or ROLE_PREMIUM
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    // ManyToMany uses third table user_authorities which is defined in database only.
    // http://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-annotations-example
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Authority> authoritiesCollection;

    public CustomUser() {
    }

    public CustomUser(Integer id) {
        this.id = id;
    }

    public CustomUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // UserDetails methods:

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Authority are defined in database 'authorities' table
        Set<GrantedAuthority> authorities = new HashSet<>();
        this.authoritiesCollection.stream().forEach(authorities::add);
        return authorities;
    }

    public boolean isFree() {
        return hasRole("ROLE_FREE");
    }

    private boolean hasRole(String role) {
        for (GrantedAuthority a : getAuthorities())
            if (a.getAuthority().equals(role))
                return true;
        return false;
    }

    public void setRolePremium() {
        addRole("ROLE_PREMIUM");
    }

    public void setRoleFree() {
        addRole("ROLE_FREE");
    }

    private void addRole(String newRole) {
        /*
         * Assigns new role to user. User can have only one role at a time. Therefore whenever we want to assign new role to user, old role will have
         * to be removed.
         */
        boolean isAlreadySet = false;
        for (GrantedAuthority a : getAuthorities()) {
            if (a.getAuthority().equals(newRole))
                isAlreadySet = true;
            else
                authoritiesCollection.remove(a);
        }

        if (!isAlreadySet) {
            Authority newAuthority = new Authority();
            newAuthority.setRole(newRole);
            authoritiesCollection.add(newAuthority);
        }
    }
}
