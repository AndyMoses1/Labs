package AutomatedQuality_3_2_m3_EG01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepositoryStub implements UserServiceDatabase {
	// Simulates the rows returned from the database
	User[] users = {
			new User("andy1", "Password1!", "admin"),
			new User("manager1", "Password1#", "manager"),
			new User("support1", "Password1$", "support"),
	};

	// Index the users by username for quick lookup
	// (wrapped in a HashMap so addUser can add to it)
	Map<String, User> usersByUsername = new HashMap<>(Arrays.stream(users)
			.collect(Collectors.toMap(User::getUsername, user -> user)));

	@Override
	public User getUser(String username) {
		return usersByUsername.get(username);
	}

	@Override
	public void addUser(String username, String password, String role) {
		usersByUsername.put(username, new User(username, password, role));
	}

	@Override
	public boolean userExists(String username) {
		return usersByUsername.containsKey(username);
	}
}
