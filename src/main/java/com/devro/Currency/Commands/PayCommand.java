package com.devro.Currency.Commands;

import com.devro.Currency.API.CurrencyPlusAPI;
import com.devro.Currency.Currency;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.util.resources.CurrencyNames_el_CY;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class PayCommand implements CommandExecutor {

    //**************************//

     private Currency plugin;

    public PayCommand(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("pay")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("currency.pay")) {
                    if (args.length == 0 || args.length > 2) {
                        this.plugin.messageUtils.sendMessageFromModule(player, "Error", "Too many arguments");
                    }
                    if (args.length == 2) {
                        Player taken = Currency.getInstance().getServer().getPlayerExact(args[0]);
                        if (!taken.getName().equals(player.getName())) {
                            int moneyPaid= Integer.parseInt(args[1]);
                            CurrencyPlusAPI.addMoney(taken, moneyPaid);
                            CurrencyPlusAPI.takeMoney(player, moneyPaid);
                            this.plugin.messageUtils.sendMessageFromModule(player, "Success", "You have sent " + moneyPaid + " " +  this.plugin.getConfig().getString("Currency-Name") + " to " + taken.getName());
                        }

                        if (CurrencyPlusAPI.isInteger(args[1])) {
                            int moneyPaid= Integer.parseInt(args[1]);
                            CurrencyPlusAPI.addMoney(taken, moneyPaid);
                            CurrencyPlusAPI.takeMoney(player, moneyPaid);
                            this.plugin.messageUtils.sendMessageFromModule(player, "Success", "You have sent " + moneyPaid  + " " + this.plugin.getConfig().getString("Currency-Name") + " to " + taken.getName());
                        }
                        else {
                            this.plugin.messageUtils.sendMessageFromModule(player, "Error", "Something went wrong, are you sure you are trying to send money and not a letter or trying to send money to yourself?");
                        }

                    }
                }
                this.plugin.messageUtils.sendNoPermissionMessage(player);
            }
        }
        return true;
    }

    //**************************//

}
