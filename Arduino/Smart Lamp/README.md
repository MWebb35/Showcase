# Smart Lamp

A project made for a second-year physical computing class.

The intention behind this device was to make an accessible smart controller for people with mobility issues. This device could absolutely be used to give people with limited mobility more freedom within their homes, allowing them to turn on their non-smart from their phones. It acts as a smart device for anybody who would benefit from it, regardless of mobility, and can be easily modified to suit the needs of the user. For example, the non-smart device isn't limited to being a lamp and the dual-channel relay was built with the mindset that products can and will be changed out. This accessible product can be used in residential homes and within industry as a way to make workplaces more inclusive for all employees.

This project utilises an Arduino and ESP32 to control a custom circuit in order to make it into a smart device. The ESP32 hosts a web server that an external peripheral can connect to. On the webpage, the user has the option to press two buttons - "on" and "off". When a button is pressed, an integer signal (1 for on/0 for off) is sent to the Arduino via a level shifter which converts the signal from 3.3V to 5V. This is then interpreted by Arduino which writes HIGH or LOW to the digital pin (12) that the 5V dual channel relay is using. The relay then steps up the voltage to 230V and uses the signal to turn the lamp on or off. The relay acts as a switch for the lamp.
The circuit is powered by mains power and plugs into a standard wired plug socket. There is a 20 AMP double pole switch built into the circuit which allows for the lamp to still operate in the unlikely scenario that the Arduino, ESP32, or relay fails.

*2024*
