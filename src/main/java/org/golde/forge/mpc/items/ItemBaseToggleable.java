package org.golde.forge.mpc.items;

import org.golde.forge.mpc.Constants;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBaseToggleable extends ItemBase {

	public ItemBaseToggleable(String name) {
		super(name);
		setMaxStackSize(1);
		canRepair = false;
		setMaxDamage(0);
	}

	@Override
	public void registerClient() {
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Constants.MODID + ":" + name, "inventory");
		ModelLoader.setCustomModelResourceLocation(this, 0, itemModelResourceLocation);
		ModelLoader.setCustomModelResourceLocation(this, 1, itemModelResourceLocation);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		if (!world.isRemote && player.isSneaking()) {
			player.getHeldItem(handIn).setItemDamage(player.getHeldItem(handIn).getItemDamage() == 0 ? 1 : 0);
			onToggle(isActivated(player.getHeldItem(handIn)));
		}
		return super.onItemRightClick(world, player, handIn);
	}
	
	public void onToggle(boolean activated) {
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return isActivated(stack);
	}
	
	protected boolean isActivated(ItemStack item) {
		return item.getItemDamage() == 1;
	}
	
}
