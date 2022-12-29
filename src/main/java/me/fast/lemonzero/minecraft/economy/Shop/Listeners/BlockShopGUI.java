 package me.fast.lemonzero.minecraft.economy.Shop.Listeners;

 import me.fast.lemonzero.minecraft.economy.Shop.Inventories.BlocksShop;
 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import org.bukkit.Material;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.inventory.InventoryClickEvent;



 public class BlockShopGUI
   implements Listener
 {
   @EventHandler
   public void onInventoryClick(InventoryClickEvent e) {
     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.cc("&e&lShop"))) {
       e.setCancelled(true);
       if (e.getCurrentItem().getType() == Material.STONE)
         BlocksShop.blockShop((Player)e.getWhoClicked());
     }
   }
 }


