package de.lukas.coreapi.vehiclesAPI;

import org.bukkit.entity.Player;

public class VehicleAPI {

    public static void registerVehicle(String vehicleid, Player target) {
        //** TODO Register the Vehicle in Database **//
    }

    public static void unregisterVehicle(String vehicleid, Player target) {
        //** TODO Unregister the Vehicle in Database **//
    }

    public static void setVehicleOwner(String vehicleid, Player target) {
        //** TODO Set the Owner of the Vehicle in Database **//
    }

    public static void sellVehicleToDealer(String vehicleid, Player target, int price) {
        //** TODO Remove the Vehicle from DB and Give the Player Money **//
    }

    public static void selVehicleToPlayer(String vehicleid, Player target, String target2, int price) {
        //** TODO Remove the Vehicle from Player 1 and give it to Player 2 then remove Money from Player 2 and give it Player 1 **//
    }

    public static void spawnVehicle(String vehicleid, Player target) {
        //** TODO Spawn the Vehicle at the Location of the Player **//
    }

    public static void despawnVehicle(String vehicleid, Player target) {
        //** TODO Despawn the Vehicle at the Location of the Player **//
    }
}
