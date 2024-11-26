/**
 * Represents a VW Arteon car, extends the VW class defines the properties and behaviors specific to
 * the VW Arteon.
 */
public class Arteon extends VW {

  /**
   * Constructor to initialize a VW Arteon with the given available fuel and chassis number. The
   * chassis number is prefixed with "VW".
   *
   * @param availableFuel the initial amount of fuel available in the car
   * @param chassisNumber the chassis number of the car
   */
  public Arteon(float availableFuel, String chassisNumber) {
    super("Diesel", 66, (short) 6, availableFuel, 17, 4.5, chassisNumber);
    this.chassisNumber = chassisPrefix + chassisNumber;
    setConsumptionPer100km();
  }

  /**
   * Sets the fuel consumption per 100 km based on the tire size. Different tire sizes result in
   * different consumption values.
   */
  private double setConsumptionPer100km() {
    switch (getTireSize()) {
      case 17:
        consumptionPer100km = 5.2;
        break;
      case 18:
        consumptionPer100km = 5.7;
        break;
      case 19:
        consumptionPer100km = 6;
        break;
      default:
        System.out.println(
            "Invalid tire size! The VW Arteon can have tire size between 17 and 19.");
    }
    return consumptionPer100km;
  }

  /** Starts the VW Arteon car and resets the current distance traveled. */
  @Override
  public void start() {
    System.out.println("The VW Arteon started.");
    currentDistanceTraveled = 0;
  }

  /** Stops the VW Arteon car, calculates the fuel consumption, and updates the available fuel. */
  @Override
  public void stop() {
    System.out.println("The VW Arteon stopped.");
    totalDistanceTraveled += currentDistanceTraveled;
    double consumedFuel = calculateFuelConsumption();
    System.out.println(
        "The VW Arteon has consumed "
            + consumedFuel
            + " liters of "
            + getFuelType()
            + " for "
            + totalDistanceTraveled
            + " km.");
    availableFuel -= consumedFuel;
  }

  /**
   * Shifts the gear of the VW Arteon car. If shifting up, fuel consumption is decreased by 10%, and
   * if shifting down, it's increased by 10%.
   *
   * @param inputGear the gear to shift to 1-6
   */
  @Override
  public void shiftGear(int inputGear) {
    if (inputGear < 1 || inputGear > 6) {
      System.out.println("Invalid gear!");
      return;
    }

    if (inputGear == getGear()) {
      System.out.println("Already in gear " + inputGear + "!");
      return;
    }

    if (inputGear > getGear()) {
      System.out.println("Shifting up from gear " + getGear() + " to " + inputGear);
      consumptionPer100km -= consumptionPer100km * 0.1;
    } else {
      System.out.println("Shifting down from gear " + getGear() + " to " + inputGear);
      consumptionPer100km += consumptionPer100km * 0.1;
    }
    setGear(inputGear);
  }

  /**
   * Drives the VW Arteon for a specified distance in kilometers.
   *
   * @param km the distance to drive in kilometers
   */
  @Override
  public void drive(double km) {
    System.out.println("The VW Arteon is driven " + km + " km.");
    currentDistanceTraveled += km;
  }
}
