package net.atariacity.coreapi.utils.sql;

import net.atariacity.coreapi.CoreAPI;
import net.atariacity.coreapi.utils.yamlManager.YamlManager;

public class SQLConfig {

    public static String host;
    public static String port;
    public static String database;
    public static String user;
    public static String password;

    public static YamlManager yaml = new YamlManager("sql.yml", CoreAPI.getInstance().getDataFolder());

    public static void getConfig() {
        if(yaml.getFileConfiguration().contains("host")
        && yaml.getFileConfiguration().contains("port")
        && yaml.getFileConfiguration().contains("database")
        && yaml.getFileConfiguration().contains("user")
        && yaml.getFileConfiguration().contains("password")) {
            loadConfig();
        } else {
            setDefaults();
            yaml.save();
        }
    }

    public static void setDefaults() {
        yaml.getFileConfiguration().set("host", "localhost");
        yaml.getFileConfiguration().set("port", 3306);
        yaml.getFileConfiguration().set("database", "database");
        yaml.getFileConfiguration().set("user", "user");
        yaml.getFileConfiguration().set("password", "password");
    }

    public static void loadConfig() {
        host = yaml.getFileConfiguration().getString("host");
        port = String.valueOf(yaml.getFileConfiguration().getInt("port"));
        database = yaml.getFileConfiguration().getString("database");
        user = yaml.getFileConfiguration().getString("user");
        password = yaml.getFileConfiguration().getString("password");
    }

    public static String getHost() {
        return host;
    }

    public static String getPort() {
        return port;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
