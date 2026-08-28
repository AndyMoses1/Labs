package code_review_testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.Instant;

public class BrokenAuditAppTest {

    // check the log line is exactly what we expect. 
    @Test
    public void formatAuditWorksCorrectly(){
        BrokenAuditApp.AuditEvent event =
        new BrokenAuditApp.AuditEvent(
            "abc12345",
            Instant.parse("2026-08-27T14:22:46.977271725Z"),
            "AuthTeam",
            "user-100",
            "OK",
            true
        );
        String result = BrokenAuditApp.formatAuditEvent(event);

        assertEquals("id=abc12345"
                + " date=2026-08-27T14:22:46.977271725Z"
                + " team=AuthTeam"
                + " user=user-100"
                + " result=OK"
                + " known=true", 
                result);
    }

    @Test
    public void timestampFormatTest(){

        BrokenAuditApp.Attempt attempt = new BrokenAuditApp.Attempt("user-100", true);

        Instant before = Instant.now();

        BrokenAuditApp.AuditEvent event = BrokenAuditApp.createAuditEvent(attempt);

        Instant after = Instant.now();

        assertFalse(event.timestamp().isBefore(before));
        assertFalse(event.timestamp().isAfter(after));

        assertTrue(event.timestamp().toString().endsWith("Z"));

    }


    // Is a known user
    @Test
    public void knownUserReturnsTrue(){
        assertTrue(BrokenAuditApp.isKnownUser("user-100"));
    }

    // Is not a known user
    @Test
    public void unknownUserReturnsFalse(){
        assertFalse(BrokenAuditApp.isKnownUser("user-999"));
    }

    // failed attempt = not_ok, 
    @Test
    public void failedAttemptGivesNotOk(){
        BrokenAuditApp.Attempt attempt = new BrokenAuditApp.Attempt("user-100", false);

        assertEquals("NOT_OK", BrokenAuditApp.createAuditEvent(attempt).result());
    }
    
    // passed attempt = OK. 
    @Test
    public void passedAttemptGivesOk(){
        BrokenAuditApp.Attempt attempt = new BrokenAuditApp.Attempt("user-100", true);

        assertEquals("OK", BrokenAuditApp.createAuditEvent(attempt).result());
    }
}
