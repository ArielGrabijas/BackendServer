package com.github.arielgrabijas.server.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.github.arielgrabijas.server.model.dto.Member;

import java.util.Date;


/**
 * The persistent class for the fellowshipmember database table.
 */
@Entity
public class Fellowshipmember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date joined;

	@NotNull
	private String name;

	private String race;

	private String weapontype;

	public Fellowshipmember() {
		
	}
	
	public Fellowshipmember(Member member) {
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
}