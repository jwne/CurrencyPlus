package com.devro.currency.events;

import com.devro.currency.utils.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 28, 04, 2014
 * Programmed for the Currency+ project.
 */
public class UserUnloadEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private User user;

    public UserUnloadEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public HandlerList getHandlerList() {
        return handlers;
    }
}
