package org.golde.forge.mpc.proxy;

import org.golde.forge.mpc.Events;
import org.golde.forge.mpc.RecipeManager;
import org.golde.forge.mpc.items.ItemMagnet;

import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public static ItemMagnet itemMagnet;
	
	public void preInit() {
		itemMagnet = new ItemMagnet();
	}
	
	public void init() {
		MinecraftForge.EVENT_BUS.register(new Events());
		RecipeManager.init();
	}
	
	public void postInit() {
		
	}
	
}
