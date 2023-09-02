package jp.soyr.items;

import jp.soyr.JpryosMod;
import jp.soyr.blocks.JpryosBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JpryosCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JpryosMod.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(JpryosItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creativetab.tab"))
                    .displayItems((displayParams, out) -> {
                        out.accept(JpryosItems.ALEXANDRITE.get());
                        out.accept(JpryosItems.RAW_ALEXANDRITE.get());
                        out.accept(JpryosBlocks.ALEXANDRITE_BLOCK.get());
                        out.accept(JpryosBlocks.RAW_ALEXANDRITE_BLOCK.get());

                    }).build());

    public static void register(IEventBus iEventBus) {
        CREATIVE_MODE_TABS.register(iEventBus);
    }
}