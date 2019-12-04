package com.yalinarie.CouponPhase3.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yalinarie.CouponPhase3.Bean.User;
import com.yalinarie.CouponPhase3.repo.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initDB() {
		repository.deleteAll();
		List<User> users = new ArrayList<>();
		users.add(new User(123, "Kobi", "Java", 31));
		users.add(new User(201, "Moshe", "Java", 24));
		users.add(new User(201, "Dina", "NodeJS", 29));
		users.add(new User(201, "Adi", "Java", 45));

		repository.saveAll(users);
	}

	public List<User> getUsers() {
		return repository.findAll();
	}

	public List<User> getUserByProfession(String profession) {
		return repository.findByProfession(profession);
	}

	public long getCounts(int age) {
		return repository.countByAge(age);
	}

	public List<User> deleteUser(String name) {
		return repository.deleteByName(name);
	}

	public List<User> findByMultiCondition(String profession, int age) {
		return repository.findByProfessionAndAge(profession, age);
	}

	public List<User> getUsersIgnoreCase(String profession) {
		return repository.findByProfessionIgnoreCase(profession);
	}

	// sort
	public List<User> getUserSort(String field) {
		return repository.findAll(new Sort(field));
	}

	// pagination
	public Page<User> getPaginatedUser() {
		return repository.findAll(new PageRequest(0, 3));
	}

	// custom Query
	public List<User> getUsersCustomQuery() {
		return repository.getUsersCustomQuery();
	}

}