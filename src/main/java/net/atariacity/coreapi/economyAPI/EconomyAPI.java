package net.atariacity.coreapi.economyAPI;

import net.atariacity.coreapi.CoreAPI;
import org.bukkit.entity.Player;

public class EconomyAPI {

    public double getBargeld(Player target) {
        if(CoreAPI.getSQL.tableExists("BARGELD")) {
            if(CoreAPI.getSQL.nullCheck("BARGELD")) {
                if(CoreAPI.getSQL.contentExists("BARGELD", "uuid", target.getUniqueId().toString())) {
                    return CoreAPI.getSQL.getDouble("BARGELD", "value", "uuid", target.getUniqueId().toString());
                }
            }
        }
        return 0;
    }

    public void setBargeld(Player target, double value) {
        if(CoreAPI.getSQL.tableExists("BARGELD")) {
            if(CoreAPI.getSQL.nullCheck("BARGELD")) {
                // MySQL Set Data
            }
        }
    }

    public void addBargeld(Player target, double value) {
        setBargeld(target, getBargeld(target)+value);
    }

    public void removeBargeld(Player target, double value) {
        setBargeld(target, getBargeld(target)-value);
    }

    public boolean hasBank(Player target) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(CoreAPI.getSQL.contentExists("BANK", "uuid", target.getUniqueId().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean kontoExists(Integer konto) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(CoreAPI.getSQL.contentExists("BANK", "konto", konto)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double getBank(Player target) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(CoreAPI.getSQL.contentExists("BANK", "uuid", target.getUniqueId().toString())) {
                    return CoreAPI.getSQL.getDouble("BANK", "value", "uuid", target.getUniqueId().toString());
                }
            }
        }
        return 0;
    }

    public double getBank(Integer konto) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(CoreAPI.getSQL.contentExists("BANK", "konto", konto)) {
                    return CoreAPI.getSQL.getDouble("BANK", "value", "konto", konto);
                }
            }
        }
        return 0;
    }

    public void setBank(Player target, double value) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(hasBank(target)) {
                    // MySQL Set Data
                }
            }
        }
    }

    public void setBank(Integer konto, double value) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(kontoExists(konto)) {
                    // MySQL Set Data
                }
            }
        }
    }

    public void createBank(Player target) {
        if(!hasBank(target)) {
            Integer number = (Integer) CoreAPI.getSQL.getHighest("BANK", "konto")+1;
            // MySQL Set Data
        }
    }

    public void payBargeld(Player targetFrom, double value, Player targetTo) {
        setBargeld(targetFrom, getBargeld(targetFrom)-value);
        setBargeld(targetTo, getBargeld(targetTo)+value);
    }

    public void payBank(Player targetFrom, double value, Player targetTo) {
        setBank(targetFrom, getBank(targetFrom)-value);
        setBank(targetTo, getBank(targetTo)+value);
    }

    public void payBank(Integer kontoFrom, double value, Integer kontoTo) {
        if (kontoExists(kontoFrom)) {
            if (kontoExists(kontoTo)) {
                setBank(kontoFrom, getBank(kontoFrom) - value);
                setBank(kontoTo, getBank(kontoTo) + value);
            }
        }
    }

}
