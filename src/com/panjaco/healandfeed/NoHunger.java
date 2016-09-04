package com.panjaco.healandfeed;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.healandfeed.HealAndFeed;

import net.md_5.bungee.api.ChatColor;

public class NoHunger implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		if(args.length == 0){
			if(HealAndFeed.noHungerPlayers.contains(player)){
				HealAndFeed.noHungerPlayers.remove(player);
				player.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.RED + "Infinite Hunger disabled");
			}else{
				HealAndFeed.noHungerPlayers.add(player);
				player.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.GREEN + "Infinite Hunger enabled");
				player.setFoodLevel(20);
			}
		}else{
			Player target;
			try{
				target = Bukkit.getPlayer(args[0]);
			}catch(Exception e){
				sender.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.RED + args[0] + " could not be found!");
				return true;
			}
			
			if(HealAndFeed.noHungerPlayers.contains(target)){
				HealAndFeed.noHungerPlayers.remove(target);
				target.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.RED + "Infinite Hunger disabled");
				player.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.RED + "Infinite Hunger disabled for " + target.getDisplayName());
			}else{
				HealAndFeed.noHungerPlayers.add(target);
				target.setFoodLevel(20);
				player.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.GREEN + "Infinite Hunger enabled");
				target.sendMessage(ChatColor.AQUA + "[Heal and Feed] " + ChatColor.GREEN + "Infinite Hunger enabled for " + target.getDisplayName());
			}
		}
		
		return true;
	}

}
