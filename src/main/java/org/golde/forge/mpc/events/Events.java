package org.golde.forge.mpc.events;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {

	@SubscribeEvent //Stop zombie pigman from spawning when portal is above them
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
	
}
