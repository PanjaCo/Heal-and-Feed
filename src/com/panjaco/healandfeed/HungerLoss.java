package com.panjaco.healandfeed;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerLoss implements Listener {

	@EventHandler
	public void onHungerLoss(FoodLevelChangeEvent event){
		Player player = (Player) event.getEntity();
		double hungerLevel = event.getFoodLevel();
		if(HealAndFeed.noHungerPlayers.contains(player)){
			event.setCancelled(true);
		}
		
	}
	
	
}
