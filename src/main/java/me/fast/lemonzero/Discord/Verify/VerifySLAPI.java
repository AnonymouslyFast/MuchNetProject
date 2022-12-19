package me.fast.lemonzero.Discord.Verify;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import me.fast.lemonzero.LemonZero;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class VerifySLAPI {
  private static LemonZero plugin;
  
  public VerifySLAPI(LemonZero plugin) {
    VerifySLAPI.plugin = plugin;
  }
  
  public static void loadVerified() {
    if (plugin == null)
      System.out.println("Plugin is null"); 
    if (LemonZero.jda == null) {
      System.out.println("JDA is null");
    } else {
      File balanceFile = new File(plugin.getDataFolder(), "Verify.yml");
      if (balanceFile.exists()) {
        YamlConfiguration balanceconfig = YamlConfiguration.loadConfiguration(balanceFile);
        for (String s : balanceconfig.getKeys(false)) {
          UUID id = UUID.fromString(s);
          Player p = Bukkit.getPlayer(id);
          Member member = ((Guild)Objects.<Guild>requireNonNull(LemonZero.jda.getGuildById("984253047377121371"))).getMemberById(balanceconfig.getLong(s));
          MinecraftCommand.verifyedAsMember.put(((Guild)Objects.<Guild>requireNonNull(LemonZero.jda.getGuildById("984253047377121371"))).getMemberById(balanceconfig.getLong(s)), ((Player)Objects.<Player>requireNonNull(p)).getUniqueId());
          MinecraftCommand.verifyedAsUUID.put(p.getUniqueId(), ((Guild)Objects.<Guild>requireNonNull(LemonZero.jda.getGuildById("984253047377121371"))).getMemberById(balanceconfig.getLong(s)));
        } 
      } 
    } 
  }
  
  public static void savePlayerVerified(Player p) {
    if (plugin == null)
      return; 
    File balanceFile = new File(plugin.getDataFolder(), "Verify.yml");
    YamlConfiguration balanceconfig = YamlConfiguration.loadConfiguration(balanceFile);
    if (!balanceFile.exists())
      try {
        balanceFile.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }  
    Member member = MinecraftCommand.verifyedAsUUID.get(p.getUniqueId());
    Long id = Long.valueOf(member.getIdLong());
    balanceconfig.set(p.getUniqueId().toString(), id);
    try {
      balanceconfig.save(balanceFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } 
  }
}
