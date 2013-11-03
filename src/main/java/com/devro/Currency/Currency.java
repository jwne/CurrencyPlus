package com.devro.Currency;

import com.devro.Currency.Commands.Pay;
import com.devro.Currency.Commands.SetCommand;
import com.devro.Currency.Commands.TakeCommand;
import com.devro.Currency.Listeners.Join;
import com.devro.Currency.Utils.FileUtil;
import com.devro.Currency.Utils.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class Currency extends JavaPlugin {

    //**************************//

    public FileUtil fileUtil;
    public MessageUtils messageUtils;

    //**************************//

    public void onEnable() {
        this.fileUtil = new FileUtil(this);
        this.messageUtils = new MessageUtils(this);
        registerCommands();
        registerListeners();
        saveDefaultConfig();
    }

    //**************************//

    public void registerCommands() {
     getCommand("pay").setExecutor(new Pay(this));
     getCommand("set").setExecutor(new SetCommand(this));
     getCommand("take").setExecutor(new TakeCommand(this));
    }

    //**************************//

    public void registerListeners()  {
     getServer().getPluginManager().registerEvents(new Join(this), this);
    }

    //**************************//

}
