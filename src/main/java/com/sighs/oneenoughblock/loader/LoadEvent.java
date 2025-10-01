package com.sighs.oneenoughblock.loader;

import com.sighs.oneenoughblock.Oneenoughblock;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Oneenoughblock.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LoadEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onConfigLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getModId().equals(Oneenoughblock.MODID)) EntryCache.loadAllRule();
    }
}
