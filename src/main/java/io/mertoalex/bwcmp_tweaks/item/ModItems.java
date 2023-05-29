package io.mertoalex.bwcmp_tweaks.item;

import io.mertoalex.bwcmp_tweaks.bwcmpTweaks;
import io.mertoalex.bwcmp_tweaks.item.tool.ItemAxe;
import io.mertoalex.bwcmp_tweaks.item.tool.ItemPickaxe;
import io.mertoalex.bwcmp_tweaks.item.tool.ItemSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	public static ItemBase grassFiber = new ItemBase("grass_fiber").setCreativeTab(CreativeTabs.MATERIALS);
	public static ItemSword grassCutter = new ItemSword(bwcmpTweaks.rockTM , "grass_cutter");
	public static ItemAxe primitiveAxe = new ItemAxe(bwcmpTweaks.rockTM , "primitive_axe");
	public static ItemPickaxe primitivePickaxe = new ItemPickaxe(bwcmpTweaks.rockTM , "primitive_pickaxe");

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				grassFiber,
				grassCutter,
				primitiveAxe,
				primitivePickaxe
		);
		OreDictionary.registerOre("rock", Items.FLINT);
	}

	public static void registerModels(){
		grassFiber.registerItemModel();
		grassCutter.registerItemModel();
		primitiveAxe.registerItemModel();
		primitivePickaxe.registerItemModel();
	}
}