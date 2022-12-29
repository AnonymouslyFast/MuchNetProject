 package me.fast.lemonzero.minecraft.listeners;

 import me.fast.lemonzero.minecraft.economy.EconomyManager;
 import me.fast.lemonzero.minecraft.economy.SLAPI;
 import me.fast.lemonzero.minecraft.moderation.CheckStuff.functions;
 import me.fast.lemonzero.minecraft.utils.ChatColor;
 import me.fast.lemonzero.utils.BoardUtils;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerJoinEvent;
 import org.bukkit.event.player.PlayerQuitEvent;

 public class JoinListener
   implements Listener
 {
   @EventHandler
   public void onJoin(PlayerJoinEvent e) {
     Player player = e.getPlayer();
     if (EconomyManager.hasAcc(player))
       return;  EconomyManager.addAcc(player, 250.0D);
       player.sendMessage(ChatColor.cc("&7&lSystem &8&l>> &fWelcome " + player.getName() + " to &e&lLemon&6&lZero&f! \n\n&6Welcome Rewards \n  &8- &a$&f250 \n  &8- &f100 &eLemons"));
     functions.addNewPlayerChecks(player);
     BoardUtils.createSidebar(player);
     BoardUtils.setSidebarTitle(player, "&aThis can be whatever");
     BoardUtils.setSidebarLine(player, "&bThis can be whatever as well", 1);
   }

   @EventHandler
   public void onQuit(PlayerQuitEvent e) {
     Player player = e.getPlayer();
     SLAPI.savePlayerBal(player);
     BoardUtils.deleteSidebar(player);
   }
 }


