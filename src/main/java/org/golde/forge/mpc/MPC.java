package org.golde.forge.mpc;

import org.golde.forge.mpc.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MODID, acceptedMinecraftVersions = Constants.ACCEPTED_VERSIONS, name = Constants.NAME, dependencies = Constants.DEPENDENCIES)
public class MPC {

	@Mod.Instance(Constants.MODID)
	public static MPC instance;

	public CreativeTabs customTab = new CreativeTabs("mpc") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(CommonProxy.itemMagnet);
		}
	};

	@SidedProxy(clientSide = Constants.PROXY_CLIENT, serverSide = Constants.PROXY_COMMON)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

}
