package com.devro.currency.commands.core;

import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 28, 04, 2014
 * Programmed for the CommandManager project.
 */
public abstract interface BaseCommand {
    public abstract void execute(Player player, String[] args);

    public abstract Collection<String> aliases();

    public abstract String getRequiredPermission();

    public void setAliasUsed(String alias);
}
