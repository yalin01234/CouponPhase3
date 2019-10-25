package com.yalinarie.CouponPhase3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.yalinarie.CouponPhase3.Bean.Person;
import com.yalinarie.CouponPhase3.Dao.PersonDAO;

@SpringBootApplication
@EnableJpaRepositories
public class CouponPhase3Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(CouponPhase3Application.class, args);
		System.out.println("Go!");
		PersonDAO dao = ctx.getBean(PersonDAO.class);
		Person p = new Person("aaa", 10);
		Person p1 = new Person("bbb", 20);
		Person p2 = new Person("ccc", 30);
		Person p3 = new Person("ddd", 40);
		Person p4 = new Person("eee", 50);
		Person p5 = new Person("fff", 60);
		System.out.println("Go-Done!");

		// dao.addPerson(p);
		// dao.addPerson(p1);
		// dao.addPerson(p2);

		// dao.addPerson(p5);
		// dao.getAll();
		System.out.println(dao.getAll());
		System.out.println(dao.getPersonBetweanAges(30, 50));

		// PeopleRepository repo = ctx.getBean(PeopleRepository.class);
		//
		// People ppl1 = new People();
		// ppl1.getPersons().add(new Person("aaa", 10));
		// ppl1.getPersons().add(new Person("bbb", 20));
		// long id1 = repo.save(ppl1).getId();
		//
		// People ppl2 = new People();
		// ppl2.getPersons().add(new Person("ccc", 30));
		// ppl2.getPersons().add(new Person("ddd", 40));
		// ppl2.getPersons().add(new Person("eee", 50));
		// long id2 = repo.save(ppl2).getId();
		//
		// repo.getOne(id1).getPersons().stream().forEach(System.out::println);
		// System.out.println("____________");
		// repo.getOne(id2).getPersons().stream().forEach(System.out::println);

	}

}