package com.Afelafel.TheDarkDimension;

import com.Afelafel.TheDarkDimension.util.RegistryHandler;
import com.Afelafel.TheDarkDimension.world.gen.examplemodOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("examplemod")
public class TheDarkDimensionMod {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "examplemod";

    public TheDarkDimensionMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("DarkDimensionTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.CRACKED_RUBY.get());
        }
    };
        @SubscribeEvent
        public static void LoadCompleteEvent(FMLLoadCompleteEvent event)
        {
            examplemodOreGen.generateOre();
        }
    }


