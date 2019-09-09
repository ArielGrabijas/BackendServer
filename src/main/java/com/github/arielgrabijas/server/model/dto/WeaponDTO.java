package com.github.arielgrabijas.server.model.dto;

import com.github.arielgrabijas.server.model.entities.Weapon;

public class WeaponDTO {

    private String name;

    public WeaponDTO(Weapon weapon) {
        name = weapon.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
