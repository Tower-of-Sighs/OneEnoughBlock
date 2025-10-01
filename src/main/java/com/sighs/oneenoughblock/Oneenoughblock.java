package com.sighs.oneenoughblock;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Oneenoughblock.MODID)
public class Oneenoughblock {
    public static final String MODID = "oneenoughblock";

    public Oneenoughblock(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
