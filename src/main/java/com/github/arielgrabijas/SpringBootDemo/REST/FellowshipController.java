package com.github.arielgrabijas.SpringBootDemo.REST;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.arielgrabijas.SpringBootDemo.Model.Fellowshipmember;
import com.github.arielgrabijas.SpringBootDemo.Service.FellowshipService;

@RestController
@RequestMapping("fellowship")
public class FellowshipController {

	@Autowired
	private FellowshipService service;
	
	@GetMapping("/member")
	public List<Fellowshipmember> getMembers(){
		return service.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public Fellowshipmember getMember(@PathVariable Integer id) {
		return service.getMember(id);
	}
	
	@PostMapping("/member")
	public ResponseEntity<?> saveMember(@RequestBody Fellowshipmember newMember) {
		service.saveMember(newMember);
		return ResponseEntity.created(URI.create(String.format("/member/%d", newMember.getId()))).build();
	}
	
	@PutMapping("/member/{id}")
	public ResponseEntity<?> updateMember2(@RequestBody Fellowshipmember fullyUpdatedMember, @PathVariable Integer id){
		Fellowshipmember member = service.getMember(id);
		if(member == null) {
			service.saveMember(fullyUpdatedMember);
			return ResponseEntity.created(URI.create(String.format("/member/%d", id))).build();
		}
		service.updateMember(fullyUpdatedMember);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/member/{id}")
	public ResponseEntity<?> updateMember(@RequestBody Fellowshipmember updatedMember, @PathVariable Integer id){
		throw new NotYetImplementedException();
		//service.updateMember(updatedMember, id);
		//return ResponseEntity.ok("Fellowship member is updated");
	}
	
	@DeleteMapping("/member/{id}")
	public void deleteMember(@PathVariable Integer id) {
		service.deleteMember(id);
	}
	
	
}