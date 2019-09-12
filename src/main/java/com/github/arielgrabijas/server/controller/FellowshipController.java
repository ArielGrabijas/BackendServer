package com.github.arielgrabijas.server.controller;

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

import com.github.arielgrabijas.server.model.dto.MemberDTO;
import com.github.arielgrabijas.server.service.FellowshipService;

@RestController
@RequestMapping("fellowship")
public class FellowshipController {

    @Autowired
    private FellowshipService service;

    @GetMapping("/member")
    public ResponseEntity<List<MemberDTO>> getMembers() {
        List<MemberDTO> members = service.getMembers();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberDTO> getMember(@PathVariable Integer id) {
        MemberDTO member = service.getMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PostMapping("/member")
    public ResponseEntity<String> saveMember(@RequestBody MemberDTO newMember) {
        service.saveMember(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body("member created");
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<String> updateMember(@RequestBody MemberDTO fullyUpdatedMember, @PathVariable Integer id) {
        fullyUpdatedMember.setId(id);
        service.fullyUpdateMember(fullyUpdatedMember);
        return ResponseEntity.status(HttpStatus.OK).body("member updated");
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Integer id) {
        service.deleteMember(id);
        return ResponseEntity.status(HttpStatus.OK).body("member deleted");
    }
}