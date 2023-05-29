package io.mertoalex.bwcmp_tweaks.item.tool;

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe {
	private String name;

	public ItemPickaxe(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	public void registerItemModel(/*Item item*/) {
		bwcmpTweaks.proxy.registerItemRenderer(this, 0, name);
	}

}