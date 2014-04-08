package com.devro.Currency.Listeners;

import com.devro.Currency.API.CurrencyPlusAPI;
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
public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        int currentMoney = CurrencyPlusAPI.getMoney(player);
        if (Currency.getInstance().getConfig().getBoolean("Display-Currency-On-Join")) {
            Currency.getInstance().messageUtils.sendMessageFromModule(player, "Currency+", "Your current budget is: " + currentMoney + " " + Currency.getInstance().getConfig().getString("Currency-Name"));
        }
    }

    //**************************//

}
