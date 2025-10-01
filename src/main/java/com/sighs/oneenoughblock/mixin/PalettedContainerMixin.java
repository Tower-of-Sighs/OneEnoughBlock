package com.sighs.oneenoughblock.mixin;

import com.sighs.oneenoughblock.Oneenoughblock;
import com.sighs.oneenoughblock.api.IPalettedContainer;
import com.sighs.oneenoughblock.utils.CoreUtils;
import net.minecraft.util.BitStorage;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.Palette;
import net.minecraft.world.level.chunk.PalettedContainer;
import org.spongepowered.asm.mixin.*;

import java.util.HashMap;
import java.util.Map;

@Mixin(value = PalettedContainer.class)
@Implements(@Interface(iface = IPalettedContainer.class, prefix = "lazy$"))
public class PalettedContainerMixin implements IPalettedContainer {
    @Shadow private volatile PalettedContainer.Data<?> data;

    public void handleReplace() {
        BitStorage storage = this.data.storage();
        Palette<BlockState> palette = (Palette<BlockState>) this.data.palette();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < palette.getSize(); i++) {
            int finalI = i;
            CoreUtils.handleBlockState(palette.valueFor(i), result -> {
                map.put(finalI, palette.idFor(result));
            });
        }

        for (int i = 0; i < storage.getSize(); i++) {
            int id = storage.get(i);
            int r = map.getOrDefault(id, -1);
            if (r != -1) storage.set(i, r);
        }
    }
}
