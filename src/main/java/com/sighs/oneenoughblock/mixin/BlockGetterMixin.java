package com.sighs.oneenoughblock.mixin;

import com.sighs.oneenoughblock.Oneenoughblock;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.PalettedContainer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Optional;

@Mixin(LevelChunkSection.class)
public abstract class BlockGetterMixin {
    @Shadow
    @Final
    private PalettedContainer<BlockState> states;

    @Shadow
    public abstract BlockState setBlockState(int x, int y, int z, BlockState state, boolean useLocks);

    @Inject(method = "setBlockState(IIILnet/minecraft/world/level/block/state/BlockState;Z)Lnet/minecraft/world/level/block/state/BlockState;", at = @At("HEAD"), cancellable = true)
    public void setBlockState(int x, int y, int z, BlockState state, boolean useLocks, CallbackInfoReturnable<BlockState> cir) {
        for (Map.Entry<TagKey<Block>, Block> entry : Oneenoughblock.TagWrapper.entrySet()) {
            if (state.is(entry.getKey()) && !state.is(entry.getValue())) {
                cir.setReturnValue(setBlockState(x, y, z, entry.getValue().defaultBlockState(), useLocks));
            }
        }
        Optional.ofNullable(Oneenoughblock.wrappers.get(state.getBlock()))
                .filter(wrapper -> !state.is(wrapper))
                .ifPresent(wrapper -> {
                    cir.setReturnValue(setBlockState(x, y, z, wrapper.defaultBlockState(), useLocks));
                });
    }
    /*

    @Inject(method = "getBlockState", at = @At("HEAD"))
    public void getBlockState(int x, int y, int z, CallbackInfoReturnable<BlockState> cir) {
        Optional.ofNullable(Oneenoughblock.wrappers.get(this.states.get(x, y, z).getBlock()))
                .ifPresent(wrapper -> {
                    setBlockState(x,y,z,wrapper.defaultBlockState(),false);
                });
    }*/
}
