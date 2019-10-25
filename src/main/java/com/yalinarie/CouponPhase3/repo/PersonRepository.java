package com.yalinarie.CouponPhase3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yalinarie.CouponPhase3.Bean.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	public List<Person> findPersonsByAge(int age);

	public List<Person> findPersonsByName(String name);

	@Query("select per from Person per where per.age >= ?1 and per.age <= ?2")
	public List<Person> findPersosnBetweenAge(int from, int to);

	public List<Person> findPersonsByAgeGreaterThan(int age);

	public List<Person> findPersonByAgeAndName(int age, String name);

}