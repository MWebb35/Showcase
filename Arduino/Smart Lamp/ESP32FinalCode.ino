//Include WiFi
#include <WiFi.h>
//#include <WiFiClient.h>
#include <WebServer.h>

#include <Wire.h>

#include "soc/soc.h"
#include "soc/rtc_cntl_reg.h"

#include "onOffButtons.h"

const char* ssid = "iPhone (80)";
const char* password = "MadisonsIphone80";

// Set web server port number to 80
WebServer server(80);

// Variable to store the HTTP request
String header;

bool isOn = 0;

void handleRoot(){
  if (server.hasArg("ON")){
    if(!isOn){
      isOn = !isOn;
      Wire.beginTransmission(4); // transmit to device #4
      Wire.write(1);              // sends one byte
      Wire.endTransmission();    // stop transmitting
    }
  } else if (server.hasArg("OFF")){
    if(isOn){
      isOn = !isOn;
      Wire.beginTransmission(4); // transmit to device #4
      Wire.write(0);              // sends one byte
      Wire.endTransmission();    // stop transmitting
    }
  }
  Serial.println("GET /");
  server.send(200, "text/html", htmlonOffButtons);
}

void setup() {
  WRITE_PERI_REG(RTC_CNTL_BROWN_OUT_REG, 0); //disable brownout detector
  Serial.begin(921600); 

  //Connect to WiFi
  WiFi.begin(ssid, password);
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print("\nConnecting...");
  }

  //Displays IP address for user to join on
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());

  Wire.begin(); // join i2c bus 

  server.on("/", handleRoot); //Page and function

  server.begin();
  Serial.println("HTTP server started");

}

void loop() {
  server.handleClient();
}
