package jp.soyr.datagen.provider;

import java.util.concurrent.CompletableFuture;
import jp.soyr.JpryosMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class JpryosItemTagsProvider extends ItemTagsProvider {
  public JpryosItemTagsProvider(
      PackOutput packOutput,
      CompletableFuture<HolderLookup.Provider> future,
      CompletableFuture<TagLookup<Block>> completableFuture,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(packOutput, future, completableFuture, JpryosMod.MODID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {}

  @Override
  public String getName() {
    return "Item Tags";
  }
}
