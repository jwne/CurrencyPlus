package com.devro.currency.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class MessageUtils {

    public static void sendMessageFromModule(Player player, String module, String message) {
        player.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + module + ": " + ChatColor.GRAY + message + ".");
    }

    public static void sendNoPermissionMessage(Player player) {
        sendMessageFromModule(player, "Error", "Not enough permissions to execute this command!");
    }

}
