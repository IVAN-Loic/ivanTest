package com.humbertomattos.restCRUDSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humbertomattos.restCRUDSpringBoot.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  List<Person> findByActived(boolean actived);

  List<Person> findByEmailContaining(String email);
}
