package net.atariacity.coreapi.utils.sql;

import org.bukkit.plugin.java.JavaPlugin;

public class SQLHandler {
    public static SQL database;

    public static void connect(JavaPlugin javaPlugin) {
        database = new SQL(SQLConfig.getHost(), SQLConfig.getPort(), SQLConfig.getDatabase(), SQLConfig.getUser(), SQLConfig.getPassword());
        javaPlugin.getLogger().severe(database.getHost() + ":" + database.getPort() + ":" + database.getDatabase() + ":" + database.getUser() + ":" + database.getPassword());
        database.connect();
    }

    public static void createTables() {
        database.createTable("BARGELD", "uuid VARCHAR(100), value DOUBLE, PRIMARY KEY (`uuid`)");
        database.createTable("BANK", "konto INTEGER, uuid VARCHAR(100), value DOUBLE, PRIMARY KEY (`konto`)");
        database.createTable("VEHICLES", "vehicleid INTEGER, owneruuid VARCHAR(100), type VARCHAR(100), PRIMARY KEY (`vehicleid`)");
    }

    public static void disconnect() {
        database.disconnect();
    }
}
