package AutomatedQuality_3_2_m3_EG01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class UserServiceTest {

    private UserService userService;

	@BeforeEach
    public void setUp() throws Exception  {
        userService = new UserService(new UserRepositoryStub());
    }

    @AfterEach
    public void tearDown() {
        userService = null;
    }

    @Test
    public void valid_user_is_successfully_registered() {
        assertDoesNotThrow(() -> userService.RegisterUser("andrew.moses", "Password1!", "admin"));
    }

    @Test
    public void registering_a_duplicate_username_throws_exception() {
    	userService.RegisterUser("andrew.moses", "Password1!", "admin");
    	
    	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> userService.RegisterUser("andrew.moses", "Password1!", "admin"));

            assertEquals("Username already exists", ex.getMessage());
    }

    @Test
    public void short_password_throws_exception() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> userService.RegisterUser("andrew.moses", "Passw", "admin"));

        assertEquals("Password must be at least 8 chars long", ex.getMessage());
    }
    
    @Test
    public void password_without_a_number_throws_exception() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> userService.RegisterUser("andrew.moses", "Password!", "admin"));

        assertEquals("Password must contain at least 1 number", ex.getMessage());
    }
    
    @Test
    public void password_without_a_special_character_throws_exception() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> userService.RegisterUser("andrew.moses", "Password1", "admin"));

        assertEquals("Password must contain a special character from !@#$%^&*", ex.getMessage());
    }
        
    @Test
    public void invalid_role_throws_exception() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> userService.RegisterUser("andrew.moses", "Password1!", "invalid"));

        assertEquals("Invalid role", ex.getMessage());
    }
    
    @Test
    public void login_succeeds_with_correct_credentials() {
        assertDoesNotThrow(() -> userService.LoginUser("andrew.moses", "Password1!"));
    }
    
    @Test
    public void null_or_empty_username_on_login_throws_exception() {
    	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> userService.LoginUser("", "Password1!"));

        assertEquals("Username cannot be null or empty", ex.getMessage());
    }
    
    @Test
    public void wrong_password_on_login_returns_false() {
    	userService.RegisterUser("andrew.moses", "Password1!", "admin");

        assertFalse(userService.LoginUser("andrew.moses", "wrong password"));
    }
    
    @Test
    public void null_or_empty_username_on_hasAccess_throws_exception() {
    	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> userService.HasAccess("", "admin"));

            assertEquals("Username cannot be null or empty", ex.getMessage());
    }
    
    //Tests without message check:
    /*
    @Test
    public void short_password_throws_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.RegisterUser("andrew.moses", "Passw", "admin");
        });
    }

    @Test
    public void password_without_a_number_throws_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.RegisterUser("andrew.moses", "Password!", "admin");
        });
    }

    @Test
    public void password_without_a_special_character_throws_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.RegisterUser("andrew.moses", "Password1", "admin");
        });
    }
    */
}
