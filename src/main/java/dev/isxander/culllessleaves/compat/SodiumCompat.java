package dev.isxander.culllessleaves.compat;

import dev.isxander.culllessleaves.CullLessLeaves;
import dev.isxander.culllessleaves.config.CullLessLeavesConfig;
import me.jellysquid.mods.sodium.client.SodiumClientMod;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;

public class SodiumCompat {
    private static final OptionStorage<CullLessLeavesConfig> OPTION_STORAGE = new OptionStorage<CullLessLeavesConfig>() {
        @Override
        public CullLessLeavesConfig getData() {
            return CullLessLeaves.getConfig();
        }

        @Override
        public void save() {
            AutoConfig.getConfigHolder(CullLessLeavesConfig.class).save();
        }
    };

    public static boolean isFancyLeaves() {
        return SodiumClientMod.options().quality.leavesQuality.isFancy(MinecraftClient.getInstance().options.getGraphicsMode().getValue());
    }

    public static OptionStorage<CullLessLeavesConfig> getOptionStorage() {
        return OPTION_STORAGE;
    }
}
