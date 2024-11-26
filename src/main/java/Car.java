/**
 * Abstract class representing a car, extends from the Vehicle class. This class defines common
 * properties and behaviors for all cars.
 */
public abstract class Car extends Vehicle {
  /*
  Immutable properties
   */
  private final String fuelType;
  private final int fuelTankSize;
  private final short gears;
  private int gear = 0;

  /*
  Configurable properties
   */
  protected float availableFuel;
  private int tireSize;
  protected double consumptionPer100km;

  /*
  Distance variables
   */
  protected int totalDistanceTraveled;
  protected int currentDistanceTraveled;

  /**
   * Constructor to initialize a car with the given properties.
   *
   * @param fuelType the type of fuel used by the car (PETROL, DIESEL)
   * @param fuelTankSize the size of the fuel tank
   * @param gears the number of gears of the car
   * @param availableFuel the initial amount of fuel available in the car
   * @param tireSize the tire size of the car
   * @param consumptionPer100km the fuel consumption / 100 km
   * @param chassisNumber the chassis number of the car
   */
  public Car(
      String fuelType,
      int fuelTankSize,
      short gears,
      float availableFuel,
      int tireSize,
      double consumptionPer100km,
      String chassisNumber) {

    super(chassisNumber);

    this.fuelType = fuelType;
    this.fuelTankSize = fuelTankSize;
    this.gears = gears;
    this.availableFuel = availableFuel;
    this.tireSize = tireSize;
    this.consumptionPer100km = consumptionPer100km;
  }

  /** Starts the car and resets the current distance traveled. */
  @Override
  public void start() {
    System.out.println("The car stared.");
    currentDistanceTraveled = 0;
  }

  /** Stops the car and calculates the total distance traveled and fuel consumption. */
  @Override
  public void stop() {
    System.out.println("The car stopped.");
    totalDistanceTraveled += currentDistanceTraveled;
    System.out.println(
        "The  has consumed "
            + calculateFuelConsumption()
            + "l of "
            + fuelType
            + " for "
            + totalDistanceTraveled
            + " km.");
  }

  /**
   * Drives the car for a specified distance in kilometers.
   *
   * @param km the distance in kilometers
   */
  @Override
  public void drive(double km) {
    System.out.println("The car is driven " + km + " km.");
    currentDistanceTraveled += km;
  }

  /**
   * Shifts the car's gear up or down based on the input. The fuel consumption per 100 km changes
   * when shifting gears.
   *
   * @param inputGear the gear to shift between 1 and 6.
   */
  public void shiftGear(int inputGear) {

    if (inputGear < 1 || inputGear > 6) {
      System.out.println("Invalid gear!");
      return;
    }

    if (inputGear == gear) {
      System.out.println("Already in gear " + inputGear + "!");
      return;
    }

    if (inputGear > gear) {
      System.out.println("Shifting up from gear " + gear + " to " + inputGear);
      consumptionPer100km -= consumptionPer100km * 0.1;
    } else {
      System.out.println("Shifting down from gear " + gear + " to " + inputGear);
      consumptionPer100km += consumptionPer100km * 0.1;
    }
    gear = inputGear;
  }

  /**
   * Calculates the total fuel consumption.
   *
   * @return the total fuel consumed in liters
   */
  public double calculateFuelConsumption() {
    return (currentDistanceTraveled * consumptionPer100km) / 100;
  }

  /**
   * Gets the available fuel in the car, rounded to two decimals.
   *
   * @return the available fuel
   */
  public float getAvailableFuel() {
    return ((float) Math.round(availableFuel * 100) / 100);
  }

  /**
   * Gets the average fuel consumption / 100 km, rounded to two decimals.
   *
   * @return the average fuel consumption
   */
  public double getAverageFuelConsumption() {
    double averageFuelConsumption = (calculateFuelConsumption() / currentDistanceTraveled * 100);
    return ((double) Math.round(averageFuelConsumption * 100) / 100);
  }

  /**
   * Gets the current gear of the car.
   *
   * @return the current gear
   */
  public int getGear() {
    return gear;
  }

  /**
   * Sets the current gear of the car.
   *
   * @param gear the new gear to set
   * @return the new gear
   */
  public int setGear(int gear) {
    return this.gear = gear;
  }

  /**
   * Gets the fuel type used by the car.
   *
   * @return the fuel type
   */
  public String getFuelType() {
    return fuelType;
  }

  /**
   * Gets the tire size of the car.
   *
   * @return the tire size
   */
  public int getTireSize() {
    return tireSize;
  }
}
