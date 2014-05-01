package com.devro.currency.utils;

import com.devro.currency.Currency;
import com.devro.currency.events.UserUnloadEvent;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 01, 2014
 * Programmed for the Currency+ project.
 */
public class UserManager {

    //*************************//

    private static UserManager instance;

    private HashMap<String, User> onlineUsers = new HashMap<String, User>();

    //*************************//

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }

        return (instance);
    }

    //*************************//

    public User getUser(Player player) {
        return (onlineUsers.containsKey(player.getName()) ? onlineUsers.get(player.getName()) : registerUser(player.getName(), new User(player.getName())));
    }

    public User getUserString(String player) {
        return (onlineUsers.get(player));
    }

    public void removeUser(Player player) {
        User user = onlineUsers.get(player.getName());

        Currency.getInstance().getServer().getPluginManager().callEvent(new UserUnloadEvent(user));

        onlineUsers.remove(player.getName());
    }

    public User registerUser(String player, User user) {
        onlineUsers.put(player, user);
        return (user);
    }

    public Collection<User> getUsers() {
        return (onlineUsers.values());
    }

    //*************************//

}
