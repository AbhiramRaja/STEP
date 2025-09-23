class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void turnOn() {
        System.out.println(deviceName + " is now ON");
    }

    public void turnOff() {
        System.out.println(deviceName + " is now OFF");
    }
}

class SmartLight extends SmartDevice {
    public SmartLight(String deviceName) {
        super(deviceName);
    }

    public void setBrightness(int level) {
        System.out.println(deviceName + " brightness set to " + level + "%");
    }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String deviceName) {
        super(deviceName);
    }

    public void setTemperature(int temp) {
        System.out.println(deviceName + " temperature set to " + temp + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice[] devices = {new SmartLight("Living Room Light"), new SmartThermostat("Nest Thermostat")};

        for (SmartDevice d : devices) {
            d.turnOn();
            if (d instanceof SmartLight) {
                ((SmartLight) d).setBrightness(80);
            } else if (d instanceof SmartThermostat) {
                ((SmartThermostat) d).setTemperature(24);
            }
            d.turnOff();
        }
    }
}
