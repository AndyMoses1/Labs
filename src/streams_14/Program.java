package streams_14;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) throws IOException {
		List<Country> countries = JSONReader.readCountries("src/countries.json");

		System.out.println("Countries read: " + countries.size());

		// 1. filter + sorted: Europe, biggest population first ----
		System.out.println("\n1. European countries by population:");
		countries.stream()
				.filter(country -> country.getRegion().equals("Europe"))
				.sorted(Comparator.comparingLong(Country::getPopulation).reversed())
				.forEach(country -> System.out.println("   " + country));

		// 2. mapToLong + sum: one number out of the whole list ----
		long totalPopulation = countries.stream()
				.mapToLong(Country::getPopulation)
				.sum();

		System.out.printf("%n2. Total population: %,d%n", totalPopulation);

		// 3. summaryStatistics: count, sum, min, max and mean in one pass ----
		LongSummaryStatistics stats = countries.stream()
				.mapToLong(Country::getPopulation)
				.summaryStatistics();

		System.out.printf("%n3. Population stats: min %,d | max %,d | mean %,.0f%n",
				stats.getMin(), stats.getMax(), stats.getAverage());

		// 4. max: largest by area. Optional, because the list could be empty ----
		countries.stream()
				.max(Comparator.comparingInt(Country::getArea))
				.ifPresent(country -> System.out.printf("%n4. Largest by area: %s (%,d km2)%n",
						country.getName(), country.getArea()));
		

		// 5. filter on a nested collection's size ----
		System.out.println("\n5. More than one official language:");
		countries.stream()
				.filter(country -> country.getLanguages().size() > 1)
				.forEach(country -> System.out.println("   " + country.getName()
						+ " " + country.getLanguages()));

		// 6. partitioningBy: always exactly two keys, true and false ----
		Map<Boolean, List<String>> bySize = countries.stream()
				.collect(Collectors.partitioningBy(country -> country.getPopulation() > 50_000_000,
						Collectors.mapping(Country::getName, Collectors.toList())));

		System.out.println("\n6. Over 50 million?  true=" + bySize.get(true)
				+ "  false=" + bySize.get(false));
	
	}

	// The (double) cast matters: population is long and area is int, so without
	// it Java does integer division and throws the fraction away.
	private static double density(Country country) {
		return (double) country.getPopulation() / country.getArea();
	}

}
