package org.golde.forge.mpc.helpers;

import java.util.ArrayList;
import java.util.HashMap;

import static org.lwjgl.input.Keyboard.*;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.FMLClientHandler;

public class KeybindUtils {
	
	public static final KeyBinding[] ALL_BINDINGS = FMLClientHandler.instance().getClient().gameSettings.keyBindings;
	
	/** 
	 * Get the names of all bindings for a certain key and modifier
	 * 
	 * @param keyId the LWJGL code of the key to get the binding names for
	 * @param modifier the modifier of the key to get the binding names for
	 */
	public static ArrayList<String> getBindingNames(int keyId, KeyModifier modifier){
		ArrayList<String> bindingNames = new ArrayList();
		
		if (keyId == 0)
			return bindingNames;
		
		for (KeyBinding currentBinding : ALL_BINDINGS) {
			if (currentBinding.getKeyCode() == keyId && currentBinding.getKeyModifier() == modifier)
			    bindingNames.add(I18n.format(currentBinding.getKeyCategory()) + ": " + I18n.format(currentBinding.getKeyDescription()));
		}
		return bindingNames;
	}
	
	/** 
	 * Get the number of conflicts for a key binding 
	 * 
	 * @param binding the binding to check
	 */
	public static int getConficts(KeyBinding binding) {
		int num = 0;
		for (KeyBinding currentBinding : ALL_BINDINGS) {
			if( !(currentBinding == binding) ) {
				if (currentBinding.getKeyCode() == binding.getKeyCode() && currentBinding.getKeyModifier() == binding.getKeyModifier())
				    num++;
			}
		}
		return num;
	}
	
	/** 
	 * Get a list of all binding categories
	 */
	
	public static ArrayList<String> getCategories() {
		ArrayList<String> categories = new ArrayList();
		
		for (KeyBinding currentBinding : ALL_BINDINGS) {
			if ( !categories.contains(currentBinding.getKeyCategory()) )
					categories.add(currentBinding.getKeyCategory());
		}
		
		return categories;
	}
}
