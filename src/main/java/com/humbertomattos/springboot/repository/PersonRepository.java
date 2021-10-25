package com.humbertomattos.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humbertomattos.springboot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  List<Person> findByActived(boolean actived);

  List<Person> findByEmailContaining(String email);
}
