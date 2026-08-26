/**
 * 
 */
/**
 * 
 */
module Labs {
	requires java.desktop;
	requires org.junit.jupiter.api;
	requires gson;
	// Gson 2.6.2's constructor builds type adapters for java.sql.Date,
	// Time and Timestamp, so java.sql has to be in the module graph.
	requires java.sql;

	// Gson builds Customer objects and sets their fields by reflection,
	// which the module system blocks unless the package is opened to it.
	opens reading_json_12_2 to gson;
}