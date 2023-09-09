package jp.soyr.datagen;

import java.util.concurrent.CompletableFuture;
import jp.soyr.JpryosMod;
import jp.soyr.datagen.provider.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JpryosMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    PackOutput packOutput = generator.getPackOutput();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    generator.addProvider(event.includeServer(), new JpryosRecipeProvider(packOutput));
    generator.addProvider(event.includeServer(), JpryosLootTablesProvider.create(packOutput));
    generator.addProvider(
        event.includeServer(),
        new JpryosBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));

    generator.addProvider(
        event.includeClient(), new JpryosItemModelProvider(packOutput, existingFileHelper));
    generator.addProvider(
        event.includeClient(), new JpryosBlockStateProvider(packOutput, existingFileHelper));
  }
}
