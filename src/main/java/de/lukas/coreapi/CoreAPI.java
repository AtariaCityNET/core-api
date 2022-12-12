package de.lukas.coreapi;

import de.lukas.coreapi.economyAPI.EconomyAPI;
import de.lukas.coreapi.utils.TextComponents;
import de.lukas.coreapi.utils.sql.SQLConfig;
import de.lukas.coreapi.utils.sql.SQLFunctions;
import de.lukas.coreapi.utils.sql.SQLHandler;
import org.bukkit.plugin.java.JavaPlugin;
public class CoreAPI extends JavaPlugin {

    private static CoreAPI instance;

    public static SQLFunctions getSQL;
    public static TextComponents getTextComponents;
    public static EconomyAPI getEconomyAPI;

    @Override
    public void onEnable() {
        instance = this;

        SQLConfig.getConfig();
        SQLHandler.connect(this);
        SQLHandler.createTables();
    }

    @Override
    public void onDisable() {
    }

    public static CoreAPI getInstance() {
        return instance;
    }

    private static void declareInstances() {
        getSQL = new SQLFunctions(SQLHandler.database);
        getTextComponents = new TextComponents();
        getEconomyAPI = new EconomyAPI();
    }

}
