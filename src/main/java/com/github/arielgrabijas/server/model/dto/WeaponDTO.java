package com.github.arielgrabijas.server.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.arielgrabijas.server.model.entities.Weapon;

public class WeaponDTO {

    private Integer weaponId;

    private String name;

    private Integer version;

    @JsonIgnore
    private Integer fellowshipMemberId;

    public WeaponDTO() {
    }

    public WeaponDTO(Weapon weapon) {
        weaponId = weapon.getId();
        name = weapon.getName();
        version = weapon.getVersion();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Integer weaponId) {
        this.weaponId = weaponId;
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
