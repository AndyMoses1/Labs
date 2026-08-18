package oo3_static;

public class RegistrationPlateFactory {

	// static: the pool of plates belongs to the class, not to any instance.
	private static String[] registrationPlates = {
		"LA05 XYZ", // London 
		"NG58 JKL", // Nottingham 
		"MA13 HYP", // Manchester 
		"BX06 TUV", // Birmingham 
		"CF67 QRS", // Cardiff 
		"YS09 PQR", // Yorkshire 
		"WD21 NML", // Exeter area (Western region)
		"KR16 FGH", // Northampton
		"SJ04 UVW", // Glasgow 
		"LV22 ABC", // Liverpool
		"WX19 XYZ"  // Bristol 
	};

	private static int nextIndex = 0;

	public static RegistrationPlate getNextRegistrationPlate() {
		// No plates left in the pool.
		if (nextIndex >= registrationPlates.length) {
			return null;
		}

		RegistrationPlate plate = new RegistrationPlate(registrationPlates[nextIndex]);
		nextIndex++;

		return plate;
	}
}
