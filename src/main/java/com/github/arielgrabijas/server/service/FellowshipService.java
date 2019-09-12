package com.github.arielgrabijas.server.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.arielgrabijas.server.model.dto.MemberDTO;
import com.github.arielgrabijas.server.model.entities.Fellowshipmember;
import com.github.arielgrabijas.server.model.entities.Weapon;
import com.github.arielgrabijas.server.repository.FellowshipMemberDAO;

@Service

public class FellowshipService {

    @Autowired
    private FellowshipMemberDAO memberRepository;

    public MemberDTO getMember(Integer id) {
        Fellowshipmember member = memberRepository.getById(id);

        return new MemberDTO(member);
    }

    public List<MemberDTO> getMembers() {
        List<Fellowshipmember> entityMemebers = memberRepository.findAll();

        return entityMemebers.stream()
                .map(entity -> new MemberDTO(entity))
                .collect(Collectors.toList());
    }

    public void saveMember(MemberDTO newMember) {
        memberRepository.saveAndFlush(new Fellowshipmember(newMember));
    }

    @Transactional
    public void saveMembers(Collection<MemberDTO> members) {
        Collection<Fellowshipmember> fellowshipMembers = members.stream()
                .map(member -> new Fellowshipmember(member))
                .collect(Collectors.toList());

        memberRepository.saveAll(fellowshipMembers);
    }

    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

    public void deleteManyMembers(List<Integer> ids) {
        memberRepository.deleteAllById(ids);
    }

    public void fullyUpdateMember(MemberDTO updatedMember) {
        Fellowshipmember member = new Fellowshipmember();
        member.setId(updatedMember.getId());
        member.setName(updatedMember.getName());
        member.setRace(updatedMember.getRace());
        member.setJoined(updatedMember.getJoined());
        member.setVersion(updatedMember.getVersion());

        Collection<Weapon> weapons = updatedMember.getWeapons().stream()
                .map(weaponDto -> new Weapon(weaponDto))
                .collect(Collectors.toList());

        weapons.stream()
                .forEach(weaponEntity -> weaponEntity.setFellowshipMemberId(member.getId()));
        member.setWeapons(weapons);

        memberRepository.saveAndFlush(member);
    }
}