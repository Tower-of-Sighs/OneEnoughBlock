package com.sighs.oneenoughblock.utils;

import com.sighs.oneenoughblock.loader.EntryCache;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class CoreUtils {
    public static void handleBlockState(BlockState blockState, Consumer<BlockState> handler) {
        for (Map.Entry<TagKey<Block>, Block> entry : EntryCache.TagMapCache.entrySet()) {
            if (blockState.is(entry.getKey()) && !blockState.is(entry.getValue())) {
                handler.accept(saveState(blockState,entry.getValue().defaultBlockState()));
                return;
            }
        }
        Optional.ofNullable(EntryCache.UnitMapCache.get(blockState.getBlock()))
                .filter(wrapper -> !blockState.is(wrapper))
                .ifPresent(wrapper -> {
                    handler.accept(saveState(blockState,wrapper.defaultBlockState()));
                });
    }

    public static <T extends Comparable<T>> BlockState saveState(BlockState from, BlockState to) {
        for (Map.Entry<Property<?>, Comparable<?>> entry :  from.getValues().entrySet()) {
            to = to.trySetValue((Property<T>) entry.getKey(), (T) entry.getValue());
        }
        return to;
    }
}
