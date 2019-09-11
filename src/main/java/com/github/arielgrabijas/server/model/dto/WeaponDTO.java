package com.github.arielgrabijas.server.model.dto;

import com.github.arielgrabijas.server.model.entities.Weapon;

public class WeaponDTO {

    private Integer weaponId;

    private String name;

    private Integer fellowshipMemberId;

    private Integer version;

    public WeaponDTO() {
    }

    public WeaponDTO(Weapon weapon) {
        weaponId = weapon.getId();
        name = weapon.getName();
        fellowshipMemberId = weapon.getId();
        version = weapon.getId();
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

    public Integer getFellowshipMemberId() {
        return fellowshipMemberId;
    }

    public void setFellowshipMemberId(Integer fellowshipMemberId) {
        this.fellowshipMemberId = fellowshipMemberId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
