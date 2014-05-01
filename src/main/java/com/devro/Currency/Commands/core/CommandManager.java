package com.devro.currency.commands.core;

import com.devro.currency.Currency;
import com.devro.currency.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 28, 04, 2014
 * Programmed for the CommandManager project.
 */
public class CommandManager implements Listener {
    protected HashMap<String, BaseCommand> commands;
    private static CommandManager instance;

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public CommandManager() {
        Currency.getInstance().getServer().getPluginManager().registerEvents(this, Currency.getInstance());
        this.commands = new HashMap<String, BaseCommand>();
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String commandName = event.getMessage().substring(1);
        String[] args = new String[] {};

        if (commandName.contains(" ")) {
            commandName = commandName.split(" ")[0];
            args = event.getMessage().substring(event.getMessage().indexOf(' ') + 1).split(" ");
        }

        BaseCommand command = this.commands.get(commandName);
        if ((command != null) && event.getPlayer().hasPermission(command.getRequiredPermission())) {
            command.setAliasUsed(commandName);
            command.execute(event.getPlayer(), args);

            event.setCancelled(true);
        } else if (!event.getPlayer().hasPermission(command.getRequiredPermission())) {
            MessageUtils.sendNoPermissionMessage(event.getPlayer());
            event.setCancelled(true);
        }
    }

    public void addCommand(BaseCommand command) {
        for (String commandRoot : command.aliases()) {
            this.commands.put(commandRoot, command);
            System.out.println("Registered command " + command.getClass().getSimpleName() + " with aliases " + command.aliases() + " with required permission " + command.getRequiredPermission());
        }
    }

    public void removeCommand(BaseCommand command) {
        for (String commandRoot : command.aliases()) {
            this.commands.remove(commandRoot);
        }
    }

    public void addCommands(BaseCommand... commands) {
        for (BaseCommand command : commands) {
            addCommand(command);
        }
    }
}
