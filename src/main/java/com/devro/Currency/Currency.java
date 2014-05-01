package com.devro.currency;

import com.devro.currency.commands.PayCommand;
import com.devro.currency.commands.SetCommand;
import com.devro.currency.commands.TakeCommand;
import com.devro.currency.commands.core.CommandManager;
import com.devro.currency.listeners.JoinListener;
import com.devro.currency.utils.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class Currency extends JavaPlugin {

    //**************************//

    private static Currency instance;

    //**************************//

    public void onEnable() {
        setInstance(this);
        CommandManager.getInstance();
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
        CommandManager.getInstance().addCommands(
                new PayCommand(),
                new SetCommand(),
                new TakeCommand()
        );
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
