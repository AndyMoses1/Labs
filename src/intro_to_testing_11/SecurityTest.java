package intro_to_testing_11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class SecurityTest {

	private Security security;

	@BeforeEach
	void setUp() {
		security = new Security();
	}
	
	@AfterEach
	void tearDown() {
		security = null;
	}

	@Test
	public void test_login_empty_UserId() {
		String userId = "", password = "Freddy99";
		boolean actual = security.login(userId, password);
		boolean expected = false;
		assertEquals(expected, actual);
		// assertFalse(actual);   // can also use this assert
	}
	
	@Test
	public void test_login_whitespce_UserId() {
		assertFalse(security.login("        ", "Freddy99"));
	}

	@Test
	public void test_login_null_UserId() {
		//assertEquals(false, security.login(null, "Freddy99"));
		assertFalse(security.login(null, "Freddy99"));
	}
	
	@Test
	public void test_login_userId_too_short() {
		// Valid password, so the userId length is the only thing that can fail.
		assertEquals(false, security.login("and", "Freddy99"));
	}

	@Test
	public void test_login_userId_exactly_eight_chars() {
		// Boundary: 8 is the minimum, so this must be accepted.
		assertTrue(security.login("andrewmo", "Freddy99"));
	}

	@Test
	public void test_login_empty_password() {
		assertEquals(false, security.login("andrewmoses", ""));
	}
	
	@Test
	public void test_login_whitespce_password() {
		assertFalse(security.login("andrewmoses", "        "));
	}

	@Test
	public void test_login_password_too_short() {
		assertEquals(false, security.login("andrewmoses", "Fred9"));
	}

	@Test
	public void test_login_password_without_uppercase() {
		assertEquals(false, security.login("andrewmoses", "freddy99"));
	}
	
	@Test
	public void test_login_password_without_lowercase() {
		assertEquals(false, security.login("andrewmoses", "FREDDY99"));
	}

	@Test
	public void test_login_password_without_digit() {
		assertEquals(false, security.login("andrewmoses", "FreddyFred"));
	}
	
	@Test
	public void test_login_null_password() {
		//assertEquals(false, security.login(null, "Freddy99"));
		assertFalse(security.login("andrewmoses", null));
	}
	
	@Test
	public void test_login_7_chars_valid_password() {
		assertFalse(security.login("andrewmoses", "Fredd9a"));
	}
	
	@Test
	public void test_login_password_with_special_chars() {
		assertTrue(security.login("andrewmoses", "Freddy9!"));
	}

	@Test
	public void test_login_valid_credentials() {
		//assertEquals(true, security.login("andrewmoses", "Freddy99"));
		assertTrue(security.login("andrewmoses", "Freddy99"));
	}
}
