package jp.soyr.datagen.provider;

import jp.soyr.JpryosMod;
import jp.soyr.blocks.JpryosBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class JpryosBlockStateProvider extends BlockStateProvider {

  public JpryosBlockStateProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
    super(packOutput, JpryosMod.MODID, existingFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    blockWithItem(JpryosBlocks.ALEXANDRITE_BLOCK);
    blockWithItem(JpryosBlocks.RAW_ALEXANDRITE_BLOCK);

    blockWithItem(JpryosBlocks.ALEXANDRITE_ORE);
    blockWithItem(JpryosBlocks.DEEPSLATE_ALEXANDRITE_ORE);
    blockWithItem(JpryosBlocks.END_STONE_ALEXANDRITE_ORE);
    blockWithItem(JpryosBlocks.NETHER_ALEXANDRITE_ORE);

    blockWithItem(JpryosBlocks.SOUND_BLOCK);
  }

  private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
  }
}
