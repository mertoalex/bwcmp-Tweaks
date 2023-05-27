package io.mertoalex.bwcmp_tweaks.event; // actually I copied some codes from https://github.com/Darkorg69/Better-Punching to there

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
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

	@SubscribeEvent
	public static void onHarverstBlock(BlockEvent.HarvestDropsEvent event) {
		/*bwcmpTweaks.Logger.info("Hi from outside of GRASS.");
		bwcmpTweaks.Logger.info(event.getState().getBlock().toString());*/
		if(event.getState().getBlock().toString().toLowerCase().contains("tallgrass")) {
			//bwcmpTweaks.Logger.info("Hi from inside GRASS.");
			ItemStack stack = event.getHarvester().getHeldItemMainhand();
			//bwcmpTweaks.Logger.info("[*] " + stack.getItem());
			if ((stack.getItem() instanceof ItemSword)) {
				event.setDropChance(0.35f);
				event.getDrops().add(new ItemStack(Item.getByNameOrId("bwcmp_tweaks:grass_fiber")));
				stack.damageItem(1, event.getHarvester());
			}
		}
	}

	@SubscribeEvent
	public static void onHarverstLeave(BlockEvent.HarvestDropsEvent event) {
		if(event.getState().getBlock().toString().toLowerCase().contains("leave")) {
			ItemStack stack = event.getHarvester().getHeldItemMainhand();
			//bwcmpTweaks.Logger.info("[*] " + stack.getItem());
			if ((stack.getItem() instanceof ItemSword)) {
				event.getDrops().add(new ItemStack(Item.getByNameOrId("minecraft:stick")));
				stack.damageItem(1, event.getHarvester());
			}
		}
	}
}
