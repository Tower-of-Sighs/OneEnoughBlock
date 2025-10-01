package com.sighs.oneenoughblock.loader;

import com.sighs.oneenoughblock.Oneenoughblock;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.event.CommandEvent;

@EventBusSubscriber(modid = Oneenoughblock.MODID)
public class LoadEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCommand(CommandEvent event) {
        String rawCommand = event.getParseResults().getReader().getString();
        if (rawCommand.equals("reload")) EntryCache.loadAllRule();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onConfigLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getModId().equals(Oneenoughblock.MODID)) EntryCache.loadAllRule();
    }
}
