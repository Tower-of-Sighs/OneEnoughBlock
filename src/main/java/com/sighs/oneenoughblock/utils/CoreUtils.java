package com.sighs.oneenoughblock.utils;

import com.sighs.oneenoughblock.loader.EntryCache;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class CoreUtils {
    public static void handleBlockState(BlockState blockState, Consumer<BlockState> handler) {
        for (Map.Entry<TagKey<Block>, Block> entry : EntryCache.TagMapCache.entrySet()) {
            if (blockState.is(entry.getKey()) && !blockState.is(entry.getValue())) {
                handler.accept(entry.getValue().defaultBlockState());
            }
        }
        Optional.ofNullable(EntryCache.UnitMapCache.get(blockState.getBlock()))
                .filter(wrapper -> !blockState.is(wrapper))
                .ifPresent(wrapper -> {
                    handler.accept(wrapper.defaultBlockState());
                });
    }
}
