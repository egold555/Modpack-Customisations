package org.golde.forge.mpc.proxy;

import org.golde.forge.mpc.Constants;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		itemMagnet.registerClient();
	}

	@Override
	public void init() {
		super.init();

	}

	@Override
	public void postInit() {
		super.postInit();

	}

}
