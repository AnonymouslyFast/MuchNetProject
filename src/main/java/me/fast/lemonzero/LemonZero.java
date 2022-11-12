package me.fast.lemonzero;
import java.awt.Color;
import java.time.Instant;
import java.util.Objects;


import me.fast.lemonzero.Discord.discordListeners.discordListeners;
import me.fast.lemonzero.Minecraft.Economy.EconomyCommand;
import me.fast.lemonzero.Minecraft.Economy.SLAPI;
import me.fast.lemonzero.Minecraft.Economy.Shop.ShopCommand;
import me.fast.lemonzero.Minecraft.Economy.balCommand;
import me.fast.lemonzero.Minecraft.Economy.payCommand;
import me.fast.lemonzero.Minecraft.Moderation.ClearChatCmd;
import me.fast.lemonzero.Minecraft.Moderation.StaffChatCmd;
import me.fast.lemonzero.Minecraft.Moderation.checkCMD;
import me.fast.lemonzero.Minecraft.Moderation.kickCMD;
import me.fast.lemonzero.Minecraft.Utitites.LuckPerms;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;


public final class LemonZero extends JavaPlugin {

  public static JDA jda;
   public static TextChannel mcchat;
   public static TextChannel logChan;
   public static TextChannel staff;
   private static LemonZero plugin;

   public void onEnable() {
     getConfig().options().copyDefaults();
     saveDefaultConfig();

     LuckPerms.possibleGroups.add(0, "Owner");
     LuckPerms.possibleGroups.add(1, "Co-Owner");
     LuckPerms.possibleGroups.add(2, "Admin");
     LuckPerms.possibleGroups.add(3, "Moderator");
     LuckPerms.possibleGroups.add(4, "Helper");
     LuckPerms.possibleGroups.add(5, "LemonGod");
     LuckPerms.possibleGroups.add(6, "LemonSlice");
     LuckPerms.possibleGroups.add(7, "Default");


    String Token = getConfig().getString("token");


     try {
       jda = JDABuilder.createDefault(Token).build().awaitReady();
     } catch (InterruptedException e) {
       throw new RuntimeException(e);
     }

     String mcchatid = getConfig().getString("minecraft-channel-id");
     mcchat = jda.getTextChannelById(Objects.requireNonNull(mcchatid));

     String logchatid = getConfig().getString("log-channel-id");
     logChan = jda.getTextChannelById(Objects.requireNonNull(logchatid));

     String staffID = getConfig().getString("StaffChat-Channel-id");
     staff = jda.getTextChannelById(Objects.requireNonNull(staffID));

    jda.addEventListener(new discordListeners());






    EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.GREEN).setDescription(":white_check_mark: **Server Started!**").setTimestamp(Instant.now());
     assert mcchat != null;
     mcchat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();




     SLAPI.loadBalances();


         String packname = getClass().getPackage().getName();
     for (Class<?> clazz : (new Reflections(packname + ".Minecraft.Listeners")).getSubTypesOf(Listener.class)) {
       try {
         Listener listener = (Listener) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
         getServer().getPluginManager().registerEvents(listener, this);
       } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchMethodException e) {

         throw new RuntimeException(e);
       }
     }

   for (Class<?> clazz : (new Reflections(packname + ".Discord.Listeners")).getSubTypesOf(Listener.class)) {
       try {
         Listener listener = (Listener) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
         getServer().getPluginManager().registerEvents(listener, this);
       } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchMethodException e) {

         throw new RuntimeException(e);
      }
     }

     for (Class<?> clazz : (new Reflections(packname + ".Minecraft.Economy.Shop.Listeners")).getSubTypesOf(Listener.class)) {
       try {
        Listener listener = (Listener) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        getServer().getPluginManager().registerEvents(listener, this);
       } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchMethodException e) {

         throw new RuntimeException(e);
       }
}



     Objects.requireNonNull(getCommand("economy")).setExecutor(new EconomyCommand());
     Objects.requireNonNull(getCommand("bal")).setExecutor(new balCommand());
     Objects.requireNonNull(getCommand("pay")).setExecutor(new payCommand());
     Objects.requireNonNull(getCommand("clearchat")).setExecutor(new ClearChatCmd());
     Objects.requireNonNull(getCommand("staffchat")).setExecutor(new StaffChatCmd());
     Objects.requireNonNull(getCommand("kick")).setExecutor(new kickCMD());
     Objects.requireNonNull(getCommand("check")).setExecutor(new checkCMD());
     Objects.requireNonNull(getCommand("shop")).setExecutor(new ShopCommand());


    plugin = this;
   }







   public void onDisable() {
     SLAPI.saveBalances();




     EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.RED).setDescription(":x: **Server Stoped!**").setTimestamp(Instant.now());
     assert mcchat != null;
     mcchat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();

    jda.shutdown();
   }

   public static LemonZero getPlugin() {
    return plugin;
  }
 }


