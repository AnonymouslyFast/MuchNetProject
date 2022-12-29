package me.fast.lemonzero.minecraft.economy.Shop.Functions;


import me.fast.lemonzero.LemonZero;
import org.bukkit.Material;



public class ItemPrices {

    private static final LemonZero plugin = LemonZero.getPlugin();

    public static Double getBuyPrice(Material item) {
       return plugin.getConfig().getDouble("Buy Price " + item);
    }

    public static Double getSellPrice(Material item) {
        return plugin.getConfig().getDouble("Sell Price " + item);
    }








}
