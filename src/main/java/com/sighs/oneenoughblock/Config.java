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
                .define("wrapper",new ArrayList<>(List.of("minecraft:end_stone>minecraft:acacia_log","#logs>tnt")));
        SPEC = BUILDER.build();
    }
}
