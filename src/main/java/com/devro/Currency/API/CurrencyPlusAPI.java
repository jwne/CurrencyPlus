package com.devro.currency.api;

import com.devro.currency.Currency;
import com.devro.currency.utils.UserManager;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 11, 2013
 * Programmed for the Currency+ project.
 */
public class CurrencyPlusAPI {

    //**************************//
    /**
    @return Will return the amount of money the Player has
     */
    public static int getMoney(Player player) {
      return UserManager.getInstance().getUser(player).getBalance();
    }

    //**************************//

    /**
     *
     * @param player player to set the balance of
     * @param amount to what amount the balance will be set
     */
    public static void setBalance(Player player, int amount) {
        UserManager.getInstance().getUser(player).setBalance(amount);
    }

    //**************************//

    /**
     *
     * @param player player whom to add the money.
     * @param amount how much money will be added to the players account.
     */
    public static void addMoney(Player player, int amount) {
        UserManager.getInstance().getUser(player).giveBalance(amount);
    }

    //**************************//

    /**
     *
     * @param player player whom to take the money from.
     * @param amount how much money will be taken from the players account.
     */
    public static void takeMoney(Player player, int amount) {
        UserManager.getInstance().getUser(player).takeBalance(amount);
    }

    //**************************//

    /**
     *
     * @param string String to check if it is an Integer.
     * @return will return rather an Integer or a -1 if not valid
     */
    public static int resolve(String string) {
            int i = -1;

            try {
                i = Integer.parseInt(string);
            } catch (NumberFormatException exception) {
                exception.printStackTrace();
            }

            if (i <= 0) {
                i = -1;
            }

            return (i);
    }

    //**************************//

    /**
     *
     * @return Currency name, Eg: Dollars
     */
    public static String getCurrencyName() {
        return Currency.getInstance().getConfig().getString("Currency-Name");
    }

    //**************************//

}
