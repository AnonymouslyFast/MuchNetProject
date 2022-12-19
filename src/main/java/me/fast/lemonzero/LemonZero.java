package me.fast.lemonzero;
import java.awt.Color;
import java.time.Instant;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;


import me.fast.lemonzero.Discord.discordListeners.discordListeners;
import me.fast.lemonzero.FadeCore.BroadcastCommand;
import me.fast.lemonzero.FadeCore.Commands.Gamemode.CreativeCommand;
import me.fast.lemonzero.FadeCore.Commands.Gamemode.SpectatorCommand;
import me.fast.lemonzero.FadeCore.Commands.Gamemode.SurvivalCommand;
import me.fast.lemonzero.FadeCore.FlyCommand;
import me.fast.lemonzero.FadeCore.RulesCommand;
import me.fast.lemonzero.FadeCore.Teleport.TPHereCommand;
import me.fast.lemonzero.FadeCore.Teleport.TeleportCommand;
import me.fast.lemonzero.LemonExtras.AfkCommand;
import me.fast.lemonzero.LemonExtras.Homes.DelHomCommand;
import me.fast.lemonzero.LemonExtras.Homes.HomeCommand;
import me.fast.lemonzero.LemonExtras.Homes.HomeFiles;
import me.fast.lemonzero.LemonExtras.Homes.Se6HomeCommand;
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
import me.fast.lemonzero.SLAPI.Commands.SLAPICommand;
import me.fast.lemonzero.SLAPI.Commands.SetSpawnCommand;
import me.fast.lemonzero.SLAPI.Commands.SpawnCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;


public final class LemonZero extends JavaPlugin {

  public static JDA jda;
   public static TextChannel mcchat;
   public static TextChannel logChan;
   public static TextChannel staff;
   private static LemonZero plugin;

    private HashMap<UUID, Location> homes;
    private HomeFiles files;

   public void onEnable() {
    new VerifySLAPI(this);
       files.init();
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
       jda = JDABuilder.createDefault(Token)
               .enableIntents(GatewayIntent.MESSAGE_CONTENT)
               .build()
               .awaitReady();
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

       for (Class<?> clazz : (new Reflections(packname + ".FadeCore")).getSubTypesOf(Listener.class)) {
           try {
               Listener listener = (Listener) clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
               getServer().getPluginManager().registerEvents(listener, this);
           } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchMethodException e) {

               throw new RuntimeException(e);
           }
       }

       for (Class<?> clazz : (new Reflections(packname + ".SLAPI.Listeners")).getSubTypesOf(Listener.class)) {
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
     Objects.requireNonNull(getCommand("gmc")).setExecutor(new CreativeCommand());
     Objects.requireNonNull(getCommand("gms")).setExecutor(new SurvivalCommand());
     Objects.requireNonNull(getCommand("gmsp")).setExecutor(new SpectatorCommand());
     Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());
     Objects.requireNonNull(getCommand("tp")).setExecutor(new TeleportCommand());
     Objects.requireNonNull(getCommand("tphere")).setExecutor(new TPHereCommand());
     Objects.requireNonNull(getCommand("broadcast")).setExecutor(new BroadcastCommand());
     Objects.requireNonNull(getCommand("rules")).setExecutor(new RulesCommand());
     Objects.requireNonNull(getCommand("afk")).setExecutor(new AfkCommand());
     Objects.requireNonNull(getCommand("sethome")).setExecutor(new Se6HomeCommand());
     Objects.requireNonNull(getCommand("home")).setExecutor(new HomeCommand());
     Objects.requireNonNull(getCommand("delhome")).setExecutor(new DelHomCommand());
     Objects.requireNonNull(getCommand("setspawn")).setExecutor(new SetSpawnCommand());
     Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
     Objects.requireNonNull(getCommand("slapi")).setExecutor(new SLAPICommand());
     Objects.requireNonNull(getCommand("verify")).setExecutor(new MinecraftCommand());


       plugin = this;
       Bukkit.getScheduler().runTaskLater((Plugin)plugin, VerifySLAPI::loadVerified, 30L);
   }








   public void onDisable() {
     SLAPI.saveBalances();
     files.terminate();




     EmbedBuilder builder = (new EmbedBuilder()).setColor(Color.RED).setDescription(":x: **Server Stoped!**").setTimestamp(Instant.now());
     assert mcchat != null;
     mcchat.sendMessageEmbeds(builder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();

    jda.shutdown();
   }

   public static LemonZero getPlugin() {
    return plugin;
  }
  //Homes
  public void  addHome(UUID id, Location location) {
      this.homes.put(id, location);
  }

    public Location getHome(UUID id) {
        return this.homes.get(id);
    }

    public boolean hasHome(UUID id) {
        return this.homes.containsKey(id);
    }

    public HashMap<UUID, Location> getHomes() {
        return homes;
    }

    public HomeFiles getFiles() {
        return files;
    }

 }


