package com.sighs.oneenoughblock.mixin;

import net.minecraftforge.fml.loading.FMLLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean whenChunkSerializerMixin = mixinClassName.equals("com.sighs.oneenoughblock.mixin.ChunkSerializerMixin");
        if (whenChunkSerializerMixin && isOldMC()) {
            return false;
        }
        return true;
    }

    public static boolean isOldMC() {
        String ver = FMLLoader.versionInfo().mcVersion();
        return ver.startsWith("1.19") || ver.startsWith("1.18");
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    // 其他方法留空或默认实现
    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
