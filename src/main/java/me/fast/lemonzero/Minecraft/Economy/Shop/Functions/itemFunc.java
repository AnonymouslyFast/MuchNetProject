 package me.fast.lemonzero.Minecraft.Economy.Shop.Functions;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Objects;

 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.Material;
 import org.bukkit.inventory.Inventory;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;




 public class itemFunc
 {
   public static void item(Material item, Double buyPrice, Double sellPrice, Integer slot, Inventory inv) {
     ItemStack itemm = new ItemStack(item);
     ItemMeta meta = itemm.getItemMeta();
     List<String> itemlore = new ArrayList<>();
     itemlore.add(ChatColor.cc("&7Buy Price: &2$&f" + buyPrice));
     itemlore.add(ChatColor.cc("&7Sell Price: &2$&f" + sellPrice));
     itemlore.add(ChatColor.cc("\n&6Click to open"));
     Objects.requireNonNull(Objects.requireNonNull(meta).getLore()).addAll(itemlore);
     itemm.setItemMeta(meta);
     inv.setItem(slot, itemm);
   }
 }


