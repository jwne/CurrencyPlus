package com.devro.Currency.Utils;

import com.devro.Currency.Currency;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class MessageUtils {

    private Currency plugin;

    public MessageUtils(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    public void sendMessageFromModule(Player player, String module, String message) {
        player.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + module + ": " + ChatColor.GRAY + message + ".");
    }

    //**************************//

    public void sendNoPermissionMessage(Player player) {
        sendMessageFromModule(player, "Error", "Not enough permissions to execute this command");
    }

}
