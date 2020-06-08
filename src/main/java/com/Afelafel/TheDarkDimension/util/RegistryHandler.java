package com.Afelafel.TheDarkDimension.util;

import com.Afelafel.TheDarkDimension.TheDarkDimensionMod;
import com.Afelafel.TheDarkDimension.blocks.BlockItemBase;
import com.Afelafel.TheDarkDimension.blocks.CrackedRubyOre;
import com.Afelafel.TheDarkDimension.blocks.RubyBlock;
import com.Afelafel.TheDarkDimension.items.ItemBase;
import com.Afelafel.TheDarkDimension.world.biomes.DarkDimensionBiome;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TheDarkDimensionMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TheDarkDimensionMod.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TheDarkDimensionMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> CRACKED_RUBY = ITEMS.register("cracked_ruby", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> CRACKED_RUBY_ORE = BLOCKS.register("cracked_ruby_ore", CrackedRubyOre::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> CRACKED_RUBY_ORE_ITEM = ITEMS.register("cracked_ruby_ore", () -> new BlockItemBase(CRACKED_RUBY_ORE.get()));

    // Biome
    public static final RegistryObject<Biome> DARK_DIMENSION = BIOMES.register("dark_dimension",
            () -> new DarkDimensionBiome(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(0.8f).temperature(0f)
                    .waterColor(26).waterFogColor(5929).surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(Blocks.BLACK_CONCRETE_POWDER.getDefaultState(),
                                    Blocks.STONE.getDefaultState(),
                                    Blocks.CLAY.getDefaultState()))
                    .category(Biome.Category.MESA).downfall(0.8f).depth(0.12f).parent(null)));

    public static void registerBiomes() {
        registerBiome(DARK_DIMENSION.get(), BiomeDictionary.Type.MESA, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }


}