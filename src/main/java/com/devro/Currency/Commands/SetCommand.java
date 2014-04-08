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
public class SetCommand implements CommandExecutor {

    //**************************//

    private Currency plugin;

    public SetCommand(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("set") && sender instanceof Player) {
            Player player = (Player) sender;

            if (!player.hasPermission("currency.set")) {
                this.plugin.messageUtils.sendNoPermissionMessage(player);
                return true;
            }

            if (args.length == 0 || args.length > 2) {
                this.plugin.messageUtils.sendMessageFromModule(player, "Error", "Not enough arguments or too many");
                return true;
            }

            if (args.length == 2) {
                if (!CurrencyPlusAPI.isInteger(args[1])) {
                    this.plugin.messageUtils.sendMessageFromModule(player, "Error", "Something went wrong, are you sure you are trying to send money and not a letter or trying to send money to yourself?");
                }
                Player taken = Currency.getInstance().getServer().getPlayerExact(args[0]);
                int moneySet = Integer.parseInt(args[1]);
                CurrencyPlusAPI.setBalance(taken,moneySet);
                this.plugin.messageUtils.sendMessageFromModule(player, "Success", "You have set the money of " + taken.getName() + " to " + moneySet + " " +  this.plugin.getConfig().getString("Currency-Name"));
                return false;
            }
        }
        return true;
    }

}
