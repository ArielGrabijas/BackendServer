package com.github.arielgrabijas.SpringBootDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.arielgrabijas.SpringBootDemo.Model.Fellowshipmember;

@Repository
public interface FellowshipMemberDAO extends JpaRepository<Fellowshipmember, Integer>{
    /*
	    Implementation of this interface is injected by Spring at runtime.
	    They are already implemented by Spring Data JPA’s SimpleJpaRepository. 
	    You will now be able to use JpaRepository’s methods like save(), findOne(), findAll(), count(), delete() etc.
    */
	
	Fellowshipmember getById(Integer id);

	void deleteAllById(List<Integer> id);
}
