/**
 * Represents a VW Eos car, extends the VW class and defines the properties and behaviors specific
 * to the VW Eos.
 */
public class Eos extends VW {

  /**
   * Constructor to initialize a VW Eos with the given available fuel and chassis number. The
   * chassis number is prefixed with "VW".
   *
   * @param availableFuel the initial amount of fuel available in the car
   * @param chassisNumber the chassis number of the car
   */
  public Eos(float availableFuel, String chassisNumber) {
    super("Petrol", 55, (short) 6, availableFuel, 15, 7, chassisNumber);
    this.chassisNumber = chassisPrefix + chassisNumber;
    setConsumptionPer100km();
  }

  /**
   * Sets the fuel consumption / 100 km based on the tire size. Different tire sizes result in
   * different consumption values.
   */
  private double setConsumptionPer100km() {
    switch (getTireSize()) {
      case 15:
        consumptionPer100km = 7;
        break;
      case 16:
        consumptionPer100km = 7.5;
        break;
      case 17:
        consumptionPer100km = 8;
        break;
      default:
        System.out.println("Invalid tire size! The VW Eos can have tire size between 15 and 17.");
    }
    return consumptionPer100km;
  }

  /** Starts the VW Eos car and resets the current distance traveled. */
  @Override
  public void start() {
    System.out.println("The VW Eos started.");
    currentDistanceTraveled = 0;
  }

  /** Stops the VW Eos car, calculates the fuel consumption, and updates the available fuel. */
  @Override
  public void stop() {
    System.out.println("The VW Eos stopped.");
    totalDistanceTraveled += currentDistanceTraveled;
    double consumedFuel = calculateFuelConsumption();
    System.out.println(
        "The VW Eos has consumed "
            + consumedFuel
            + " liters of "
            + getFuelType()
            + " for "
            + totalDistanceTraveled
            + " km.");
    availableFuel -= consumedFuel;
  }

  /**
   * Shifts the gear of the VW Eos car. If shifting up, fuel consumption is decreased by 11%, and if
   * shifting down, it's increased by 11%.
   *
   * @param inputGear the gear to shift 1-6
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
      consumptionPer100km -= consumptionPer100km * 0.11;
    } else {
      System.out.println("Shifting down from gear " + getGear() + " to " + inputGear);
      consumptionPer100km += consumptionPer100km * 0.11;
    }
    setGear(inputGear);
  }

  /**
   * Drives the VW Eos for a specified distance in kilometers.
   *
   * @param km the distance to drive in kilometers
   */
  @Override
  public void drive(double km) {
    System.out.println("The VW Eos is driven " + km + " km.");
    currentDistanceTraveled += km;
  }
}
