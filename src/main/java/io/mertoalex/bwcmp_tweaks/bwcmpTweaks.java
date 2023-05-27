package io.mertoalex.bwcmp_tweaks; //I Don't have any domain btw

import io.mertoalex.bwcmp_tweaks.item.ModItems;
import io.mertoalex.bwcmp_tweaks.proxy.CommonProxy;
import io.mertoalex.bwcmp_tweaks.event.ForgeEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
//import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = bwcmpTweaks.MODID, name = bwcmpTweaks.NAME, version = bwcmpTweaks.VERSION)
public class bwcmpTweaks {
    public static final String MODID = "bwcmp_tweaks";
    public static final String NAME = "Bwcmp Tweaks";
    public static final String VERSION = "0.2";

	public static final Logger Logger = LogManager.getLogger(bwcmpTweaks.MODID);

	@SidedProxy(serverSide = "io.mertoalex.bwcmp_tweaks.proxy.CommonProxy", clientSide = "io.mertoalex.bwcmp_tweaks.proxy.ClientProxy")
	public static CommonProxy proxy;

	public static final Item.ToolMaterial rockTM = EnumHelper.addToolMaterial("ROCK", 0, 16, 2, 1, 0);//(name, harvestLevel, maxUses, efficiency, damage, enchantability)

	@EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        Logger.info("[*] bwcmpTweakes inited!");
	}

	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(ForgeEvents.class);
    }

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
		}
		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			ModItems.registerModels();
		}
	}
}
//minecraft:tallgrass