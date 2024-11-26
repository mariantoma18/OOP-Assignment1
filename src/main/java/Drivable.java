/** Interface defining basic behaviors for drivable vehicles. */
public interface Drivable {

  /** Starts the vehicle. */
  void start();

  /** Stops the vehicle. */
  void stop();

  /**
   * Drives the vehicle for a specified distance in kilometers.
   * @param km the distance to drive in kilometers
   */
  void drive(double km);
}
