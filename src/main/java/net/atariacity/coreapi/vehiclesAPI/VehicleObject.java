package net.atariacity.coreapi.vehiclesAPI;

import net.atariacity.coreapi.CoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class VehicleObject {

    protected Entity entity;

    public VehicleObject(Integer id, Location loc) {
        if(CoreAPI.getVehicleAPI.getVehicleList().containsKey(id)) {
            if(Bukkit.getEntity(CoreAPI.getVehicleAPI.getVehicleList().get(id)) != null) {
                entity = Bukkit.getEntity(CoreAPI.getVehicleAPI.getVehicleList().get(id));
            } else {
                entity = loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            }
        } else {
            entity = loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        }
    }

    public void setOwner(Player target) {

    }

    public void setType(VehicleTypes vehicleType) {

    }

}
