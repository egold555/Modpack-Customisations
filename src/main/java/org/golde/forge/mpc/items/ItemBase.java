package org.golde.forge.mpc.items;

import org.golde.forge.mpc.Constants;
import org.golde.forge.mpc.MPC;
import org.golde.forge.mpc.proxy.CommonProxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemBase extends Item {

	protected final String name;
	
	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(MPC.instance.customTab);
		ForgeRegistries.ITEMS.register(this);
	}
	
	public void registerClient() {
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Constants.MODID + ":" + name, "inventory");
		ModelLoader.setCustomModelResourceLocation(this, 0, itemModelResourceLocation);
	}
	
}
