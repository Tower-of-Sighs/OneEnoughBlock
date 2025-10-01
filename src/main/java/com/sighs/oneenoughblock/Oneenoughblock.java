package com.sighs.oneenoughblock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

@Mod(Oneenoughblock.MODID)
public class Oneenoughblock {

    public static final String MODID = "oneenoughblock";

    public Oneenoughblock() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

//    public static Map<Block, Block> wrappers = new HashMap<>();
//    public static Map<net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block>, Block> TagWrapper = new HashMap<>();
//
//    @SubscribeEvent
//    public void onCommonSetup(FMLCommonSetupEvent event) {
//        Config.WRAPPERS.get().forEach(wrapper -> {
//            var s = wrapper.split(">");
//            if (s.length < 2) return;
//            var to = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(s[1].trim()));
//            if (to == null) return;
//            if (s[0].startsWith("#")) {
//                var from = BlockTags.create(new ResourceLocation(s[0].trim().substring(1)));
//                TagWrapper.put(from, to);
//                return;
//            }
//            var from = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(s[0].trim()));
//            if (from != null) {
//                wrappers.put(from, to);
//            }
//        });
//    }
}
