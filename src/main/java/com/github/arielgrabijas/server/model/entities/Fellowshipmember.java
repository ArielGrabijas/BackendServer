package com.github.arielgrabijas.server.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OptimisticLock;
import org.springframework.data.annotation.Version;

import com.github.arielgrabijas.server.model.dto.MemberDTO;

/**
 * The persistent class for the fellowshipmember database table.
 */
@Entity
// @DynamicUpdate(value = true) /// ???
public class Fellowshipmember implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @OptimisticLock(excluded = true) // modyfikacja tego pola nie będzie wpływała na zmianę wersji obiektu w bazie.
    private Date joined;

    @NotNull
    private String name;

    private String race;

    private String weapontype;

    // adnotacja dla hibernate, jej celem jest porównanie wersji zmodyfikowanego przez frontend obiektu z wersją obiektu w bazie danych.
    // Jeżeli te wersje są zgodne, to znaczy że nikt inny nie zmienił wersji w międzyczasie. Podskórnie zakładana jest transakcja która
    // atomowo odczytuje wersję z bazy, porównuje ją z tą która przyszła i jeśli są zgodne to robi commita
    @Version
    private Integer version;

    public Fellowshipmember() {

    }

    public Fellowshipmember(MemberDTO member) {
        this.id = member.getId();
        this.joined = member.getJoined();
        this.name = member.getName();
        this.race = member.getRace();
        this.weapontype = member.getWeapontype();
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

    public String getWeapontype() {
        return this.weapontype;
    }

    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}