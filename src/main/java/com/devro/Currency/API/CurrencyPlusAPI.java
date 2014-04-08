package com.devro.Currency.API;

import com.devro.Currency.Currency;
import com.devro.Currency.Utils.User;
import com.devro.Currency.Utils.UserManager;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 11, 2013
 * Programmed for the Currency+ project.
 */
public class CurrencyPlusAPI {

    //**************************//

    private static Currency plugin;

    //**************************//

    public static int getMoney(Player player) {
      //Returns the amount of money a Player has.
      int money = UserManager.getUser(player).getBalance();
      return money;
    }

    //**************************//

    public static void setBalance(Player player, int amount) {
     //Used to set the amount of money a player has.
        UserManager.getUser(player).setBalance(amount);
    }

    //**************************//

    public static void addMoney(Player player, int amount) {
        //Used to add a specific amount of money to the currency the player already has.
        UserManager.getUser(player).giveBalance(amount);
    }

    //**************************//

    public static void takeMoney(Player player, int amount) {
        //Used to take a specific amount of money from the currency the player already has.
        UserManager.getUser(player).takeBalance(amount);
    }

    //**************************//

    public static boolean isInteger(String string) {
        //Checks if a String is an integer, used in several methods to prevent NumberFormatExceptions.
        try {
            Integer.parseInt(string);
            return true;
        }   catch (NumberFormatException nfe) {
            return false;
        }
    }

    //**************************//

    public static String getCurrencyName() {
        //Returns Currency Name, for example 'Dollars'
        return CurrencyPlusAPI.plugin.getConfig().getString("Currency-Name");
    }

    //**************************//

}
