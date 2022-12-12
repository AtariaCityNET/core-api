package de.lukas.coreapi.vehiclesAPI;

public class VehicleAPI {

    public static void registerVehicle(String vehicleid, String uuid) {
        //** TODO Register the Vehicle in Database **//
    }

    public static void unregisterVehicle(String vehicleid, String uuid) {
        //** TODO Unregister the Vehicle in Database **//
    }

    public static void setVehicleOwner(String vehicleid, String uuid) {
        //** TODO Set the Owner of the Vehicle in Database **//
    }

    public static void sellVehicleToDealer(String vehicleid, String uuid, int price) {
        //** TODO Remove the Vehicle from DB and Give the Player Money **//
    }

    public static void selVehicleToPlayer(String vehicleid, String uuid, String uuid2, int price) {
        //** TODO Remove the Vehicle from Player 1 and give it to Player 2 then remove Money from Player 2 and give it Player 1 **//
    }

    public static void spawnVehicle(String vehicleid, String uuid) {
        //** TODO Spawn the Vehicle at the Location of the Player **//
    }

    public static void despawnVehicle(String vehicleid, String uuid) {
        //** TODO Despawn the Vehicle at the Location of the Player **//
    }
}
