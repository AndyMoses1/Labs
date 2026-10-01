package AutomatedQuality_3_2_m3_EG01;

public interface UserServiceDatabase {
	User getUser(String username);
	
	public void addUser(String username, String password, String role);

	public boolean userExists(String username);
}
