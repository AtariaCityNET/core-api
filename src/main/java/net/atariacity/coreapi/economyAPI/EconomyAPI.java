package net.atariacity.coreapi.economyAPI;

import net.atariacity.coreapi.CoreAPI;
import net.atariacity.coreapi.utils.sql.Callback;
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

    public void setBargeld(Player target, double value, Callback callback) {
        if(CoreAPI.getSQL.tableExists("BARGELD")) {
            if(CoreAPI.getSQL.nullCheck("BARGELD")) {
                if(CoreAPI.getSQL.contentExists("BARGELD", "uuid", target.getUniqueId().toString())) {
                    CoreAPI.getSQL.sendSQL("UPDATE BARGELD SET value = '" + value + "' WHERE uuid = '" + target.getUniqueId().toString() + "';", callback);
                } else {
                    CoreAPI.getSQL.sendSQL("INSERT INTO BARGELD (uuid, value) VALUES ('" + target.getUniqueId().toString() + "', '" + value + "');", callback);
                }
            }
        }
    }

    public void addBargeld(Player target, double value, Callback callback) {
        setBargeld(target, getBargeld(target)+value, callback);
    }

    public void removeBargeld(Player target, double value, Callback callback) {
        setBargeld(target, getBargeld(target)-value, callback);
    }

    public void payBargeld(Player targetFrom, double value, Player targetTo, Callback callback) {
        setBargeld(targetFrom, getBargeld(targetFrom)-value, callback);
        setBargeld(targetTo, getBargeld(targetTo)+value, callback);
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
        final double[] d = {0};
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(hasBank(target)) {
                    d[0] = CoreAPI.getSQL.getDouble("BANK", "value", "uuid", target.getUniqueId().toString());
                } else {
                    createBank(target, new Callback() {
                        @Override
                        public void onSucces(Object done) {
                            d[0] = CoreAPI.getSQL.getDouble("BANK", "value", "uuid", target.getUniqueId().toString());
                        }
                    });
                }
            }
        }
        return d[0];
    }

    public String getKonto(Player target) {
        final String[] konto = {""};
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(hasBank(target)) {
                    konto[0] = CoreAPI.getSQL.getString("BANK", "konto", "uuid", target.getUniqueId().toString());
                } else {
                    createBank(target, new Callback() {
                        @Override
                        public void onSucces(Object done) {
                            konto[0] = CoreAPI.getSQL.getString("BANK", "konto", "uuid", target.getUniqueId().toString());
                        }
                    });
                }
            }
        }
        return konto[0];
    }

    public void createBank(Player target, Callback callback) {
        if(!hasBank(target)) {
            Integer number = (Integer) CoreAPI.getSQL.getHighest("BANK", "konto")+1;
            CoreAPI.getSQL.sendSQL("INSERT INTO BANK (konto, uuid, value) VALUES ('" + number + "', '" + target.getUniqueId().toString() + "', 0);", callback);
        }
    }

    public void setBank(Player target, double value, Callback callback) {
        if(CoreAPI.getSQL.tableExists("BANK")) {
            if(CoreAPI.getSQL.nullCheck("BANK")) {
                if(hasBank(target)) {
                    CoreAPI.getSQL.sendSQL("UPDATE BANK SET value = '" + value + " WHERE uuid = '" + target.getUniqueId().toString() + "';", callback);
                } else {
                    createBank(target, new Callback() {
                        @Override
                        public void onSucces(Object done) {
                            setBank(target, value, callback);
                        }
                    });
                }
            }
        }
    }

    public void payBank(Player targetFrom, double value, Player targetTo, Callback callback) {
        setBank(targetFrom, getBank(targetFrom)-value, callback);
        setBank(targetTo, getBank(targetTo)+value, callback);
    }

}
