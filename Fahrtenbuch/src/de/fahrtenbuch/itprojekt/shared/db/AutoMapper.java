package de.fahrtenbuch.itprojekt.shared.db;

public class AutoMapper {

	private static AutoMapper autoMapper = null;
	
	/**
	 * Protected constructor to prevent to generate a new object of FahrerMapper
	 * (hidden from all)
	 */
	protected AutoMapper() {
	}

	/**
	 * Static method to generate exact one object of FahrerMapper
	 * 
	 * @return The static instance of FahrerMapper
	 */
	public static AutoMapper autoMapper() {
		if (autoMapper == null) {
			autoMapper = new AutoMapper();
		}
		return autoMapper;
	}
	
	
	
	
}
