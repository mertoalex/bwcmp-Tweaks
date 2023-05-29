package io.mertoalex.bwcmp_tweaks.item.tool;

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;

public class ItemAxe extends net.minecraft.item.ItemAxe {
	private String name;

	public ItemAxe(ToolMaterial material, String name) {
		super(material, 8f, -3.1f);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel(/*Item item*/) {
		bwcmpTweaks.proxy.registerItemRenderer(this, 0, name);
	}

}