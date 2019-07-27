package com.github.arielgrabijas.SpringBootDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.arielgrabijas.SpringBootDemo.Model.Fellowshipmember;
import com.github.arielgrabijas.SpringBootDemo.Repository.FellowshipMemberDAO;

@Service
public class FellowshipService {

	@Autowired
	private FellowshipMemberDAO memberRepository;
	
	public Fellowshipmember getMember(Integer id) {
		return memberRepository.getById(id);
	}

	public List<Fellowshipmember> getMembers(){
		return memberRepository.findAll();
	}
	
	public void saveMember(Fellowshipmember newMember) {
		memberRepository.saveAndFlush(newMember);
	}
	
	public void deleteMember(Integer id) {
		memberRepository.deleteById(id);
	}
	
	public void deleteManyMembers(List<Integer> ids) {
		memberRepository.deleteAllById(ids);
	}
	
	public void fullyUpdateMember(Fellowshipmember updatedMember) {
		memberRepository.saveAndFlush(updatedMember);
	}
}
