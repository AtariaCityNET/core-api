package net.atariacity.coreapi.vehiclesAPI;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class VehicleAPI {

    protected HashMap<Integer, UUID> vehicleList;

    public HashMap<Integer, UUID> getVehicleList() {
        return vehicleList;
    }

    public void registerVehicle(String vehicleid, Player target) {
        //** TODO Register the Vehicle in Database **//
    }

    public void unregisterVehicle(String vehicleid, Player target) {
        //** TODO Unregister the Vehicle in Database **//
    }
}
