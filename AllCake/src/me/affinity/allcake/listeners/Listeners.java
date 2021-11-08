package me.affinity.allcake.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.affinity.allcake.Main;

public class Listeners implements Listener{
	
	private Main plugin;
	
	public Listeners(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void cakeTime(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Material item = e.getItem().getType();
		Location loc = p.getLocation();
		int x = 16;
		int w = 1;
		
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta sword_meta = sword.getItemMeta();
		sword_meta.setDisplayName("Food Sword");
		List<String> sword_lore = new ArrayList<String>();
		sword_lore.add("somewhat threatening, but not really");
		sword_meta.setLore(sword_lore);
		sword.setItemMeta(sword_meta);
		
		if(item == Material.WOODEN_SWORD) {
			p.getWorld().dropItemNaturally(loc, sword);
		}
		
		if(item == Material.DIAMOND_SWORD) {
			p.sendMessage("give me food");
			
			if(p.getFoodLevel() < 15) {
				
				//stacks of 16 - aka stackable items
				//daisy
				ItemStack daisy_stack = new ItemStack(Material.APPLE, w);
				ItemMeta daisy_meta = daisy_stack.getItemMeta();
				daisy_meta.setDisplayName("Oxeye Daisy? Probably?");
				List<String> daisy_lore = new ArrayList<String>();
				daisy_lore.add("Smells like a flower, tastes like cake.");
				daisy_meta.setLore(daisy_lore);
				daisy_stack.setItemMeta(daisy_meta);
				//stick
				ItemStack stick_stack = new ItemStack(Material.BAKED_POTATO, w);
				ItemMeta stick_meta = stick_stack.getItemMeta();
				stick_meta.setDisplayName("Stick... Cake?");
				List<String> stick_lore = new ArrayList<String>();
				stick_lore.add("Please don't attempt to eat this. It probably isn't edible.");
				stick_meta.setLore(stick_lore);
				stick_stack.setItemMeta(stick_meta);
				//blaze powder
				ItemStack blaze_stack = new ItemStack(Material.CARROT, w);
				ItemMeta blaze_meta = blaze_stack.getItemMeta();
				blaze_meta.setDisplayName("Suspicious Powder");
				List<String> blaze_lore = new ArrayList<String>();
				blaze_lore.add("Either gold dust or something very, very illegal.");
				blaze_meta.setLore(blaze_lore);
				blaze_stack.setItemMeta(blaze_meta);
				//bell
				ItemStack bell_stack = new ItemStack(Material.BEETROOT, w);
				ItemMeta bell_meta = bell_stack.getItemMeta();
				bell_meta.setDisplayName("Bell Cake. Cake Bell?");
				List<String> bell_lore = new ArrayList<String>();
				bell_lore.add("The amount of fondant on this could kill you.");
				bell_meta.setLore(bell_lore);
				bell_stack.setItemMeta(bell_meta);
				//bone
				ItemStack bone_stack = new ItemStack(Material.BREAD, w);
				ItemMeta bone_meta = bone_stack.getItemMeta();
				bone_meta.setDisplayName("It's just a bone");
				List<String> bone_lore = new ArrayList<String>();
				bone_lore.add("APPARENTLY LAYERS MAKE IT CAKE SO CRONCH AWAY FRIEND");
				bone_meta.setLore(bone_lore);
				bone_stack.setItemMeta(bone_meta);
				
				
				//stacks of 1 - nonstackable items
				//netherite chestplate
				ItemStack plate_stack = new ItemStack(Material.COOKED_PORKCHOP, w);
				ItemMeta plate_meta = plate_stack.getItemMeta();
				plate_meta.setDisplayName("Fancy Shirt? Not For Eating!");
				List<String> plate_lore = new ArrayList<String>();
				plate_lore.add("I Can't Believe It's Not Cake. Because it's not.");
				plate_meta.setLore(plate_lore);
				plate_stack.setItemMeta(plate_meta);
				//diamonds
				ItemStack diamond_stack = new ItemStack(Material.COOKED_RABBIT, w);
				ItemMeta diamond_meta = diamond_stack.getItemMeta();
				diamond_meta.setDisplayName("Yummy Rock");
				List<String> diamond_lore = new ArrayList<String>();
				diamond_lore.add("At the very least it's rock candy.");
				diamond_meta.setLore(diamond_lore);
				diamond_stack.setItemMeta(diamond_meta);
				
				//message before getting items
				p.sendMessage("NOW");
				//give items to player
				p.getWorld().dropItemNaturally(loc, daisy_stack);
				p.getWorld().dropItemNaturally(loc, stick_stack);
				p.getWorld().dropItemNaturally(loc, blaze_stack);
				p.getWorld().dropItemNaturally(loc, bell_stack);
				p.getWorld().dropItemNaturally(loc, bone_stack);
				p.getWorld().dropItemNaturally(loc, plate_stack);
				p.getWorld().dropItemNaturally(loc, diamond_stack);
				//after recieving message
				if(p.getInventory() == daisy_stack || p.getInventory() == stick_stack || p.getInventory() == blaze_stack || p.getInventory() == bell_stack || p.getInventory() == bell_stack || p.getInventory() == bone_stack || p.getInventory() == plate_stack ||p.getInventory() == diamond_stack) {
					if(item == Material.DIAMOND_SWORD) {
						p.sendMessage("Thank you..? Why are my pockets full of cake????");
					}
						
				}
				
				return;
				
			}
			
		}
		
		if(p.getFoodLevel() < 20) {
			
			if(e.getItem().getType() == Material.CARROT) {
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION , 100, 1));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 1));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HARM, 100, 1));
			}
			
			//post event texts
			if(e.getItem().getType() == Material.BREAD) {
				p.sendMessage("WARNING: this is NOT cake. i repeat, this is NOT ACTUALLY CAKE");
				if(p.getFoodLevel() > 15 )
					p.sendMessage("you... actually ate it");
				if(p.getFoodLevel() < 15 )
					p.sendMessage("that wasn't cake?!");
				}
			if(e.getItem().getType() == Material.BEETROOT) {
				p.sendMessage("The cake is ringing");
			}
			if(e.getItem().getType() == Material.APPLE) {
				p.sendMessage("Tastes like frosting");
			}
			if(e.getItem().getType() == Material.BAKED_POTATO || e.getItem().getType() == Material.COOKED_PORKCHOP) {
				p.sendMessage("Yum!");
			}
			if(e.getItem().getType() == Material.BEETROOT) {
				p.sendMessage("The cake is ringing");
			}
			if(e.getItem().getType() == Material.COOKED_RABBIT) {
				p.sendMessage("Your blood sugar is dangerously high");
			}
			
		}
		
		}
		}
	
