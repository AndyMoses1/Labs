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

	// Jackson. databind requires the other two transitively, but naming
	// all three is explicit and does not rely on that.
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.annotation;

	// Jackson sets fields reflectively, same as gson.
	opens streams_14 to com.fasterxml.jackson.databind;
}