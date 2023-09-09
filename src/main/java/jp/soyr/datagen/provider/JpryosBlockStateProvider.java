package jp.soyr.datagen.provider;

import java.util.Objects;
import jp.soyr.JpryosMod;
import jp.soyr.blocks.JpryosBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

    stairsBlock(
        (StairBlock) JpryosBlocks.ALEXANDRITE_STAIRS.get(),
        blockTexture(JpryosBlocks.ALEXANDRITE_BLOCK.get()));
    slabBlock(
        ((SlabBlock) JpryosBlocks.ALEXANDRITE_SLAB.get()),
        blockTexture(JpryosBlocks.ALEXANDRITE_BLOCK.get()),
        blockTexture(JpryosBlocks.ALEXANDRITE_BLOCK.get()));

    blockItem(JpryosBlocks.ALEXANDRITE_STAIRS);
    blockItem(JpryosBlocks.ALEXANDRITE_SLAB);
  }

  private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
  }

  private void blockItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockItem(
        blockRegistryObject.get(),
        new ModelFile.UncheckedModelFile(
            "jpryosmod:block/"
                + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()))
                    .getPath()));
  }
}
