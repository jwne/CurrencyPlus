package com.devro.Currency.Commands;

import com.devro.Currency.API.CurrencyPlusAPI;
import com.devro.Currency.Currency;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 11, 2013
 * Programmed for the Currency+ project.
 */
public class TakeCommand implements CommandExecutor {

    //**************************//

    private Currency plugin;

    public TakeCommand(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("take")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("currency.take")) {
                    if (args.length == 0 || args.length > 2) {
                        this.plugin.messageUtils.sendMessageFromModule(player, "Error" , "Not enough or too many arguments");
                    }

                    if (args.length == 2) {
                        if (!CurrencyPlusAPI.isInteger(args[1])) {
                            this.plugin.messageUtils.sendMessageFromModule(player, "Error", "Something went wrong, are you sure you are trying to send money and not a letter or trying to send money to yourself?");
                        }
                        String name = this.plugin.fileUtil.getPlayerName(args[0]);
                        if (name == player.getName()) {
                            this.plugin.messageUtils.sendMessageFromModule(player, "Error", "Trying to take money from yourself? Thats kind of odd");
                        }
                        int moneyTaken = Integer.parseInt(args[1]);
                        this.plugin.fileUtil.takeMoney(name, moneyTaken);
                        this.plugin.messageUtils.sendMessageFromModule(player, "Success", "Successfully taken " + moneyTaken +  " "+ this.plugin.getConfig().getString("Currency-Name") + " from " + name);
                    }
                }
                this.plugin.messageUtils.sendNoPermissionMessage(player);
            }
        }
        return true;
    }

    //**************************//

}
