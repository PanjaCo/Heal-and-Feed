package com.panjaco.healandfeed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class FeedAll implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// TODO Auto-generated method stub
		Player player = (Player) sender;
		
		for(Player p : player.getServer().getOnlinePlayers()){
			p.setFoodLevel(20);
			p.sendMessage(ChatColor.GREEN + "You have been fed");
		}
		if(sender instanceof Player){
			sender.sendMessage(ChatColor.GREEN + "Every player has been fed");
		}else{
			sender.sendMessage("Every player has been fed");
		}
		return true;
	}

}
