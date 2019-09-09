package com.github.arielgrabijas.server.model.dto;

import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.github.arielgrabijas.server.model.entities.Fellowshipmember;
import com.github.arielgrabijas.server.model.entities.Weapon;

/**
 * Data Transfer Object for Fellowshipmember entity.
 */
@Component
public class MemberDTO {

    private Integer id;

    private Date joined;

    private String name;

    private String race;

    private Collection<Weapon> weapons;

    private Integer version;

    public MemberDTO() {

    }

    public MemberDTO(Fellowshipmember member) {
        this.id = member.getId();
        this.joined = member.getJoined();
        this.name = member.getName();
        this.race = member.getRace();
        this.weapons = member.getWeapontype();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJoined() {
        return this.joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Collection<Weapon> getWeapontype() {
        return this.weapons;
    }

    public void setWeapontype(Collection<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}