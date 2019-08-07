package com.github.arielgrabijas.server.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.arielgrabijas.server.model.dto.Member;
import com.github.arielgrabijas.server.model.entities.Fellowshipmember;
import com.github.arielgrabijas.server.service.FellowshipService;

@RestController
@RequestMapping("fellowship")
public class FellowshipController {

    @Autowired
    private FellowshipService service;

    @GetMapping("/member")
    public List<Member> getMembers() {
        return service.getMembers();
    }

    @GetMapping("/member/{id}")
    public Fellowshipmember getMember(@PathVariable Integer id) {
        return service.getMember(id);
    }

    @PostMapping("/member")
    public ResponseEntity<?> saveMember(@RequestBody Member newMember) {
        service.saveMember(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body("member created");
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<?> updateMember(@RequestBody Member fullyUpdatedMember, @PathVariable Integer id) {
        Fellowshipmember member = service.getMember(id);
        if (member == null) {
            service.saveMember(fullyUpdatedMember);
            return ResponseEntity.created(URI.create(String.format("/member/%d", id))).build();
        }
        service.saveMember(fullyUpdatedMember);
        return ResponseEntity.status(HttpStatus.OK).body("member updated");
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Integer id) {
        service.deleteMember(id);
    }

}