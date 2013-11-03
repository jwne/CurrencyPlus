package com.devro.Currency.Commands;

import com.devro.Currency.Currency;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class Pay implements CommandExecutor {

    //**************************//

     private Currency plugin;

    public Pay(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("pay")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("currency.pay")) {
                    if (args.length == 0 || args.length > 2) {
                        this.plugin.messageUtils.sendMessageFromModule(player, "Error", "To many arguments");
                    }

                    String name = this.plugin.fileUtil.getPlayerName(args[0]);
                    int moneyPaid= Integer.parseInt(args[1]);
                    this.plugin.fileUtil.addMoney(name, moneyPaid);
                    this.plugin.fileUtil.takeMoney(player.getName(), moneyPaid);
                    this.plugin.messageUtils.sendMessageFromModule(player, "Success", "You have sent " + moneyPaid + this.plugin.getConfig().getString("Currency-Name") + " to " + name);
                }
            }
        }
        return true;
    }

    //**************************//

}
