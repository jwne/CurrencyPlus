package com.devro.currency.commands.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 28, 04, 2014
 * Programmed for the CommandManager project.
 */
public abstract class SimpleCommand implements BaseCommand {
    private String requiredPermission;
    private List<String> aliases;
    protected String aliasUsed;

    public SimpleCommand(String requiredPermission, String... aliases) {
        this.requiredPermission = requiredPermission;
        this.aliases = Arrays.asList(aliases);
    }

    public Collection<String> aliases() {
        return this.aliases;
    }

    public void setAliasUsed(String alias) {
        this.aliasUsed = alias;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }
}
