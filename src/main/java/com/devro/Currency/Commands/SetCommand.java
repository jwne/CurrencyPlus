package com.devro.currency.commands;

import com.devro.currency.api.CurrencyPlusAPI;
import com.devro.currency.Currency;
import com.devro.currency.commands.core.SimpleCommand;
import com.devro.currency.utils.MessageUtils;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 11, 2013
 * Programmed for the Currency+ project.
 */
public class SetCommand extends SimpleCommand {

    //**************************//

    public SetCommand() {
        super("currency.set", new String[] {"set"});
    }

    //**************************//


    public void execute(Player player, String[] args) {
        if (args.length == 0 || args.length > 2) {
            help(player);
            return;
        }

        int amount = CurrencyPlusAPI.resolve(args[1]);

        if (args.length == 2) {
            if (amount != -1) {
                Player taken = Currency.getInstance().getServer().getPlayerExact(args[0]);
                CurrencyPlusAPI.setBalance(taken, amount);
                MessageUtils.sendMessageFromModule(player, "Success", "You have set the money of " + taken.getName() + " to " + amount);
            }
        }

        if (args.length == 2) {
            Player taken = Currency.getInstance().getServer().getPlayerExact(args[0]);
            int moneySet = Integer.parseInt(args[1]);
            CurrencyPlusAPI.setBalance(taken,moneySet);
        } else {
            MessageUtils.sendMessageFromModule(player, "Error", args[1] + " is not a valid integer.");
        }
    }

    private void help(Player player) {
        MessageUtils.sendMessageFromModule(player, "Error", "Usage: /set <player> <amount>");
    }

}
