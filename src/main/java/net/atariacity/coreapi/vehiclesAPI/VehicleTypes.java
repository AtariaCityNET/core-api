package net.atariacity.coreapi.vehiclesAPI;

public enum VehicleTypes {

    /**
     *
     * ENUM`s für die Fahrzeugtypen
     * Aufbau:
     *
     *  VEHICLE = Obligatorischer Prefix
     *  JOB = NORMAL, FIRE, POLICE, etc.
     *  MARKE = Wenn eine Marke vorhanden ist, dann ist diese auch abgebildet
     *  NUMMER = Diese Nummer steht für ein bestimmtes Modell (Dokumentation im Discord)
     *  COLOR = Hier ist die Farbe des Fahrzeuges abgebildet
     *  TYPE = Hier ist eine Info zur Fahrzeugklasse (SUV, TRUCK, CAR, VAN)
     *
     * **/


    // Feuerwehr
    VEHICLE_FIRE_1_TRUCK,

    // Polizei
    VEHICLE_POLICE_MERCEDES_1_CAR,
    VEHICLE_POLICE_BMW_1_CAR,
    VEHICLE_POLICE_AUDI_1_CAR,

    // Normal
    VEHICLE_NORMAL_MERCEDES_1_WHITE_CAR,
    VEHICLE_NORMAL_MERCEDES_1_BLACK_CAR;

}
