package com.sighs.oneenoughblock.mixin;

import com.sighs.oneenoughblock.Oneenoughblock;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(Level.class)
public abstract class LevelMixin {
    @Shadow public abstract boolean setBlock(BlockPos p_46605_, BlockState p_46606_, int p_46607_, int p_46608_);

    @Inject(method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z",at = @At("HEAD"), cancellable = true)
    private void onSetBlock(BlockPos pos, BlockState state, int p_46607_, int p_46608_, CallbackInfoReturnable<Boolean> cir) {
        for (Map.Entry<TagKey<Block>, Block> entry : Oneenoughblock.TagWrapper.entrySet()) {
            if (state.is(entry.getKey()) && !state.is(entry.getValue())) {
                cir.setReturnValue(setBlock(pos, entry.getValue().defaultBlockState(), p_46607_,p_46608_));
            }
        }

        var b = Oneenoughblock.wrappers.get(state.getBlock());
        if (b != null && !state.is(b)) {
            cir.setReturnValue(setBlock(pos, b.defaultBlockState(), p_46607_,p_46608_));

        }
    }
}
