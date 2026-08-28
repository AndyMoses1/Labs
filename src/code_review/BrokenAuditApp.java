package code_review;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BrokenAuditApp {

	private static final String OUTPUT_FILE = "stage0_output.txt";
	private static final String TEAM_NAME = "AuthTeam";

	private static final String[] HEADERS = { "id", "timestamp", "user", "result", "known", "team_name" };

	// One login attempt. Nested because nothing outside this class needs it.
	// Package-private rather than private, so a test in this package can use it.
	record Attempt(String user, boolean success) {}

	public static void main(String[] args) throws IOException {
		Set<String> users = loadUsers();
		List<Attempt> attempts = loadAttempts();

		writeAuditLog(users, attempts);
	}

	private static Set<String> loadUsers() {
		// This method would get from a file / database; here they are just returned
		// Using a Set as this can do .contains - needed for checking with attempts
		return Set.of("user-100", "user-200", "user-300");
	}

	private static List<Attempt> loadAttempts() {
		// Would come from a file / database; hardcoded here.
		// A List, not a Set: order matters and user-100 appears twice.
		return List.of(
			new Attempt("user-100", true),
			new Attempt("user-200", false),
			new Attempt("user-100", false),
			new Attempt("user-999", true)
		);
	}

	// for loop in here as this owns the writer
	public static void writeAuditLog(Set<String> users, List<Attempt> attempts) throws IOException {

		// Checked BEFORE opening the writer. An empty file counts as needing a
		// header too, and notExists() must come first because size() throws on
		// a missing file.
		Path path = Path.of(OUTPUT_FILE);
		boolean needsHeader = Files.notExists(path) || Files.size(path) == 0;

		// try automatically closes the file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {

			if (needsHeader) {
				writer.write(String.join(",", HEADERS));
				writer.newLine();
			}

			for (Attempt attempt : attempts) {
				boolean known = users.contains(attempt.user());

				String line = formatLine(
						UUID.randomUUID().toString(),
						Instant.now().truncatedTo(ChronoUnit.SECONDS),
						attempt,
						known,
						TEAM_NAME
					);

				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
            System.err.println("Could not write audit log: " + e.getMessage());
            System.exit(1);
        }
	}

	// Column order must match HEADERS above. Should make it easier to test this
	private static String formatLine(String id, Instant timestamp, Attempt attempt, boolean known, String teamName) {
		return String.join(",",
				id,
				timestamp.toString(),
				attempt.user(),
				String.valueOf(known),
				teamName
		);
	}
}
