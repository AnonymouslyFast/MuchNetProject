 package me.fast.lemonzero.Minecraft.Listeners;

 import me.fast.lemonzero.Minecraft.Economy.EconomyManager;
 import me.fast.lemonzero.Minecraft.Economy.SLAPI;
 import me.fast.lemonzero.Minecraft.Moderation.CheckStuff.functions;
 import me.fast.lemonzero.Minecraft.Utitites.ChatColor;
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
     Player p = e.getPlayer();
     if (EconomyManager.hasAcc(p))
       return;  EconomyManager.addAcc(p, 250.0D);
     p.sendMessage(ChatColor.cc("&7&lSystem &8&l>> &fWelcome " + p.getName() + " to &e&lLemon&6&lZero&f! \n\n&6Welcome Rewards \n  &8- &a$&f250 \n  &8- &f100 &eLemons"));
     functions.addNewPlayerChecks(p);
   }

   @EventHandler
   public void onQuit(PlayerQuitEvent e) {
     Player p = e.getPlayer();
     SLAPI.savePlayerBal(p);
   }
 }


