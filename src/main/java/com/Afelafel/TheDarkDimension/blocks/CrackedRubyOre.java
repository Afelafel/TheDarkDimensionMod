package com.Afelafel.TheDarkDimension.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrackedRubyOre extends Block {

    public CrackedRubyOre() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0f, 4.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }
}
