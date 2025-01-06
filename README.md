# Smart Home System

## Introduction

This project is a simple Java-based simulation of a Smart Home System. It allows you to interact with various smart devices, including Lights, Thermostats, and Cameras, using an intuitive console-based interface. The project demonstrates key object-oriented programming concepts like inheritance, interfaces, and abstraction.

## Features

### Control Smart Devices
   - Turn devices ON/OFF.
   - Schedule devices to turn ON/OFF at specific times (for devices that support scheduling).

### Device Types
   - **Light**: Supports turning on/off and scheduling.
   - **Thermostat**: Supports turning on/off, setting a specific temperature, and displaying current settings.
   - **Camera**: Supports turning on/off and scheduling.

### Extensible Design
   - Uses interfaces (`Controllable`, `Programmable`) and abstract classes (`SmartDevice`) to enable easy extension for new device types.

## Code Structure

### Interfaces
- **`Controllable` Interface**: Defines methods to turn devices on and off.
- **`Programmable` Interface**: Defines methods for scheduling operations.

### Abstract Class
- **`SmartDevice` Abstract Class**: Serves as the base class for all smart devices, providing shared properties like device name, status, and energy consumption.

### Concrete Device Classes
- `Light`
- `Thermostat`
- `Camera`

### Main Class
- **`SmartHomeSystem`**: Handles user input and interaction with devices.

## How to Run

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/smart-home-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd smart-home-system
   ```

3. Compile the program:
   ```bash
   javac SmartHomeSystem.java
   ```

4. Run the program:
   ```bash
   java SmartHomeSystem
   ```

5. Follow the on-screen prompts to control devices.

## Example Usage

1. Choose a device to control (e.g., Light).
2. Display device details.
3. Perform actions like turning the device ON/OFF or scheduling it.
4. For the thermostat, set a new temperature if needed.

## Key Concepts Demonstrated

### Object-Oriented Programming
- Inheritance, abstraction, and polymorphism.

### Interfaces
- Providing common behavior for devices with different implementations.

### Encapsulation
- Secure and organized access to device properties.

### User Interaction
- Console-based inputs to simulate real-world device management.

## Future Enhancements

### Planned Features

- Add more device types like smart plugs and speakers.
- Implement persistent scheduling using file storage or a database.
- Integrate a graphical user interface (GUI) for enhanced usability.
- Extend energy consumption tracking for detailed analytics.

## Contribution

Feel free to fork this repository and submit pull requests with improvements or new features.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

