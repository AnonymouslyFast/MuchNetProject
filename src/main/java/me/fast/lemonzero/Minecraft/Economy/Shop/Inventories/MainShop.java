 package me.fast.lemonzero.Minecraft.Economy.Shop.Inventories;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Objects;
 import me.fast.lemonzero.Minecraft.Economy.EconomyManager;
 import me.fast.lemonzero.Minecraft.Economy.Shop.ShopCommand;
 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
 import org.bukkit.Material;

 import org.bukkit.entity.Player;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.inventory.meta.SkullMeta;






 public class MainShop
 {
   public static void openShop(Player p) {
     ItemStack b = new ItemStack(Material.STONE);
     ItemMeta bm = b.getItemMeta();
     List<String> bl = new ArrayList<>();
     bl.add(ChatColor.cc("&7Click to open &lBlocks &7shop section"));
     bm.setLore(bl);
     Objects.requireNonNull(bm).setDisplayName("Blocks");
     b.setItemMeta(bm);
     ShopCommand.shop.setItem(10, b);


     ItemStack r = new ItemStack(Material.REDSTONE);
     ItemMeta rm = b.getItemMeta();
     List<String> rl = new ArrayList<>();
     rl.add(ChatColor.cc("&7Click to open &lRedstone &7shop section"));
     rm.setLore(rl);
     Objects.requireNonNull(rm).setDisplayName("Redstone");
     r.setItemMeta(rm);
     ShopCommand.shop.setItem(12, r);


     ItemStack o = new ItemStack(Material.DIAMOND);
     ItemMeta om = b.getItemMeta();
     List<String> ol = new ArrayList<>();
     ol.add(ChatColor.cc("&7Click to open &lOres &7shop section"));
     om.setLore(ol);
     Objects.requireNonNull(om).setDisplayName("Ores");
     o.setItemMeta(om);
     ShopCommand.shop.setItem(14, o);


     ItemStack m = new ItemStack(Material.NAME_TAG);
     ItemMeta mm = b.getItemMeta();
     List<String> ml = new ArrayList<>();
     ml.add(ChatColor.cc("&7Click to open &lMISC &7shop section"));
     mm.setLore(ml);
     Objects.requireNonNull(mm).setDisplayName("MISC");
     m.setItemMeta(mm);
     ShopCommand.shop.setItem(16, m);


     ItemStack md = new ItemStack(Material.ROTTEN_FLESH);
     ItemMeta mdm = b.getItemMeta();
     List<String> mdl = new ArrayList<>();
     mdl.add(ChatColor.cc("&7Click to open &lMob Drops &7shop section"));
     mm.setLore(mdl);
     Objects.requireNonNull(mdm).setDisplayName("Mob Drops");
     md.setItemMeta(mdm);
     ShopCommand.shop.setItem(19, md);


     ItemStack f = new ItemStack(Material.GOLDEN_HOE);
     ItemMeta fm = b.getItemMeta();
     List<String> fl = new ArrayList<>();
     fl.add(ChatColor.cc("&7Click to open &lFarming &7shop section"));
     fm.setLore(fl);
     Objects.requireNonNull(fm).setDisplayName("Farming");
     f.setItemMeta(fm);
     ShopCommand.shop.setItem(21, f);


     ItemStack fd = new ItemStack(Material.COOKED_BEEF);
     ItemMeta fdm = b.getItemMeta();
     List<String> fdl = new ArrayList<>();
     fdl.add(ChatColor.cc("&7Click to open &lFood &7shop section"));
     fdm.setLore(fdl);
     assert fdm != null;
     fdm.setDisplayName("Food");
     fd.setItemMeta(fdm);
     ShopCommand.shop.setItem(23, fd);


     ItemStack s = new ItemStack(Material.SPAWNER);
     ItemMeta sm = b.getItemMeta();
     List<String> sl = new ArrayList<>();
     sl.add(ChatColor.cc("&7Click to open &lSpawners &7shop section"));
     sm.setLore(sl);
     Objects.requireNonNull(sm).setDisplayName("Spawners");
     s.setItemMeta(sm);
     ShopCommand.shop.setItem(25, s);


     ItemStack head = new ItemStack(Material.PLAYER_HEAD);
     SkullMeta hm = (SkullMeta)head.getItemMeta();
     List<String> hl = new ArrayList<>();
     Objects.requireNonNull(hm).setOwningPlayer(p);
     hm.setDisplayName(ChatColor.cc("&a&lYou Balance:"));
     hl.add(ChatColor.cc("&2$&f" + EconomyManager.getBal(p)));
     hm.setLore(hl);
     head.setItemMeta(hm);
     ShopCommand.shop.setItem(31, head);

     ItemStack fill = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
     ItemMeta fillmeta = fill.getItemMeta();
     Objects.requireNonNull(fillmeta).setDisplayName(" ");
     fill.setItemMeta(fillmeta);


     ShopCommand.shop.setItem(0, fill);
     ShopCommand.shop.setItem(1, fill);
     ShopCommand.shop.setItem(2, fill);
     ShopCommand.shop.setItem(3, fill);
     ShopCommand.shop.setItem(4, fill);
     ShopCommand.shop.setItem(5, fill);
     ShopCommand.shop.setItem(6, fill);
     ShopCommand.shop.setItem(7, fill);
     ShopCommand.shop.setItem(8, fill);


     ShopCommand.shop.setItem(9, fill);
     ShopCommand.shop.setItem(11, fill);
     ShopCommand.shop.setItem(13, fill);
     ShopCommand.shop.setItem(15, fill);
     ShopCommand.shop.setItem(17, fill);


     ShopCommand.shop.setItem(18, fill);
     ShopCommand.shop.setItem(20, fill);
     ShopCommand.shop.setItem(22, fill);
     ShopCommand.shop.setItem(24, fill);
     ShopCommand.shop.setItem(26, fill);


     ShopCommand.shop.setItem(27, fill);
     ShopCommand.shop.setItem(28, fill);
     ShopCommand.shop.setItem(29, fill);
     ShopCommand.shop.setItem(30, fill);
     ShopCommand.shop.setItem(32, fill);
     ShopCommand.shop.setItem(33, fill);
     ShopCommand.shop.setItem(34, fill);
     ShopCommand.shop.setItem(35, fill);


     p.openInventory(ShopCommand.shop);
   }
 }


