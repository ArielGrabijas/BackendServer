package com.github.arielgrabijas.server.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.github.arielgrabijas.server.model.dto.WeaponDTO;

@Entity
public class Weapon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_weapon")
    private Integer id;

    @NotNull
    private String name;

    @Column(name = "fellowshipmember_id")
    private Integer fellowshipMemberId;

    @Version
    private Integer version;

    public Weapon() {
    }

    public Weapon(WeaponDTO weapon) {
        id = weapon.getWeaponId();
        name = weapon.getName();
        fellowshipMemberId = weapon.getFellowshipMemberId();
        version = weapon.getVersion();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getFellowshipMemberId() {
        return fellowshipMemberId;
    }

    public void setFellowshipMemberId(Integer fellowshipMemberId) {
        this.fellowshipMemberId = fellowshipMemberId;
    }

}
