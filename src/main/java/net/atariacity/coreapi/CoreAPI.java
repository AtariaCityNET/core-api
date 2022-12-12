package net.atariacity.coreapi;

import net.atariacity.coreapi.economyAPI.EconomyAPI;
import net.atariacity.coreapi.messageAPI.MessageAPI;
import net.atariacity.coreapi.utils.TextComponents;
import net.atariacity.coreapi.utils.sql.SQLConfig;
import net.atariacity.coreapi.utils.sql.SQLFunctions;
import net.atariacity.coreapi.utils.sql.SQLHandler;
import org.bukkit.plugin.java.JavaPlugin;
public class CoreAPI extends JavaPlugin {

    private static CoreAPI instance;

    public static SQLFunctions getSQL;
    public static TextComponents getTextComponents;
    public static EconomyAPI getEconomyAPI;
    public static MessageAPI getMessageAPI;

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
        getMessageAPI = new MessageAPI();
    }

}
