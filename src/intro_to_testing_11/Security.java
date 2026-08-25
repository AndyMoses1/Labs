package intro_to_testing_11;

public class Security {

	public boolean login(String userId, String password) {

		String errorMessage;

		// userId must not be null or spaces. Must be 8 chars minimum.
		// password must be 8 chars minimum and contain a digit, an upper
		// case char and a lower case char

		if (userId == null || userId.trim().equals("")) {
			errorMessage = "UserID may not be null or empty";
			return false;
		} else if (!validateUserId(userId)) {
			errorMessage = "UserID must be min 8 chars long";
			return false;
		} else if (password == null || password.trim().equals("")) {
			errorMessage = "Password may not be null or empty";
			return false;
		} else if (!validatePassword(password)) {
			errorMessage = "Password must be min 8 chars long with an uppercase and a number";
			return false;
		} else {
			errorMessage = "";
			return true;
		}
	}
	
	private boolean validateUserId(String userID) {		
		if (userID.length() < 8) {
			return false;
		}
		
		return true;
	}

	private boolean validatePassword(String password) {

		boolean hasUpper = false, hasLower = false, hasDigit = false;

		if (password.length() < 8)
			return false;

		for (char c : password.toCharArray()) {

			if (Character.isUpperCase(c)) {
				hasUpper = true;
				// continue loop as no character can be both!
				continue;
			}
			if (Character.isLowerCase(c)) {
				hasLower = true;
				continue;
			}
			if (Character.isDigit(c)) {
				hasDigit = true;
			}
		}
		return hasUpper && hasLower && hasDigit;
	}

}
