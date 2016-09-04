package com.panjaco.healandfeed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		if(sender instanceof Player){
			//A player has send the command
			
			//Check if they sent a target player as an argument
			if(args.length == 1){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				targetPlayer.setHealth(20);
				player.sendMessage(ChatColor.GREEN + "You have been healed");
				return true;
			}else{
				((Player) sender).setHealth(20);
				player.sendMessage(ChatColor.GREEN + "You have been healed");
				return true;
			}
		}else{
			//The console has sent the command
			
			//Check if they sent a target player as an argument
			if(args.length == 0){
				player.sendMessage(ChatColor.DARK_RED + "Usage: /heal <player>");
				return false;
			}else{
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				targetPlayer.setHealth(20);
				player.sendMessage(ChatColor.GREEN + "You have been healed");
				return true;
			}
		}
	}

}
