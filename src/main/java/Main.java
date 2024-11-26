public class Main {

  public static void main(String[] args) {

    System.out.println("--- Volkswagen Eos ---");

    Car car1 = new Eos(27, "oiqe0934hkkadsn");

    car1.start();
    car1.shiftGear(1);
    car1.drive(0.01);
    car1.shiftGear(2);
    car1.drive(0.02);
    car1.shiftGear(3);
    car1.drive(0.5);
    car1.shiftGear(4);
    car1.drive(0.5);
    car1.shiftGear(4);
    car1.drive(0.5);
    car1.shiftGear(5);
    car1.drive(10);
    car1.shiftGear(4);
    car1.drive(0.5);
    car1.shiftGear(3);
    car1.drive(0.1);
    car1.stop();

    System.out.println(
        "The car has " + car1.getAvailableFuel() + "l of " + car1.getFuelType() + " left.");
    System.out.println("The average car consumption is: " + car1.getAverageFuelConsumption() + "%");

    System.out.println("-------------------------------------------");
    System.out.println("--- BMW M3 ---");

    Vehicle vehicle1 = new M3(30, "1987ddkshik289");

    vehicle1.start();
    vehicle1.drive(1);
    vehicle1.stop();

    Car car2 = (Car) vehicle1;

    System.out.println(
        "The car has " + car2.getAvailableFuel() + "l of " + car2.getFuelType() + " left.");

    System.out.println("The average car consumption is: " + car2.getAverageFuelConsumption() + "%");

    System.out.println("-------------------------------------------");
    System.out.println("--- Volkswagen Arteon ---");

    Car car3 = new Arteon(32, "sahte8743szdkkik");

    car3.start();
    car3.shiftGear(1);
    car3.drive(0.01);
    car3.shiftGear(2);
    car3.drive(0.02);
    car3.shiftGear(3);
    car3.drive(0.5);
    car3.shiftGear(4);
    car3.drive(0.5);
    car3.shiftGear(4);
    car3.drive(0.5);
    car3.shiftGear(5);
    car3.drive(10);
    car3.shiftGear(4);
    car3.drive(0.5);
    car3.shiftGear(3);
    car3.drive(0.1);
    car3.stop();

    System.out.println(
        "The car has " + car3.getAvailableFuel() + "l of " + car3.getFuelType() + " left.");
    System.out.println("The average car consumption is: " + car3.getAverageFuelConsumption() + "%");

    System.out.println("-------------------------------------------");
    System.out.println("--- BMW M4 ---");

    Vehicle vehicle2 = new M4(30, "98743tdhgfa731");

    vehicle2.start();
    vehicle2.drive(5);
    vehicle2.stop();

    Car car4 = (Car) vehicle2;

    System.out.println(
        "The car has " + car2.getAvailableFuel() + "l of " + car4.getFuelType() + " left.");

    System.out.println("The average car consumption is: " + car4.getAverageFuelConsumption() + "%");

    System.out.println("-------------------------------------------");
  }
}
