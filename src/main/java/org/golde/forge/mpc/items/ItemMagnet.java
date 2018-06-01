package org.golde.forge.mpc.items;

import java.util.Iterator;

import org.golde.forge.mpc.helpers.EntityHelpers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class ItemMagnet extends ItemBaseToggleable {

	private final double distanceFromPlayer = 4.5;

	public ItemMagnet() {
		super("magnet");
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {

		if (world.isRemote) {
			return;
		}

		if (!isActivated(stack)) {
			return;
		}

		if (!(entity instanceof EntityPlayer)) {
			return;
		}

		EntityPlayer player = (EntityPlayer) entity;


		Iterator iterator = EntityHelpers.getEntitiesInRange(EntityItem.class, world, player.posX, player.posY, player.posZ, this.distanceFromPlayer).iterator();

		while (iterator.hasNext()) {
			EntityItem itemToGet = (EntityItem) iterator.next();

			EntityItemPickupEvent pickupEvent = new EntityItemPickupEvent(player, itemToGet);
			MinecraftForge.EVENT_BUS.post(pickupEvent);
			ItemStack itemStackToGet = itemToGet.getItem();
			int stackSize = itemStackToGet.getCount();

			if (pickupEvent.getResult() == Result.ALLOW || stackSize <= 0 || player.inventory.addItemStackToInventory(itemStackToGet)) {
				player.onItemPickup(itemToGet, stackSize);
				//world.playSoundAtEntity(player, "random.pop", 0.15F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			}
		}

		iterator = EntityHelpers.getEntitiesInRange(EntityXPOrb.class, world, player.posX, player.posY, player.posZ, this.distanceFromPlayer).iterator();
		while (iterator.hasNext()) {
			EntityXPOrb xpToGet = (EntityXPOrb) iterator.next();

			if (xpToGet.isDead || xpToGet.isInvisible()) {
				continue;
			}
			
			int xpAmount = xpToGet.xpValue;
			xpToGet.xpValue = 0;
			player.xpCooldown = 0;
			player.addExperience(xpAmount);
			xpToGet.setDead();
			xpToGet.setInvisible(true);
			//world.playSoundAtEntity(player, "random.orb", 0.08F, 0.5F * ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.8F));
		}


	}

}
