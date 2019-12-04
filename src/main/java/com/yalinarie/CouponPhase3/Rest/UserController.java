package com.yalinarie.CouponPhase3.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yalinarie.CouponPhase3.Bean.User;
import com.yalinarie.CouponPhase3.Service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService service;

	// http://localhost:9097/user/getUserByProfession/NodeJS

	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return service.getUsers();
	}

	// http://localhost:9097/user/getUserByProfession/Java
	// http://localhost:9097/user/getUserByProfession/NodeJS
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession) {
		return service.getUserByProfession(profession);
	}

	// http://localhost:9097/user/getUserCount/31
	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age) {
		long count = service.getCounts(age);
		return "total no of records : " + count;
	}

	// Postman -localhost:9097/user/delete/Moshe
	@DeleteMapping("/delete/{name}")
	public List<User> deleteUser(@PathVariable String name) {
		return service.deleteUser(name);
	}

	// http://localhost:9097/user/findMultiCondition/Java/31
	@GetMapping("/findMultiCondition/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession, @PathVariable int age) {
		return service.findByMultiCondition(profession, age);
	}

	// http://localhost:9097/user/getUsersIgnoreCase?profession=JAva
	@GetMapping("/getUsersIgnoreCase")
	public List<User> getUsersByprofession(@RequestParam("profession") String profession) {
		return service.getUsersIgnoreCase(profession);
	}

	// http://localhost:9097/user/getSort/age
	@GetMapping("/getSort/{field}")
	public List<User> getSortedUsers(@PathVariable String field) {
		return service.getUserSort(field);
	}

	// http://localhost:9097/user/getPaginatedData
	@GetMapping("/getPaginatedData")
	public Page<User> getPaginatedRecords() {
		return service.getPaginatedUser();
	}

	@GetMapping("/getRecordsByCustomQuery")
	public List<User> getUsersByCustomQuery() {
		return service.getUsersCustomQuery();
	}
}