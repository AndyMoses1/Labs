package streams_14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoviesStream {

	public static void main(String[] args) {
		List<Movie> movies = Arrays.asList(
			new Movie("Inception", "Sci-Fi", 8.8, 2010),
			new Movie("Interstellar", "Sci-Fi", 8.6, 2014),
			new Movie("The Dark Knight", "Action", 9.0, 2008),
			new Movie("Tenet", "Sci-Fi", 7.5, 2020),
			new Movie("The Prestige", "Drama", 8.5, 2006),
			new Movie("Memento", "Thriller", 8.4, 2000),
			new Movie("Dunkirk", "War", 7.9, 2017)
		);

		// Task 1: all Sci-Fi movies, highest rated first.
		// 1. Filter first
		// 2. sort using Comparator with Movie::getRating 
		// 3. foreach to use closure of println
		System.out.println("1. Sci-Fi movies sorted by rating:");
		movies.stream().filter(m -> m.getGenre().equalsIgnoreCase("Sci-Fi"))
			.sorted(Comparator.comparingDouble(Movie::getRating)
				.reversed()
			)
			.forEach(System.out::println);
		
		//Task 2 Average of all movies after 2010
		// 1. filter first above 2010
		// 2. collect to use averagingDouble on Movie::getRating
		// 3. output average.
		System.out.println();
		System.out.println("2. Average of all movies after 2010:");
		double averageRating = movies.stream()
				.filter(m -> m.getYear() > 2010)
				.collect(Collectors.averagingDouble(Movie::getRating));
		System.out.println(averageRating);
		
		//Task 3 Group movies by genre
		// 1. Need to re-arrange list, so use Map.
		// 2. Use Collectors to use groupingBy( 
		// Movie::getGenre == key  
		// 	Collectors.mapping(Movie::getTitle, Collectors.toList()) == what each group will become
		// )
		System.out.println();
		System.out.println("3. Grouped by Genre:");
		Map<String, List<String>> moviesByGenre = movies.stream().collect(
				Collectors.groupingBy(Movie::getGenre, Collectors.mapping(Movie::getTitle, Collectors.toList()))
		);
		
		moviesByGenre.forEach((genre, titles) -> System.out.println(genre + " -> " + titles));

		//Task 4 
		// Similar to 3. Use Map this time Optional<Movie>
		// Use Collectors to use groupingBy(
		// Then use internal Collectors in that to maxBy
		// Then use Comparator to compare the rating for each movie.
		System.out.println();
		System.out.println("\n4. Highest-rated movie per genre:");
		Map<String, Optional<Movie>> topMovieByGenre = movies.stream().collect(
			Collectors.groupingBy(Movie::getGenre, Collectors.maxBy(
					Comparator.comparingDouble(Movie::getRating)))
		);
	}

}
