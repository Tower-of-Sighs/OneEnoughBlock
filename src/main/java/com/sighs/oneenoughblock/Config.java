package com.sighs.oneenoughblock;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Oneenoughblock.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<List<String>> WRAPPERS;

    static final ForgeConfigSpec SPEC ;
    static {
        WRAPPERS = BUILDER
                .comment("配置方块替换逻辑格式为<方块id/tag> + > + <方块id>")
                .comment("例如:")
                .comment("\"minecraft:end_stone>minecraft:acacia_log\"","\"#logs > tnt\"")
                .define("wrapper",new ArrayList<>(List.of()));
        SPEC = BUILDER.build();
    }
}
