package me.affinity.allcake;

import org.bukkit.plugin.java.JavaPlugin;

import me.affinity.allcake.listeners.Listeners;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new Listeners(this);
	}

}
