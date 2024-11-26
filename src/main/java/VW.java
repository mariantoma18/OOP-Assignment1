/**
 * Abstract class representing a VW car, extends the Car class and defines common properties and
 * behaviors for all VW cars. Uses a new @param chassisPrefix to leave its mark on the
 * brand-specific chassis series.
 */
public abstract class VW extends Car {

  protected final String chassisPrefix = "VW";

  /**
   * Constructor to initialize a VW car. The chassis number is prefixed with "VW" when creating a
   * new instance.
   *
   * @param fuelType the type of fuel used by the car (PETROL, DIESEL)
   * @param fuelTankSize the size of the fuel tank
   * @param gears the number of gears available
   * @param availableFuel the initial amount of fuel available
   * @param tireSize the tire size of the car
   * @param consumptionPer100km the fuel consumption / 100 km
   * @param chassisNumber the chassis number of the car
   */
  public VW(
      String fuelType,
      int fuelTankSize,
      short gears,
      float availableFuel,
      int tireSize,
      double consumptionPer100km,
      String chassisNumber) {

    super(
        fuelType, fuelTankSize, gears, availableFuel, tireSize, consumptionPer100km, chassisNumber);
  }

  /** Starts the VW car and resets the current distance traveled. */
  @Override
  public void start() {
    System.out.println("The VW car stared.");
    currentDistanceTraveled = 0;
  }

  /** Stops the VW car and calculates the total distance traveled and fuel consumption. */
  @Override
  public void stop() {
    System.out.println("The VW car stopped.");
    totalDistanceTraveled += currentDistanceTraveled;
    System.out.println(
        "The VW car has consumed "
            + calculateFuelConsumption()
            + "l of "
            + getFuelType()
            + " for "
            + totalDistanceTraveled
            + " km.");
  }

  /**
   * Drives the VW car for a specified distance in kilometers.
   *
   * @param km the distance to drive in kilometers
   */
  @Override
  public void drive(double km) {
    System.out.println("The VW car is driven " + km + " km.");
    currentDistanceTraveled += km;
  }
}
