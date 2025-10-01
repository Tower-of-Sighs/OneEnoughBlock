package com.sighs.oneenoughblock.loader;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntryCache {
    public static final HashMap<Block, Block> UnitMapCache = new HashMap<>();
    public static final HashMap<net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block>, Block> TagMapCache = new HashMap<>();

    public static void putEntry(Entry rule) {
        String result = rule.getResult();
        for (String match : rule.getMatch()) {
            var to = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.trim()));
            if (to == null) return;
            if (match.startsWith("#")) {
                var from = BlockTags.create(new ResourceLocation(match.trim().substring(1)));
                TagMapCache.put(from, to);
                return;
            }
            var from = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(match.trim()));
            if (from != null) {
                UnitMapCache.put(from, to);
            }
        }
    }

    public static void clearCache() {
        UnitMapCache.clear();
        TagMapCache.clear();
    }

    public static void loadAllRule() {
        clearCache();
        EntryLoader.loadAll().forEach(EntryCache::putEntry);
    }
}