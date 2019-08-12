package com.github.arielgrabijas.server.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.arielgrabijas.server.model.dto.Member;
import com.github.arielgrabijas.server.model.entities.Fellowshipmember;
import com.github.arielgrabijas.server.repository.FellowshipMemberDAO;

@Service
public class FellowshipService {

    @Autowired
    private FellowshipMemberDAO memberRepository;

    public Member getMember(Integer id) {
        return new Member(memberRepository.getById(id));
    }

    public List<Member> getMembers() {
        List<Fellowshipmember> entityMemebers = memberRepository.findAll();

        return entityMemebers.stream()
                .map(entity -> new Member(entity))
                .collect(Collectors.toList());
    }

    public void saveMember(Member newMember) {
        memberRepository.saveAndFlush(new Fellowshipmember(newMember));
    }

    @Transactional
    public void saveMembers(Collection<Member> members) {
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

    public void fullyUpdateMember(Member updatedMember) {
        memberRepository.saveAndFlush(new Fellowshipmember(updatedMember));
    }
}