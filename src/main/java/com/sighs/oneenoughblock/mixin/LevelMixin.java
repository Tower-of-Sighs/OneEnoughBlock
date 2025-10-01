package com.sighs.oneenoughblock.mixin;

import com.sighs.oneenoughblock.utils.CoreUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {
    @Shadow public abstract boolean setBlock(BlockPos p_46605_, BlockState p_46606_, int p_46607_, int p_46608_);

    @Inject(method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z",at = @At("HEAD"), cancellable = true)
    private void onSetBlock(BlockPos pos, BlockState state, int p_46607_, int p_46608_, CallbackInfoReturnable<Boolean> cir) {
        CoreUtils.handleBlockState(state, result -> {
            cir.setReturnValue(setBlock(pos, result, p_46607_, p_46608_));
        });
    }
}
