/**
 * Abstract class representing a generic vehicle and implements the basic drivable behaviors defined
 * in the Drivable interface.
 */
public abstract class Vehicle implements Drivable {

  protected String chassisNumber;

  /**
   * Constructs a vehicle with the chassis number.
   *
   * @param chassisNumber the unique chassis number of the vehicle
   */
  public Vehicle(String chassisNumber) {
    this.chassisNumber = chassisNumber;
  }

  /** Starts the vehicle. */
  @Override
  public void start() {
    System.out.println("Vehicle stared.");
  }

  /** Stops the vehicle. */
  @Override
  public void stop() {
    System.out.println("Vehicle stopped.");
  }

  /**
   * Drives the vehicle for a specified distance in kilometers.
   *
   * @param km the distance to drive in kilometers
   */
  @Override
  public void drive(double km) {
    System.out.println("The vehicle is driven " + km + " km.");
  }
}
