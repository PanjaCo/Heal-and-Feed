package com.panjaco.healandfeed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Feed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		if(sender instanceof Player){
			if(args.length == 0){
				((Player) sender).setFoodLevel(20);
				player.sendMessage(ChatColor.GREEN + "You have been fed");
				return true;
			}else{
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				if(targetPlayer.isOnline()){
					targetPlayer.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "You have been fed");
					return true;
				}else{
					player.sendMessage(ChatColor.DARK_RED + "That player does not exist/is not online");
					return false;
				}
			}
		}else{
			if(args.length == 1){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				if(targetPlayer.isOnline()){
					targetPlayer.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "You have been fed");
					return true;
				}else{
					player.sendMessage(ChatColor.DARK_RED + "That player does not exist/is not online");
					return false;
				}
			}else{
				player.sendMessage(ChatColor.DARK_RED + "Usage: /feed <player>");
				return false;
			}
		}
	}

}
