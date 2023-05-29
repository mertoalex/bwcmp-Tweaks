package io.mertoalex.bwcmp_tweaks.event; // actually I copied some codes from https://github.com/Darkorg69/Better-Punching to there

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;
import io.mertoalex.bwcmp_tweaks.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = bwcmpTweaks.MODID)
public class ForgeEvents {

	@SubscribeEvent
    public static void onTryHarvestBlock(PlayerEvent.BreakSpeed event) {
		IBlockState state = event.getState();
		if (state.getMaterial() == Material.WOOD) {
			ItemStack stack = event.getEntityPlayer().getHeldItemMainhand();
			//bwcmpTweaks.Logger.info("[*] " + stack.getItem());
			if (!(stack.getItem() instanceof ItemAxe)) {
					event.setNewSpeed(-1.0F); return;
			}		event.setNewSpeed(event.getOriginalSpeed());

		}
    }

	@SubscribeEvent
	public static void onHarverstBlock(BlockEvent.HarvestDropsEvent event) {
		String blockname = event.getState().getBlock().toString().toLowerCase();
		if(blockname.contains("tallgrass") || blockname.contains("leave")) {
			event.getDrops().add(new ItemStack(ModItems.grassFiber));
			event.setDropChance(0f);
			try {
				ItemStack stack = event.getHarvester().getHeldItemMainhand();
				if ((stack.getItem() instanceof ItemSword)) {
					event.setDropChance(0.35f);
					stack.damageItem(1, event.getHarvester());
				}
			} catch (NullPointerException e) {
				bwcmpTweaks.Logger.info(e.toString());
			}
		} if(event.getState().getBlock().toString().toLowerCase().contains("leave")) {
			event.getDrops().add(new ItemStack(Items.STICK));
			event.setDropChance(0f);
			try {
				ItemStack stack = event.getHarvester().getHeldItemMainhand();
				if ((stack.getItem() instanceof ItemSword)) {
					event.setDropChance(1f);
					stack.damageItem(1, event.getHarvester());
				}
			} catch (NullPointerException e) {
				bwcmpTweaks.Logger.info(e.toString());
			}
		}
	}
}
