package net.cmoney03.bunkersandblasters;

import com.mojang.logging.LogUtils;
import net.cmoney03.bunkersandblasters.block.ModBlocks;
import net.cmoney03.bunkersandblasters.item.ModCreativeModTabs;
import net.cmoney03.bunkersandblasters.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BunkersAndBlasters.MOD_ID)
public class BunkersAndBlasters {
    public static final String MOD_ID = "bunkersandblasters";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BunkersAndBlasters() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {


            //PLASTEEL//
            event.accept(ModItems.PLASTEEL_INGOT);
            event.accept(ModItems.MOLTEN_PLASTEEL);
            event.accept(ModBlocks.PLASTEEL_BLOCK);


            //SANGUINITE//
            event.accept(ModItems.RAW_SANGUINITE);
            event.accept(ModItems.SANGUINITE_INGOT);
            event.accept(ModBlocks.NETHER_SANGUINITE_ORE);


            //CUSTOM//
            event.accept(ModItems.METAL_DETECTOR);


            //VISCOROK//
            event.accept(ModBlocks.VISCOROK_ORE);
            event.accept(ModBlocks.DEEPSLATE_VISCOROK_ORE);
            event.accept(ModBlocks.VISCOROK_BLOCK);
            event.accept(ModItems.VISCOROK_CHUNK);
            event.accept(ModItems.VISCOROK_INGOT);



        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
