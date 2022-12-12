package net.atariacity.coreapi.vehiclesAPI;

import net.atariacity.coreapi.CoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class VehicleObject {

    public VehicleObject(Integer id) {
        if(CoreAPI.getVehicleAPI.getVehicleList().containsKey(id)) {
            Entity entity = Bukkit.getEntity(CoreAPI.getVehicleAPI.getVehicleList().get(id));
        } else {

        }
    }

    public void setOwner(Player target) {

    }

    public void setType(VehicleTypes vehicleTypes) {

    }

}
