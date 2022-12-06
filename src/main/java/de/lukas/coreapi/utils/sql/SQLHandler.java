package de.lukas.coreapi.utils.sql;

import org.bukkit.plugin.java.JavaPlugin;

public class SQLHandler {
    public static SQL database;

    public static void connect(JavaPlugin javaPlugin) {
        database = new SQL(SQLConfig.getHost(), SQLConfig.getPort(), SQLConfig.getDatabase(), SQLConfig.getUser(), SQLConfig.getPassword());
        javaPlugin.getLogger().severe(database.getHost() + ":" + database.getPort() + ":" + database.getDatabase() + ":" + database.getUser() + ":" + database.getPassword());
        database.connect();
    }

    public static void createTables() {
        database.createTable("eco", "uuid VARCHAR(100), value DOUBLE, PRIMARY KEY (`uuid`)");
    }

    public static void disconnect() {
        database.disconnect();
    }
}
