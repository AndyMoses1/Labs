package code_review_testing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BrokenAuditApp {

    static  Path OUTPUT_FILE = Path.of("stage0_output.txt");
    static  String TEAM_NAME = "AuthTeam";
    String eventId = UUID.randomUUID()
        .toString()
        .substring(0, 8);

    private static final Set<String> KNOWN_USERS = Set.of(
            "user-100",
            "user-200",
            "user-300");


    record Attempt(String userId, boolean successful){}

    record AuditEvent(
            String eventId,
            Instant timestamp,
            String team,
            String userId,
            String result,
            boolean knownUser) {
    }

    static List<Attempt> getDefaultAttempts(){
        return List.of(
                new Attempt("user-100", true),
                new Attempt("user-200", false),
                new Attempt("user-100", false),
                new Attempt("user-999", true));
    }

    static AuditEvent createAuditEvent(Attempt attempt){
        String result = attempt.successful()
                ? "OK"
                : "NOT_OK";

        boolean knownUser = isKnownUser(attempt.userId());

        return new AuditEvent(
                UUID.randomUUID().toString().substring(0, 8),
                Instant.now(),
                TEAM_NAME,
                attempt.userId(),
                result,
                knownUser);
    }

    static boolean isKnownUser(String userId){
        return KNOWN_USERS.contains(userId);
    }

    static void writeAuditEvent(AuditEvent event) throws IOException{
        boolean needsHeader = !Files.exists(OUTPUT_FILE)
                || Files.size(OUTPUT_FILE) == 0;

        try (BufferedWriter writer = Files.newBufferedWriter(
                OUTPUT_FILE,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            if (needsHeader) {
                writer.write(
                        "event_id,timestamp,team,user_id,result,known_user");
                writer.newLine();
            }

            writer.write(formatAuditEvent(event));
            writer.newLine();
        }
    }

    static String formatAuditEvent(AuditEvent event){
        // return event.eventId()
        //         + "," + event.timestamp()
        //         + "," + event.team()
        //         + "," + event.userId()
        //         + "," + event.result()
        //         + "," + event.knownUser();
                //or
                return "id=" + event.eventId()
                    + " date=" + event.timestamp()
                    + " team=" + event.team()
                    + " user=" + event.userId()
                    + " result=" + event.result()
                    + " known=" + event.knownUser();
    }

    static void run() throws IOException {
        List<Attempt> attempts = getDefaultAttempts();
        for (Attempt attempt : attempts) {
            AuditEvent event = createAuditEvent(attempt);
            writeAuditEvent(event);
        }

    }
    public static void main(String[] args){

        try {
            run();
        } catch (IOException e) {
            System.err.println("Could not write audit log: " + e.getMessage());
            System.exit(1);
        }
    }
   
}