package com.sighs.oneenoughblock;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
//    public static final ForgeConfigSpec.ConfigValue<List<String>> WRAPPERS;
    public static final ModConfigSpec.ConfigValue<Boolean> REPLACE_EXISTED_BLOCK;

    static final ModConfigSpec SPEC ;
    static {
//        WRAPPERS = BUILDER
//                .comment("配置方块替换逻辑格式为<方块id/tag> + > + <方块id>")
//                .comment("例如:")
//                .comment("\"minecraft:redstone_block>minecraft:acacia_log\"","\"#minecraft:logs>minecraft:redstone_block\"")
//                .define("wrapper", new ArrayList<>(List.of()));

        REPLACE_EXISTED_BLOCK = BUILDER
                .comment("已存在、已放置的方块是否受影响")
                .define("replaceExistedBlock", false);
        SPEC = BUILDER.build();
    }
}
