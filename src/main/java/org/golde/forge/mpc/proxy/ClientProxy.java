package org.golde.forge.mpc.proxy;

import org.golde.forge.mpc.Constants;
import org.golde.forge.mpc.events.Events;
import org.golde.forge.mpc.events.EventsClient;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		itemMagnet.registerClient();
	}

	@Override
	public void init() {
		super.init();
		MinecraftForge.EVENT_BUS.register(new EventsClient());

	}

	@Override
	public void postInit() {
		super.postInit();

	}

}
