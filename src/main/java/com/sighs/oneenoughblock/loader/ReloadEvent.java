package com.sighs.oneenoughblock.loader;

import com.sighs.oneenoughblock.Oneenoughblock;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Oneenoughblock.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ReloadEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCommand(CommandEvent event) {
        String rawCommand = event.getParseResults().getReader().getString();
        if (rawCommand.equals("reload")) EntryCache.loadAllRule();
    }
}
