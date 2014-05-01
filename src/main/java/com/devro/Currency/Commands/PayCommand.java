package com.devro.currency.commands;

import com.devro.currency.api.CurrencyPlusAPI;
import com.devro.currency.Currency;
import com.devro.currency.commands.core.SimpleCommand;
import com.devro.currency.utils.MessageUtils;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class PayCommand extends SimpleCommand {

    public PayCommand() {
        super("currency.pay", new String[] {"pay"});
    }

    public void execute(Player player, String[] args) {
        if (args.length == 0 || args.length > 2) {
            help(player);
            return;
        }
        if (args.length == 2) {
            Player taken = Currency.getInstance().getServer().getPlayerExact(args[0]);
            if (!taken.getName().equals(player.getName())) {
                int moneyPaid= CurrencyPlusAPI.resolve(args[1]);
                if (moneyPaid != -1) {
                    CurrencyPlusAPI.addMoney(taken, moneyPaid);
                    CurrencyPlusAPI.takeMoney(player, moneyPaid);
                    MessageUtils.sendMessageFromModule(player, "Success", "You have sent " + moneyPaid + " " +  Currency.getInstance().getConfig().getString("Currency-Name") + " to " + taken.getName());
                } else {
                    MessageUtils.sendMessageFromModule(player, "Error",args[1] + " is not a valid Integer.");
                }
            } else {
                MessageUtils.sendMessageFromModule(player, "Error", "You can't send money to yourself.");
                return;
            }

            int moneyPaid = CurrencyPlusAPI.resolve(args[1]);

            if (moneyPaid != -1) {
                CurrencyPlusAPI.addMoney(taken, moneyPaid);
                CurrencyPlusAPI.takeMoney(player, moneyPaid);
                MessageUtils.sendMessageFromModule(player, "Success", "You have sent " + moneyPaid  + " " + Currency.getInstance().getConfig().getString("Currency-Name") + " to " + taken.getName());
            } else {
               MessageUtils.sendMessageFromModule(player, "Error",args[1] + " is not a valid Integer.");
            }
        }
    }

    private void help(Player player) {
        MessageUtils.sendMessageFromModule(player, "Error", "Usage: /pay <player> <amount>");
    }

}
