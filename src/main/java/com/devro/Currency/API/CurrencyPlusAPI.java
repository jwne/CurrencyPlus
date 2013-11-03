package com.devro.Currency.API;

import com.devro.Currency.Currency;
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
      int money = CurrencyPlusAPI.plugin.fileUtil.getMoney(player.getName());
      return money;
    }

    //**************************//

    public static void setMoney(Player player, int amount) {
     CurrencyPlusAPI.plugin.fileUtil.setMoney(player.getName(), amount);
    }

    //**************************//

    public static void addMoney(Player player, int amount) {
        CurrencyPlusAPI.plugin.fileUtil.addMoney(player.getName(), amount);
    }

    //**************************//

    public static void takeMoney(Player player, int amount) {
        CurrencyPlusAPI.plugin.fileUtil.takeMoney(player.getName(), amount);
    }

    //**************************//

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }   catch (NumberFormatException nfe) {
            return false;
        }
    }

    //**************************//

}
