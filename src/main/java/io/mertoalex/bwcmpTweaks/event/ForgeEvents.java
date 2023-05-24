package io.mertoalex.bwcmpTweaks.event; // actually I copied some codes from https://github.com/Darkorg69/Better-Punching to there

import io.mertoalex.bwcmpTweaks.bwcmpTweaks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = bwcmpTweaks.MODID)
public class ForgeEvents {
	@SubscribeEvent
    public static void onPunchWood(PlayerEvent.BreakSpeed event) {
		IBlockState state = event.getState();
		if (state.getMaterial() == Material.WOOD) {
			ItemStack stack = event.getEntityPlayer().getHeldItemMainhand();
			//bwcmpTweaks.Logger.info("[*] " + stack.getItem());
			if (!(stack.getItem() instanceof ItemAxe)) {
					event.setNewSpeed(-1.0F); return;
			}		event.setNewSpeed(event.getOriginalSpeed());

		}
    }
}
