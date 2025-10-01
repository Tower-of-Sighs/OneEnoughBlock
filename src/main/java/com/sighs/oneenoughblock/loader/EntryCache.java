package com.sighs.oneenoughblock.loader;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class EntryCache {
    public static final HashMap<Block, Block> UnitMapCache = new HashMap<>();
    public static final HashMap<net.minecraft.tags.TagKey<Block>, Block> TagMapCache = new HashMap<>();

    public static void putEntry(Entry rule) {
        String result = rule.getResult();
        for (String match : rule.getMatch()) {
            var to = BuiltInRegistries.BLOCK.get(ResourceLocation.tryParse(result.trim()));
            if (to == null) return;
            if (match.startsWith("#")) {
                var from = BlockTags.create(ResourceLocation.tryParse(match.trim().substring(1)));
                TagMapCache.put(from, to);
                return;
            }
            var from = BuiltInRegistries.BLOCK.get(ResourceLocation.tryParse(match.trim()));
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