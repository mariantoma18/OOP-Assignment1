/**
 * Represents a BMW M3 car, extends the BMW class and defines the properties and behaviors specific
 * to the BMW M3.
 */
public class M3 extends BMW {

  /**
   * Constructor to initialize a BMW M3 with the given available fuel and chassis number. The
   * chassis number is prefixed with "BMW".
   *
   * @param availableFuel the initial amount of fuel available in the car
   * @param chassisNumber the chassis number of the car
   */
  public M3(float availableFuel, String chassisNumber) {

    super("Petrol", 63, (short) 6, availableFuel, 18, 8.5, chassisNumber);
    this.chassisNumber = chassisPrefix + chassisNumber;
    setConsumptionPer100km();
  }

  /**
   * Sets the fuel consumption / 100 km based on the tire size. Different tire sizes result in
   * different consumption values.
   */
  private double setConsumptionPer100km() {
    switch (getTireSize()) {
      case 18:
        consumptionPer100km = 8.5;
        break;
      case 19:
        consumptionPer100km = 9.5;
        break;
      case 20:
        consumptionPer100km = 10;
        break;
      default:
        System.out.println("Invalid tire size! The BMW M3 can have tire size between 18 and 20.");
    }
    return consumptionPer100km;
  }

  /** Starts the BMW M3 car and resets the current distance traveled. */
  @Override
  public void start() {
    System.out.println("The BMW M3 stared.");
    currentDistanceTraveled = 0;
  }

  /** Stops the BMW M3 car and calculates the total distance traveled and fuel consumption. */
  @Override
  public void stop() {
    System.out.println("The BMW M3 stopped.");
    totalDistanceTraveled += currentDistanceTraveled;
    double consumedFuel = calculateFuelConsumption();
    System.out.println(
        "The BMW M3 has consumed "
            + consumedFuel
            + "l of "
            + getFuelType()
            + " for "
            + totalDistanceTraveled
            + " km.");
    availableFuel -= consumedFuel;
  }

  /**
   * Shifts the gear of the BMW M3 car. If shifting up, fuel consumption is decreased by 13%, and if
   * shifting down, it's increased by 13%.
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
      consumptionPer100km -= consumptionPer100km * 0.13;
    } else {
      System.out.println("Shifting down from gear " + getGear() + " to " + inputGear);
      consumptionPer100km += consumptionPer100km * 0.13;
    }
    setGear(inputGear);
  }

  /**
   * Drives the BMW M3 for a specified distance in kilometers.
   *
   * @param km the distance to drive in kilometers
   */
  @Override
  public void drive(double km) {
    System.out.println("The BMW M3 is driven " + km + " km.");
    currentDistanceTraveled += km;
  }
}
