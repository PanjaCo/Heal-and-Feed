package com.panjaco.healandfeed;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HealAndFeed extends JavaPlugin {

	public static ArrayList<Player> noHungerPlayers = new ArrayList<Player>();
	
	public void onEnable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Heal and Feed] Enabled");
		
		//Implement Listeners
		Bukkit.getPluginManager().registerEvents(new HungerLoss(), this);
		
		//Set the commands to run another class
		getCommand("heal").setExecutor(new Heal());
		getCommand("feed").setExecutor(new Feed());
		getCommand("healall").setExecutor(new HealAll());
		getCommand("feedall").setExecutor(new FeedAll());
		getCommand("nohunger").setExecutor(new NoHunger());
	}
	public void onDisable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Heal and Feed] Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
		
		
		return true;
	}
	
	
}
