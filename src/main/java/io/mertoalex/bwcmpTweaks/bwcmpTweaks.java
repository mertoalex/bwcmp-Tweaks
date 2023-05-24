package io.mertoalex.bwcmpTweaks; //I Don't have any domain btw

//import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = bwcmpTweaks.MODID, name = bwcmpTweaks.NAME, version = bwcmpTweaks.VERSION)
public class bwcmpTweaks {
    public static final String MODID = "bwcmptweaks";
    public static final String NAME = "Bwcmp Tweaks";
    public static final String VERSION = "0.1";

	public static final Logger Logger = LogManager.getLogger(bwcmpTweaks.MODID);

	@EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        Logger.info("bwcmpTweakes inited!");
	}
}
