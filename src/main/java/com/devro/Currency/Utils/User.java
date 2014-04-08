package com.devro.Currency.Utils;

import com.devro.Currency.Currency;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 01, 2014
 * Programmed for the Currency+ project.
 */
public class User {
    private BasicDBObject representation = new BasicDBObject();
    private Player cachedPlayer;

    private String name;

    private int balance = 0;

    public User(final String playerName) {
        this.name = playerName;

        Currency.getInstance().getServer().getScheduler().scheduleAsyncDelayedTask(Currency.getInstance(), new Runnable() {

            public void run() {
                final DBObject object = DatabaseManager.getPlayers().findOne(new BasicDBObject("Name", playerName));

                Currency.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Currency.getInstance(), new Runnable() {

                    public void run() {
                        if (object instanceof BasicDBObject) {
                            load((BasicDBObject) object);
                        } else {
                            load(null);
                        }
                    }

                });
            }

        });
    }

    public void load(BasicDBObject object) {
        if (object == null) {
            representation = new BasicDBObject("Name", name);
            save();
            return;
        }

        representation = object;

        this.balance = object.containsField("Balance") ? object.getInt("Balance") : 0;
        cachePlayer();
    }

    public void save() {
        Currency.getInstance().getServer().getScheduler().scheduleAsyncDelayedTask(Currency.getInstance(), new Runnable() {

            public void run() {
                DatabaseManager.getPlayers().save(representation);
            }

        });
    }

    public String getName() {
        return (name);
    }

    public Player getPlayer() {
        return (cachedPlayer == null ? Currency.getInstance().getServer().getPlayerExact(getName()) : cachedPlayer);
    }

    public void cachePlayer() {
        cachedPlayer = Currency.getInstance().getServer().getPlayerExact(getName());
    }

    public void unCachePlayer() {
        cachedPlayer = null;
    }

    public int getBalance() {
        return this.balance;
    }

    public void giveBalance(int balanceGiven) {

        this.balance += balanceGiven;

        if (balanceGiven >= 1) {
            getPlayer().playSound(getPlayer().getLocation(), Sound.ORB_PICKUP, 1F, -1F);
        }

        representation.put("Balance", this.balance);
        save();
    }

    public void takeBalance(int balance) {
        this.balance -= balance;

        representation.put("Balance", this.balance);
        save();
    }

    public void setBalance(int balance) {
        this.balance = balance;

        representation.put("Balance", this.balance);
        save();
    }




}
