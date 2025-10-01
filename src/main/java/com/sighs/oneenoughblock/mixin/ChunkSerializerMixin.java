package com.sighs.oneenoughblock.mixin;

import com.sighs.oneenoughblock.Config;
import com.sighs.oneenoughblock.api.IPalettedContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.*;
import net.minecraft.world.level.chunk.storage.ChunkSerializer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = ChunkSerializer.class)
public class ChunkSerializerMixin {
    @ModifyArg(method = "read", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/LevelChunkSection;<init>(Lnet/minecraft/world/level/chunk/PalettedContainer;Lnet/minecraft/world/level/chunk/PalettedContainerRO;)V", ordinal = 0))
    private static PalettedContainer<BlockState> qqq(PalettedContainer<BlockState> container) {
        if (Config.REPLACE_EXISTED_BLOCK.get()) {
            ((IPalettedContainer) container).handleReplace();
        }
        return container;
    }
}
