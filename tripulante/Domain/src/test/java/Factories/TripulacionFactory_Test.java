package Factories;


import org.junit.Assert;
import org.junit.Test;

public class TripulacionFactory_Test {

	@Test
	public void constructor_accept() {
		Assert.assertNotNull(new TripulacionFactory());
	}

	@Test
	public void create_accept() {
		Assert.assertNotNull(new TripulacionFactory().Create("GRUPO-A"));
	}
}
