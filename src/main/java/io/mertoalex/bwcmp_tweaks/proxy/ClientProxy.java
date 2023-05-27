package io.mertoalex.bwcmp_tweaks.proxy;

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(bwcmpTweaks.MODID + ":" + id, "inventory"));
	}
}