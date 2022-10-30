 package me.fast.lemonzero.Minecraft.Economy;

 import java.io.File;
 import java.io.IOException;
 import java.util.Objects;
 import java.util.UUID;
 import me.fast.lemonzero.LemonZero;
 import org.bukkit.Bukkit;
 import org.bukkit.configuration.file.YamlConfiguration;
 import org.bukkit.entity.Player;






 public class SLAPI
 {
   public static void loadBalances() {
     if (LemonZero.getPlugin() == null)
       return;  File balanceFile = new File(LemonZero.getPlugin().getDataFolder(), "balance.yml");
     if (balanceFile.exists()) {
       YamlConfiguration balanceconfig = YamlConfiguration.loadConfiguration(balanceFile);
       for (String s : balanceconfig.getKeys(false)) {
         UUID id = UUID.fromString(s);
         Double money = Double.valueOf(balanceconfig.getDouble(s));
         Player p = Bukkit.getPlayer(id);
         EconomyManager.addAcc(Objects.requireNonNull(p), money);
       }
     }
   }

   public static void saveBalances() {
     if (LemonZero.getPlugin() == null)
       return;  File balanceFile = new File(LemonZero.getPlugin().getDataFolder(), "balance.yml");

     if (!balanceFile.exists()) {
       try {
         balanceFile.createNewFile();
       } catch (IOException e) {
         throw new RuntimeException(e);
       }
     }
     YamlConfiguration balanceconfig = YamlConfiguration.loadConfiguration(balanceFile);
     for (UUID id : EconomyManager.bal.keySet()) {
       balanceconfig.set(id.toString(), EconomyManager.getBal(Objects.requireNonNull(Bukkit.getPlayer(id))));
     }

     try {
       balanceconfig.save(balanceFile);
     } catch (IOException e) {
       throw new RuntimeException(e);
     }
   }

   public static void savePlayerBal(Player p) {
     if (LemonZero.getPlugin() == null)
       return;  File balanceFile = new File(LemonZero.getPlugin().getDataFolder(), "balance.yml");
     YamlConfiguration balanceconfig = YamlConfiguration.loadConfiguration(balanceFile);

     if (!balanceFile.exists()) {
       try {
         balanceFile.createNewFile();
       } catch (IOException e) {
         throw new RuntimeException(e);
       }
     }

     balanceconfig.set(p.getUniqueId().toString(), EconomyManager.getBal(p));

     try {
       balanceconfig.save(balanceFile);
     } catch (IOException e) {
       throw new RuntimeException(e);
     }
   }
 }

