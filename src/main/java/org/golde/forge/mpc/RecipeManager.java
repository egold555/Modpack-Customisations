package org.golde.forge.mpc;

import org.golde.forge.mpc.proxy.CommonProxy;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeManager {

	private static ResourceLocation optionalGroup = new ResourceLocation("");

	public static void init() {

		register("magnet", CommonProxy.itemMagnet, new Object[] {
				"B R",
				"I I",
				"III",	
				'B', new ItemStack(Items.DYE, 1, 4),
				'R', Items.REDSTONE,
				'I', Items.IRON_INGOT,
		});

	}

	private static void register(String name, Item output, Object[] params) {
		GameRegistry.addShapedRecipe(new ResourceLocation(name), new ResourceLocation("MPC"), new ItemStack(output), params);
	}

	private static void register(String name, ItemStack output, Object[] params) {
		GameRegistry.addShapedRecipe(new ResourceLocation("mpc" + name), new ResourceLocation("MPC"), output, params);
	}

}
