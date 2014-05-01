package com.devro.currency.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 28, 04, 2014
 * Programmed for the Currency+ project.
 */
public class CurrencyLevelChangeEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private int oldAmount;
    private int newAmount;

    public CurrencyLevelChangeEvent(Player player, int oldAmount, int newAmount) {
        this.player = player;
        this.oldAmount = oldAmount;
        this.newAmount = newAmount;
    }

    public Player getPlayer() {
        return player;
    }

    public int getOldAmount() {
        return oldAmount;
    }

    public int getNewAmount() {
        return newAmount;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public HandlerList getHandlerList() {
        return handlers;
    }
}
