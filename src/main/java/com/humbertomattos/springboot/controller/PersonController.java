package com.humbertomattos.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.humbertomattos.springboot.model.Person;
import com.humbertomattos.springboot.repository.PersonRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String email) {
		try {
			List<Person> persons = new ArrayList<Person>();

			if (email == null)
				personRepository.findAll().forEach(persons::add);
			else
				personRepository.findByEmailContaining(email).forEach(persons::add);

			if (persons.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(persons, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
		Optional<Person> personData = personRepository.findById(id);

		if (personData.isPresent()) {
			return new ResponseEntity<>(personData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		try {
			Person _person = personRepository
					.save(new Person(person.getName(), person.getEmail(), false));
			return new ResponseEntity<>(_person, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
		Optional<Person> personData = personRepository.findById(id);

		if (personData.isPresent()) {
			Person _person = personData.get();
			_person.setName(person.getName());
			_person.setEmail(person.getEmail());
			_person.setActived(person.isActived());
			return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/persons/{id}")
	public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
		try {
			personRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/persons")
	public ResponseEntity<HttpStatus> deleteAllPersons() {
		try {
			personRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/persons/actived")
	public ResponseEntity<List<Person>> findByPublished() {
		try {
			List<Person> persons = personRepository.findByActived(true);

			if (persons.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(persons, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
