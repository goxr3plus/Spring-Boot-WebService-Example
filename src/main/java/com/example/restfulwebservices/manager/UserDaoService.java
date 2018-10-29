package com.example.restfulwebservices.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.restfulwebservices.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private int usersCount = 3;

	static {

		users.add(new User(1, "Alex", new Date()));
		users.add(new User(2, "Angela", new Date()));
		users.add(new User(3, "OSHO", new Date()));

	}

	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	public User find(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		UserDaoService.users = users;
	}
}
