package org.golde.forge.mpc;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.golde.forge.mpc.gui.GuiKeyWizard;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {

	@SubscribeEvent
	public void mobSpawnEvent(EntityJoinWorldEvent e) {
		if(e.getEntity() instanceof EntityPigZombie || e.getEntity() instanceof EntityChicken) {
			BlockPos pos = e.getEntity().getPosition();
			IBlockState bs = e.getWorld().getBlockState(pos);

			//Blocks above portal stop mobs from spawning in the portal
			if(!e.getWorld().canBlockSeeSky(pos.up(4)) && bs.getMaterial() == Material.PORTAL) {
				e.setCanceled(true);
				e.getEntity().setSilent(true);
				e.getEntity().setDead();
			}

		}
	}

	@SubscribeEvent
	public void onGuiOpen(GuiOpenEvent e) {
		if(e.getGui() == null) {return;}

		if(e.getGui() instanceof GuiControls) {
			GuiControls ctrls = (GuiControls)e.getGui();
			try {
				GuiScreen parentScreen = (GuiScreen)FieldUtils.readField(ctrls, "parentScreen", true);
				if(parentScreen instanceof GuiOptions) {
					System.out.println("Options!");
				}
				e.setGui(new GuiKeyWizard(parentScreen));
			} 
			catch (IllegalArgumentException | IllegalAccessException | SecurityException e1) {
				e1.printStackTrace();
			}
			
		}
	}

}
