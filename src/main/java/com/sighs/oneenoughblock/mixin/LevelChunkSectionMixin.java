package com.sighs.oneenoughblock.mixin;

import com.sighs.oneenoughblock.Oneenoughblock;
import com.sighs.oneenoughblock.utils.CoreUtils;
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
public abstract class LevelChunkSectionMixin {
    @Shadow
    @Final
    private PalettedContainer<BlockState> states;

    @Shadow
    public abstract BlockState setBlockState(int x, int y, int z, BlockState state, boolean useLocks);

    @Inject(method = "setBlockState(IIILnet/minecraft/world/level/block/state/BlockState;Z)Lnet/minecraft/world/level/block/state/BlockState;", at = @At("HEAD"), cancellable = true)
    public void setBlockState(int x, int y, int z, BlockState state, boolean useLocks, CallbackInfoReturnable<BlockState> cir) {
        CoreUtils.handleBlockState(state, result -> {
            cir.setReturnValue(setBlockState(x, y, z, result, useLocks));
        });
    }

//    @Inject(method = "getBlockState", at = @At("HEAD"))
//    public void getBlockState(int x, int y, int z, CallbackInfoReturnable<BlockState> cir) {
//        CoreUtils.handleBlockState(this.states.get(x, y, z), result -> {
//            setBlockState(x, y, z, result, false);
//        });
//    }
}
