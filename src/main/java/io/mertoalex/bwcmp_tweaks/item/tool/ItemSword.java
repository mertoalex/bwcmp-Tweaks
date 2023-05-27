package io.mertoalex.bwcmp_tweaks.item.tool;

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;
//import net.minecraft.item.Item;

public class ItemSword extends net.minecraft.item.ItemSword {
	private String name;

	public ItemSword(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel(/*Item item*/) {
		bwcmpTweaks.proxy.registerItemRenderer(this, 0, name);
	}

}
