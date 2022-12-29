package me.fast.lemonzero;
import java.awt.Color;
import java.time.Instant;
import java.util.Objects;


import me.fast.lemonzero.listeners.discord.DiscordListeners;
import me.fast.lemonzero.listeners.minecraft.JoinListener;
import me.fast.lemonzero.utils.EventUtils;
import me.fast.lemonzero.utils.MessageUtils;
import me.fast.lemonzero.utils.commands.CommandUtils;
import me.fast.lemonzero.utils.data.DataManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class LemonZero extends JavaPlugin {

   public static JDA jda;
   public static TextChannel mcChat;
   public static TextChannel logChat;
   public static TextChannel staff;
   private static LemonZero plugin;
   public static boolean hasJDA;

   public void onEnable() {
       plugin = this;
       getConfig().options().copyDefaults();
       saveDefaultConfig();

       CommandUtils.registerCommands();

       String token = getConfig().getString("token");

       if (!token.equals("")) {
           try {
               jda = JDABuilder.createDefault(token)
                       .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                       .build()
                       .awaitReady();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }


           String mcchatid = getConfig().getString("minecraft-channel-id");
           mcChat = jda.getTextChannelById(Objects.requireNonNull(mcchatid));

           String logchatid = getConfig().getString("log-channel-id");
           logChat = jda.getTextChannelById(Objects.requireNonNull(logchatid));

           String staffID = getConfig().getString("StaffChat-Channel-id");
           staff = jda.getTextChannelById(Objects.requireNonNull(staffID));

           EventUtils.registerDiscordListeners();

           EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.GREEN).setDescription(":white_check_mark: **Server Started!**").setTimestamp(Instant.now());
           assert mcChat != null;
           mcChat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
       } else {
           hasJDA = false;
           MessageUtils.log("&eWarning: Bot Token is not set!");
       }
       EventUtils.registerMinecraftListeners();

       plugin = this;
   }








   public void onDisable() {
       DataManager.saveData();



    if (jda != null) {
        EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.RED).setDescription(":x: **Server Stoped!**").setTimestamp(Instant.now());
        assert mcChat != null;
        mcChat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();

        jda.shutdown();
    }
   }

   public static LemonZero getPlugin() {
    return plugin;
  }

 }


