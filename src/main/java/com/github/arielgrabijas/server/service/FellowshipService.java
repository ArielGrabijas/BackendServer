package com.github.arielgrabijas.server.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.arielgrabijas.server.model.dto.Member;
import com.github.arielgrabijas.server.model.entities.Fellowshipmember;
import com.github.arielgrabijas.server.repository.FellowshipMemberDAO;

@Service
public class FellowshipService {

	@Autowired
	private FellowshipMemberDAO memberRepository;
	
	public Fellowshipmember getMember(Integer id) {
		return memberRepository.getById(id);
	}

	public List<Member> getMembers(){
		List<Fellowshipmember> entityMemebers = memberRepository.findAll();
		
		return entityMemebers.stream()
				.map(entity -> new Member(entity))
				.collect(Collectors.toList());
	}
	
	public void saveMember(Member newMember) {
		memberRepository.saveAndFlush(new Fellowshipmember(newMember));
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
