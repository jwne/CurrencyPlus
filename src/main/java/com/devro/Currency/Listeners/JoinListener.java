package com.devro.currency.listeners;

import com.devro.currency.api.CurrencyPlusAPI;
import com.devro.currency.Currency;
import com.devro.currency.utils.MessageUtils;
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
            MessageUtils.sendMessageFromModule(player, "Currency+", "Your current budget is: " + currentMoney + " " + Currency.getInstance().getConfig().getString("Currency-Name"));
        }
    }

    //**************************//

}
