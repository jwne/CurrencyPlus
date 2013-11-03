package com.devro.Currency.Listeners;

import com.devro.Currency.Currency;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class Join implements Listener {

    //**************************//

    private Currency plugin;

    public Join(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        this.plugin.fileUtil.createFile(player);
        int currentMoney = this.plugin.fileUtil.getMoney(player.getName()).intValue();
        this.plugin.messageUtils .sendMessageFromModule(player, "Currency+", "Your current budget is: " + currentMoney + " " +this.plugin.getConfig().getString("Currency-Name"));
    }

    //**************************//

}
