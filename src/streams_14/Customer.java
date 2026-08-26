package streams_14;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

	// The JSON keys are PascalCase. @JsonProperty maps each one to a normally
	// named Java field, so the rest of the code reads like Java.
	@JsonProperty("CustomerID")
	private String customerId;

	@JsonProperty("CompanyName")
	private String companyName;

	@JsonProperty("ContactName")
	private String contactName;

	@JsonProperty("ContactTitle")
	private String contactTitle;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("City")
	private String city;

	@JsonProperty("Region")
	private String region;

	@JsonProperty("PostalCode")
	private String postalCode;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Phone")
	private String phone;

	@JsonProperty("Fax")
	private String fax;

	public String getCustomerId() {
		return customerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getFax() {
		return fax;
	}

	@Override
	public String toString() {
		return String.format("%-6s %-36s %-16s %s", customerId, companyName, city, country);
	}

}
