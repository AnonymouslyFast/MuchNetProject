 package me.fast.lemonzero.minecraft.economy;

 import java.util.HashMap;
 import java.util.UUID;
 import org.bukkit.entity.Player;



 public class EconomyManager
 {
   public static final HashMap<UUID, Double> bal = new HashMap<>();

   public static Double getBal(Player p) {
     return bal.get(p.getUniqueId());
   }

   public static void setBal(Player p, Double amount) {
     bal.replace(p.getUniqueId(), getBal(p), amount);
   }

   public static Boolean hasAcc(Player p) {
     if (!bal.containsKey(p.getUniqueId())) return Boolean.valueOf(false);
     return Boolean.valueOf(true);
   }

   public static void addAcc(Player p, Double money) {
     bal.put(p.getUniqueId(), money);
   }
 }


