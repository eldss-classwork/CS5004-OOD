package edu.neu.khoury.cs5004.problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CleaningServiceTest {

  private CleaningService service;

  @Before
  public void setUp() throws Exception {
    service = new CleaningService(
        "1-A",
        "123 4th",
        PropertySize.SMALL,
        true,
        3,
        0
    );
  }

  @Test
  public void calculatePrice() {
    assertEquals(72.0, service.calculatePrice(), 0.0);

    service = new CleaningService(
        "123ABC",
        "11th St.",
        PropertySize.MEDIUM,
        false,
        3,
        0
    );
    assertEquals(160.0, service.calculatePrice(), 0.0);

    service = new CleaningService(
        "123ABC",
        "11th St.",
        PropertySize.LARGE,
        false,
        3,
        0
    );
    assertEquals(320.0, service.calculatePrice(), 0.0);
  }

  @Test
  public void priceWithPets() {
    service = new CleaningService(
        "1-A",
        "123 4th",
        PropertySize.SMALL,
        false,
        3,
        1
    );
    assertEquals(84.0, service.calculatePrice(), 0.00001);

    service = new CleaningService(
        "1-A",
        "123 4th",
        PropertySize.MEDIUM,
        false,
        3,
        2
    );
    assertEquals(168.0, service.calculatePrice(), 0.0);

    service = new CleaningService(
        "1-A",
        "123 4th",
        PropertySize.LARGE,
        false,
        3,
        3
    );
    assertEquals(342.4, service.calculatePrice(), 0.000001);
  }

  @Test
  public void toString1() {
    String result =
        "CleaningService: invoice=1-A address='123 4th' size=Small monthly=true serviced=3 pets=0";
    assertEquals(result, service.toString());
  }
}