package me.fast.lemonzero.Discord.Verify;

import java.util.Objects;
import me.fast.lemonzero.LemonZero;
import me.fast.lemonzero.Minecraft.Economy.EconomyManager;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VerifyDiscordCommand extends ListenerAdapter {
  public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent e) {
    if (e.getName().equalsIgnoreCase("verify"))
      if (!MinecraftCommand.verifyedAsMember.containsKey(e.getMember())) {
        Bukkit.broadcastMessage(MinecraftCommand.verifyedAsMember.toString());
        if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(((OptionMapping)Objects.<OptionMapping>requireNonNull(e.getOption("username"))).getAsString()))) {
          Player p = Bukkit.getPlayer(((OptionMapping)Objects.<OptionMapping>requireNonNull(e.getOption("username"))).getAsString());
          if (((OptionMapping)Objects.<OptionMapping>requireNonNull(e.getOption("code"))).getAsInt() == ((Integer)MinecraftCommand.verifynum.get(p)).intValue()) {
            MinecraftCommand.verifyedAsUUID.put(((Player)Objects.<Player>requireNonNull(p)).getUniqueId(), e.getMember());
            MinecraftCommand.verifyedAsMember.put(e.getMember(), p.getUniqueId());
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7&lSystem &8>> &d" + p.getDisplayName() + " &fJust verified their account and got rewards for doing so! &b(/verify)"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&lSystem &8>> &bThank you for verifying here are your rewards: \n  &8- &2$&f5&a&lK \n &8- &e500 Lemons"));
            VerifySLAPI.savePlayerVerified(p);
            EconomyManager.setBal(p, Double.valueOf(EconomyManager.getBal(p).doubleValue() + 5000.0D));
            ((Guild)Objects.<Guild>requireNonNull(e.getGuild())).addRoleToMember((UserSnowflake)Objects.requireNonNull(e.getMember()), Objects.<Role>requireNonNull(LemonZero.jda.getRoleById("1020830705632161872"))).complete();
            e.reply(":white_check_mark: Connected " + ((Member)Objects.<Member>requireNonNull(e.getMember())).getAsMention() + " to *" + ((Player)Objects.<Player>requireNonNull(p)).getDisplayName() + "*.").queue();
          } else {
            e.reply(":x: That code `" + ((OptionMapping)Objects.<OptionMapping>requireNonNull(e.getOption("code"))).getAsString() + "` is not a valid code!").queue();
          } 
        } else {
          e.reply(":x: That player is not online!").queue();
        } 
      } else {
        e.reply(":x: your username is already connected to another account please contact a admin if this seems wrong!").queue();
      }  
  }
}
