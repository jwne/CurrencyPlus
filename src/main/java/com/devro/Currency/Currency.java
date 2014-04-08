package com.devro.Currency;

import com.devro.Currency.Commands.PayCommand;
import com.devro.Currency.Commands.SetCommand;
import com.devro.Currency.Commands.TakeCommand;
import com.devro.Currency.Listeners.JoinListener;
import com.devro.Currency.Utils.DatabaseManager;
import com.devro.Currency.Utils.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class Currency extends JavaPlugin {

    //**************************//

    public MessageUtils messageUtils;
    private static Currency instance;

    //**************************//

    public void onEnable() {
        setInstance(this);
        this.messageUtils = new MessageUtils(this);
        registerCommands();
        registerListeners();
        saveDefaultConfig();

        DatabaseManager.connect(getConfig().getString("DB.Host"), getConfig().getInt("DB.Port"));
    }

    public void onDisable() {
        setInstance(null);
    }

    //**************************//

    public void registerCommands() {
     getCommand("pay").setExecutor(new PayCommand(this));
     getCommand("set").setExecutor(new SetCommand(this));
     getCommand("take").setExecutor(new TakeCommand(this));
    }


    //**************************//

    public void registerListeners()  {
     getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    //**************************//

    public static void setInstance(Currency instance) {
        Currency.instance = instance;
    }

    //**************************//

    public static Currency getInstance() {
        return Currency.instance;
    }

    //**************************//


}
