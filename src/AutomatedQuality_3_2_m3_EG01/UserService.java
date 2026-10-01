package AutomatedQuality_3_2_m3_EG01;

public class UserService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void RegisterUser(String username, String password, String role) {
		// Username must not be null or only whitespace
		if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username may not be null or empty");
        }

		if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 chars long");
        }

        // Must contain a number
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least 1 number");
        }

        // Must contain a special character from !@#$%^&*
        if (!password.matches(".*[!@#$%^&*].*")) {
            throw new IllegalArgumentException("Password must contain a special character from !@#$%^&*");
        }

        // Valid roles
        if (role == null) {
            throw new IllegalArgumentException("Invalid role");
        }

        switch (role) {
            case "admin":
            case "manager":
            case "support":
            case "trainer":
                break;
            default:
                throw new IllegalArgumentException("Invalid role");
        }
	}

	public boolean LoginUser(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        return false;
    }

	public boolean HasAccess(String username, String requiredRole) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        return false;
    }

}
