package com.devro.Currency.Utils;

import com.devro.Currency.Currency;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 02, 11, 2013
 * Programmed for the Currency+ project.
 */
public class FileUtil {

    //**************************//

    private Currency plugin;

    public FileUtil(Currency currency) {
        this.plugin = currency;
    }

    //**************************//

    public void createFile(Player p) {
        System.out.println("Created file for " + p.getName());
        File pFileDir = new File(this.plugin.getDataFolder(), "Players");
        if (!pFileDir.exists()) {
            pFileDir.mkdir();
        }
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.getName().toLowerCase() + ".yml");
        if (!pFile.exists())
            try {
                pFile.createNewFile();
                FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
                pConfig.set("User", p.getName());
                pConfig.set("Money", Integer.valueOf(0));
                pConfig.save(pFile);
            }
            catch (Exception e) {
            }
    }

    //**************************//

    public String getPlayerName(String p) {
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.toLowerCase() + ".yml");
        FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
        String name = pConfig.getString("User");
        return name;
    }

    //**************************//

    public boolean fileExists(String p) {
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.toLowerCase() + ".yml");
        if (pFile.exists()) {
            return true;
        }
        return false;
    }

    //**************************//

    public Integer getMoney(String p) {
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.toLowerCase() + ".yml");
        FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
        int Money = pConfig.getInt("Money");
        return Integer.valueOf(Money);
    }

    //**************************//

    public void setMoney(String p, int newAmount) {
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.toLowerCase() + ".yml");
        FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
        pConfig.set("Money", Integer.valueOf(newAmount));
        try {
            pConfig.save(pFile);
        } catch (Exception e) {
        }
    }

    //**************************//

    public void addMoney(String p, int amountAdded) {
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.toLowerCase() + ".yml");
        FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
        pConfig.set("Money", Integer.valueOf(pConfig.getInt("Money") + amountAdded));
        try {
            pConfig.save(pFile);
        } catch (Exception e) {
        }
    }

    //**************************//

    public void takeMoney(String p, int amountTaken) {
        File pFile = new File(this.plugin.getDataFolder(), "Players/" + p.toLowerCase() + ".yml");
        FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
        int PointsCurrent = pConfig.getInt("Money");
        if (PointsCurrent - amountTaken >= 0) {
            int newAmount = PointsCurrent - amountTaken;
            pConfig.set("Money", Integer.valueOf(newAmount));
        }
        try {
            pConfig.save(pFile);
        } catch (Exception e) {
        }
    }

    //**************************//
}
