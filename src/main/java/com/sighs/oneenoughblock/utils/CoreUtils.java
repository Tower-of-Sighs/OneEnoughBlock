package com.sighs.oneenoughblock.utils;

import com.sighs.oneenoughblock.loader.EntryCache;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class CoreUtils {
    public static <T extends Comparable<T>> void handleBlockState(BlockState blockState, Consumer<BlockState> handler) {
        for (Map.Entry<TagKey<Block>, Block> entry : EntryCache.TagMapCache.entrySet()) {
            if (blockState.is(entry.getKey()) && !blockState.is(entry.getValue())) {
                BlockState result = entry.getValue().defaultBlockState();
                blockState.getValues().forEach((property, comparable) -> {
                    result.trySetValue((Property<T>) property, (T) comparable);
                });
                handler.accept(result);
                return;
            }
        }
        Optional.ofNullable(EntryCache.UnitMapCache.get(blockState.getBlock()))
                .filter(wrapper -> !blockState.is(wrapper))
                .ifPresent(wrapper -> {
                    BlockState result = wrapper.defaultBlockState();
                    blockState.getValues().forEach((property, comparable) -> {
                        result.trySetValue((Property<T>) property, (T) comparable);
                    });
                    handler.accept(result);
                });
    }
}
