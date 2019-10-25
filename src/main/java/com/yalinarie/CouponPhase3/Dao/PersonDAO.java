package com.yalinarie.CouponPhase3.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yalinarie.CouponPhase3.Bean.Person;
import com.yalinarie.CouponPhase3.repo.PersonRepository;

@Repository
public class PersonDAO {

	@Autowired
	private PersonRepository repo; // interface of JPA

	public void addPerson(Person p) {
		if (p.getAge() >= 0 && p.getAge() <= 120) {
			repo.save(p);
		}

	}

	public Iterable<Person> getAll() {
		return repo.findAll();
	}

	public Iterable<Person> getPersonBetweanAges(int from, int to) {
		return repo.findPersosnBetweenAge(from, to);
	}

	public Iterable<Person> findPersonByAgeandname(int age, String name) {
		return repo.findPersonByAgeAndName(age, name);
	}

	public Iterable<Person> getPersonOlderThan(int from) {
		return repo.findPersonsByAgeGreaterThan(from);
	}

}