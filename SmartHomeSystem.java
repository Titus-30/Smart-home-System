import java.util.Scanner;

// Controllable Interface
interface Controllable {
    void turnOn();
    void turnOff();
}

// Programmable Interface for scheduling
interface Programmable {
    void scheduleTurnOn(String time);
    void scheduleTurnOff(String time);
}

// Abstract SmartDevice class
abstract class SmartDevice implements Controllable {
    private String deviceName;
    private boolean status; // true for ON, false for OFF
    private double energyConsumption; // in watts

    public SmartDevice(String deviceName, double energyConsumption) {
        this.deviceName = deviceName;
        this.energyConsumption = energyConsumption;
        this.status = false; // default is OFF
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getStatus() {
        return status;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    public abstract void displayDetails();
}

// Light class
class Light extends SmartDevice implements Programmable {
    public Light(String deviceName, double energyConsumption) {
        super(deviceName, energyConsumption);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getDeviceName() + " is turned ON.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getDeviceName() + " is turned OFF.");
    }

    @Override
    public void scheduleTurnOn(String time) {
        System.out.println(getDeviceName() + " is scheduled to turn ON at " + time + ".");
    }

    @Override
    public void scheduleTurnOff(String time) {
        System.out.println(getDeviceName() + " is scheduled to turn OFF at " + time + ".");
    }

    @Override
    public void displayDetails() {
        System.out.println("Light - Name: " + getDeviceName() + ", Energy Consumption: " + getEnergyConsumption() + "W");
    }
}

// Thermostat class
class Thermostat extends SmartDevice {
    private double temperature;

    public Thermostat(String deviceName, double energyConsumption, double initialTemperature) {
        super(deviceName, energyConsumption);
        this.temperature = initialTemperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println(getDeviceName() + " temperature set to " + temperature + "°C.");
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getDeviceName() + " is turned ON.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getDeviceName() + " is turned OFF.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Thermostat - Name: " + getDeviceName() + ", Energy Consumption: " + getEnergyConsumption()
                + "W, Current Temperature: " + getTemperature() + "°C");
    }
}

// Camera class
class Camera extends SmartDevice implements Programmable {
    public Camera(String deviceName, double energyConsumption) {
        super(deviceName, energyConsumption);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getDeviceName() + " is turned ON.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getDeviceName() + " is turned OFF.");
    }

    @Override
    public void scheduleTurnOn(String time) {
        System.out.println(getDeviceName() + " is scheduled to turn ON at " + time + ".");
    }

    @Override
    public void scheduleTurnOff(String time) {
        System.out.println(getDeviceName() + " is scheduled to turn OFF at " + time + ".");
    }

    @Override
    public void displayDetails() {
        System.out.println("Camera - Name: " + getDeviceName() + ", Energy Consumption: " + getEnergyConsumption() + "W");
    }
}

// Main Class
public class SmartHomeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some smart devices
        Light light = new Light("Living Room Light", 10.5);
        Thermostat thermostat = new Thermostat("Home Thermostat", 15.0, 22.0);
        Camera camera = new Camera("Security Camera", 8.0);

        System.out.println("Smart Home System:");
        System.out.println("Choose a device to control: 1. Light  2. Thermostat  3. Camera");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        SmartDevice device = null;
        switch (choice) {
            case 1:
                device = light;
                break;
            case 2:
                device = thermostat;
                break;
            case 3:
                device = camera;
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(1);
        }

        // Display details of the selected device
        device.displayDetails();

        // Interact with the device
        System.out.println("1. Turn ON  2. Turn OFF  3. Schedule Turn ON  4. Schedule Turn OFF");
        int action = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (action == 1) {
            device.turnOn();
        } else if (action == 2) {
            device.turnOff();
        } else if (device instanceof Programmable) {
            System.out.print("Enter time (e.g., 10:00 AM): ");
            String time = scanner.nextLine();
            if (action == 3) {
                ((Programmable) device).scheduleTurnOn(time);
            } else if (action == 4) {
                ((Programmable) device).scheduleTurnOff(time);
            }
        } else {
            System.out.println("This device does not support scheduling.");
        }

        // Additional functionality for thermostat
        if (device instanceof Thermostat) {
            System.out.print("Set new temperature for the thermostat: ");
            double newTemp = scanner.nextDouble();
            ((Thermostat) device).setTemperature(newTemp);
        }

        scanner.close();
    }
}
