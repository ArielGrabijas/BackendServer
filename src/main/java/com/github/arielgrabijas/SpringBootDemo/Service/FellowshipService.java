package com.github.arielgrabijas.SpringBootDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.arielgrabijas.SpringBootDemo.Model.Fellowshipmember;
import com.github.arielgrabijas.SpringBootDemo.Repository.FellowshipMemberDAO;

@Service
public class FellowshipService {

	@Autowired
	private FellowshipMemberDAO memberRepo;
	
	public Fellowshipmember getMember(Integer id) {
		return memberRepo.getById(id);
	}

	public List<Fellowshipmember> getMembers(){
		return memberRepo.findAll();
	}
	
	public void saveMember(Fellowshipmember newMember) {
		memberRepo.saveAndFlush(newMember);
	}
	
	public void deleteMember(Integer id) {
		memberRepo.deleteById(id);
	}
	
	public void deleteMembers(List<Integer> ids) {
		memberRepo.deleteAllById(ids);
	}
	
	public void updateMember(Fellowshipmember fullyUpdatedMember) {
		memberRepo.saveAndFlush(fullyUpdatedMember);
	}
}
