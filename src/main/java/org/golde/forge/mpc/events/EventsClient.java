package org.golde.forge.mpc.events;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.golde.forge.mpc.gui.GuiKeyWizard;

import mekanism.common.block.BlockCardboardBox.BlockData;
import mekanism.common.util.ItemDataUtils;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value = Side.CLIENT)
public class EventsClient {
	
	@SubscribeEvent //Keybinds new gui test
	public void onGuiOpen(GuiOpenEvent e) {
		if(e.getGui() == null) {return;}

		if(e.getGui() instanceof GuiControls) {
			GuiControls ctrls = (GuiControls)e.getGui();
			try {
				GuiScreen parentScreen = (GuiScreen)FieldUtils.readField(ctrls, "parentScreen", true);
				e.setGui(new GuiKeyWizard(parentScreen));
			} 
			catch (IllegalArgumentException | IllegalAccessException | SecurityException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	@SubscribeEvent //Cardboard box render mob type stored in spawner
	public void tooltipRenderEvent(ItemTooltipEvent e) {
		if(e.getItemStack().getItem().getRegistryName().toString().equals("mekanism:cardboardbox")) {
			BlockData blockData = BlockData.read(ItemDataUtils.getCompound(e.getItemStack(), "blockData"));
			if(blockData.tileTag != null)
			{
				if(blockData.tileTag.getString("id").equals("minecraft:mob_spawner")) {
					NBTTagCompound base = (NBTTagCompound) blockData.tileTag.getTag("SpawnData");
					String mob = base.getString("id");
					mob = mob.replace("minecraft:", "");
					mob = mob.substring(0, 1).toUpperCase() + mob.substring(1);
					e.getToolTip().add("Mob: " + mob);
				}
			}
			
		}
	}

}
