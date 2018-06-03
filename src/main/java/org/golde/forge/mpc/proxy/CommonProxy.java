package org.golde.forge.mpc.proxy;

import org.golde.forge.mpc.RecipeManager;
import org.golde.forge.mpc.events.Events;
import org.golde.forge.mpc.items.ItemMagnet;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.shared.TinkerFluids;

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
		//Tinkers Construct

		//Rails
		TinkerRegistry.registerMelting(Blocks.RAIL, TinkerFluids.iron, Material.VALUE_Nugget * 3);
		TinkerRegistry.registerMelting(Blocks.DETECTOR_RAIL, TinkerFluids.iron, Material.VALUE_Nugget * 3);
		TinkerRegistry.registerMelting(Blocks.ACTIVATOR_RAIL, TinkerFluids.iron, Material.VALUE_Nugget * 3);
		TinkerRegistry.registerMelting(Blocks.GOLDEN_RAIL, TinkerFluids.gold, Material.VALUE_Nugget * 3);

		//Armor - Iron
		TinkerRegistry.registerMelting(Items.IRON_HELMET, TinkerFluids.iron, Material.VALUE_Ingot * 5);
		TinkerRegistry.registerMelting(Items.IRON_CHESTPLATE, TinkerFluids.iron, Material.VALUE_Ingot * 8);
		TinkerRegistry.registerMelting(Items.IRON_LEGGINGS, TinkerFluids.iron, Material.VALUE_Ingot * 7);
		TinkerRegistry.registerMelting(Items.IRON_BOOTS, TinkerFluids.iron, Material.VALUE_Ingot * 4);

		//Armor - Gold
		TinkerRegistry.registerMelting(Items.GOLDEN_HELMET, TinkerFluids.gold, Material.VALUE_Ingot * 5);
		TinkerRegistry.registerMelting(Items.GOLDEN_CHESTPLATE, TinkerFluids.gold, Material.VALUE_Ingot * 8);
		TinkerRegistry.registerMelting(Items.GOLDEN_LEGGINGS, TinkerFluids.gold, Material.VALUE_Ingot * 7);
		TinkerRegistry.registerMelting(Items.GOLDEN_BOOTS, TinkerFluids.gold, Material.VALUE_Ingot * 4);

		//Tools - Iron
		TinkerRegistry.registerMelting(Items.IRON_AXE, TinkerFluids.iron, Material.VALUE_Ingot * 3);
		TinkerRegistry.registerMelting(Items.IRON_PICKAXE, TinkerFluids.iron, Material.VALUE_Ingot * 3);
		TinkerRegistry.registerMelting(Items.IRON_SHOVEL, TinkerFluids.iron, Material.VALUE_Ingot * 1);
		TinkerRegistry.registerMelting(Items.IRON_SWORD, TinkerFluids.iron, Material.VALUE_Ingot * 2);
		TinkerRegistry.registerMelting(Items.IRON_HOE, TinkerFluids.iron, Material.VALUE_Ingot * 2);

		//Tools - Gold
		TinkerRegistry.registerMelting(Items.IRON_AXE, TinkerFluids.gold, Material.VALUE_Ingot * 3);
		TinkerRegistry.registerMelting(Items.IRON_PICKAXE, TinkerFluids.gold, Material.VALUE_Ingot * 3);
		TinkerRegistry.registerMelting(Items.IRON_SHOVEL, TinkerFluids.gold, Material.VALUE_Ingot * 1);
		TinkerRegistry.registerMelting(Items.IRON_SWORD, TinkerFluids.gold, Material.VALUE_Ingot * 2);
		TinkerRegistry.registerMelting(Items.IRON_HOE, TinkerFluids.gold, Material.VALUE_Ingot * 2);
	}

}
