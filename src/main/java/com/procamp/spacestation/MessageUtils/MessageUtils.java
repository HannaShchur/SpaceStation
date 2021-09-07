package com.procamp.spacestation.MessageUtils;

public class MessageUtils {
    // Activation
    public static String ACTIVATION = "----- Sensor Action -----\n     Running sensors!";
    public static String LOADING_SUPPLY = "Loading %d units of %s in the supply hold.\n";
    public static String LOADING_FUEL = "Loading %d units of fuel in the tank.\n";
    // Action
    public static String SUPPLY_ACTION = "----- Supply Action -----";
    public static String FUEL_ACTION = "----- Fuel Action -----";
    public static String THRUSTERS_ACTION = "----- Thruster Action -----";
    // Report
    public static String SUPPLY_REPORT = "\n----- Supply Report -----";
    public static String FUEL_REPORT ="----- Fuel Report -----\n %d units of fuel available.";
    // Error
    public static String THRUSTERS_ERROR = "Thruster Error: Insufficient fuel available.";
    public static String SUPPLY_ERROR = "Supply Error: Insufficient %s in the supply hold.\n";
    // Messages
    public static String USE_SUPPLY = "Using %d of %s from the supply hold.\n";
    public static String NO_SUPPLY = "Supply hold is empty.";
    public static String AVAILABLE_SUPPLY = "%s avalilable: %d unit(s)\n";
}
