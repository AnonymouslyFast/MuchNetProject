 package me.fast.lemonzero.minecraft.economy.Shop.Inventories;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Objects;
 import me.fast.lemonzero.minecraft.economy.EconomyManager;
 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import org.bukkit.Bukkit;
 import org.bukkit.Material;

 import org.bukkit.entity.Player;
 import org.bukkit.inventory.Inventory;

 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.inventory.meta.SkullMeta;

 import static me.fast.lemonzero.minecraft.economy.Shop.Functions.ItemPrices.getBuyPrice;
 import static me.fast.lemonzero.minecraft.economy.Shop.Functions.ItemPrices.getSellPrice;
 import static me.fast.lemonzero.minecraft.economy.Shop.Functions.itemFunc.item;


 public class BlocksShop
 {
   public static Inventory block;

   public static void blockShop(Player p) {
     block = Bukkit.createInventory(p, 45, ChatColor.cc("&e&lShop >> Blocks"));


     ItemStack fill = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
     ItemMeta fillmeta = fill.getItemMeta();
     Objects.requireNonNull(fillmeta).setDisplayName(" ");
     fill.setItemMeta(fillmeta);


     ItemStack head = new ItemStack(Material.PLAYER_HEAD);
     SkullMeta hm = (SkullMeta)head.getItemMeta();
     List<String> hl = new ArrayList<>();
     Objects.requireNonNull(hm).setOwningPlayer(p);
     hm.setDisplayName(ChatColor.cc("&a&lYou Balance:"));
     hl.add(ChatColor.cc("&2$&f" + EconomyManager.getBal(p)));
     hm.setLore(hl);
     head.setItemMeta(hm);


     ItemStack a = new ItemStack(Material.ARROW);
     ItemMeta am = a.getItemMeta();
     List<String> al = new ArrayList<>();
     al.add(ChatColor.cc("&3&lClick to go back to the main shop GUI"));
     Objects.requireNonNull(am).setLore(al);
     am.setDisplayName("&d&lBack");


     //Fifth Row
     block.setItem(37, fill);
     block.setItem(38, fill);
     block.setItem(39, fill);
     block.setItem(41, fill);
     block.setItem(42, fill);
     block.setItem(43, fill);
     block.setItem(44, fill);
     block.setItem(40, head);
     block.setItem(36, a);

     //First Row
       item(Material.GRASS_BLOCK, getBuyPrice(Material.GRASS_BLOCK), getSellPrice(Material.GRASS_BLOCK), 0, block);
       item(Material.DIRT, getBuyPrice(Material.DIRT), getSellPrice(Material.DIRT), 1, block);
       item(Material.STONE, getBuyPrice(Material.STONE), getSellPrice(Material.STONE), 2, block);
       item(Material.COBBLESTONE, getBuyPrice(Material.COBBLESTONE), getSellPrice(Material.COBBLESTONE), 3, block);








     p.openInventory(block);
   }
 }
