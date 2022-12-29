 package me.fast.lemonzero.minecraft.moderation.CheckStuff;

 import java.util.HashMap;
 import java.util.UUID;
 import org.bukkit.entity.Player;

 public class functions {

   public static HashMap<UUID, Integer> PlayerBans = new HashMap<>();
   public static HashMap<UUID, Integer> PlayerWarns = new HashMap<>();
   public static HashMap<UUID, Integer> PlayerMutes = new HashMap<>();

   public static Integer getPlayerBans(Player p) {
/* 18 */     return PlayerBans.get(p.getUniqueId());
/*    */   }

   public static Integer getPlayerWarns(Player p) {
/* 22 */     return PlayerWarns.get(p.getUniqueId());
/*    */   }

   public static Integer getPlayerMutes(Player p) {
/* 26 */     return PlayerMutes.get(p.getUniqueId());
/*    */   }

   public static void addPlayerBan(Player p, Integer amount) {
     PlayerBans.replace(p.getUniqueId(), getPlayerBans(p), Integer.valueOf(getPlayerBans(p).intValue() + amount.intValue()));
   }

   public static void addPlayerMute(Player p, Integer amount) {
     PlayerBans.replace(p.getUniqueId(), getPlayerMutes(p), Integer.valueOf(getPlayerMutes(p).intValue() + amount.intValue()));
   }

   public static void addPlayerWarns(Player p, Integer amount) {
     PlayerBans.replace(p.getUniqueId(), getPlayerWarns(p), Integer.valueOf(getPlayerWarns(p).intValue() + amount.intValue()));
   }

   public static void addNewPlayerChecks(Player p) {
     PlayerBans.put(p.getUniqueId(), Integer.valueOf(0));
     PlayerWarns.put(p.getUniqueId(), Integer.valueOf(0));
     PlayerMutes.put(p.getUniqueId(), Integer.valueOf(0));
   }
 }


