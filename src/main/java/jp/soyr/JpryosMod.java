package jp.soyr;

import com.mojang.logging.LogUtils;
import jp.soyr.blocks.JpryosBlocks;
import jp.soyr.items.JpryosCreativeTabs;
import jp.soyr.items.JpryosItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JpryosMod.MODID)
public class JpryosMod {

  public static final String MODID = "jpryosmod";

  public static final Logger LOGGER = LogUtils.getLogger();

  public JpryosMod() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    modEventBus.addListener(this::commonSetup);

    JpryosItems.register(modEventBus);
    JpryosBlocks.register(modEventBus);
    JpryosCreativeTabs.register(modEventBus);

    MinecraftForge.EVENT_BUS.register(this);

    modEventBus.addListener(this::addCreative);

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {}

  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
      event.accept(JpryosItems.ALEXANDRITE);
      event.accept(JpryosItems.RAW_ALEXANDRITE);
    }
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {}

  @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {}
  }
}
