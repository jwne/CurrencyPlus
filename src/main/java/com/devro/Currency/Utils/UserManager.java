package com.devro.Currency.Utils;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 01, 2014
 * Programmed for the Currency+ project.
 */
public class UserManager {

    private static HashMap<String, User> users = new HashMap<String, User>();


    public static void reset() {
        users.clear();
    }


    public static User getUser(Player player) {
        return (getUser(player.getName()));
    }

    public static User getUser(String player) {
        return (users.containsKey(player) ? users.get(player) : registerUser(player, new User(player)));
    }

    public static void removeUser(Player player) {
        removeUser(player.getName());
    }

    public static void removeUser(String name) {
        if (!users.containsKey(name)) {
            throw new IllegalArgumentException();
        }

        users.remove(name);
    }

    public static void removeUser(User user) {
        removeUser(user.getName());
    }

    private static User registerUser(String player, User user) {
        if (!user.getName().equals(player)) {
            throw new IllegalArgumentException();
        }

        users.put(player, user);
        return (user);
    }


}
