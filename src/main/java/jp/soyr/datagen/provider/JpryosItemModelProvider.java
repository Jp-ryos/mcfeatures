package jp.soyr.datagen.provider;

import jp.soyr.JpryosMod;
import jp.soyr.blocks.JpryosBlocks;
import jp.soyr.items.JpryosItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JpryosItemModelProvider extends ItemModelProvider {
  public JpryosItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
    super(packOutput, JpryosMod.MODID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    simpleItem(JpryosItems.ALEXANDRITE);
    simpleItem(JpryosItems.RAW_ALEXANDRITE);

    simpleItem(JpryosItems.KOHLRABI);
    simpleItem(JpryosItems.METAL_DETECTOR);
    simpleItem(JpryosItems.PEAT_BRICK);

    buttonItem(JpryosBlocks.ALEXANDRITE_BUTTON, JpryosBlocks.ALEXANDRITE_BLOCK);
    fenceItem(JpryosBlocks.ALEXANDRITE_FENCE, JpryosBlocks.ALEXANDRITE_BLOCK);
    wallItem(JpryosBlocks.ALEXANDRITE_WALL, JpryosBlocks.ALEXANDRITE_BLOCK);

    simpleBlockItem(JpryosBlocks.ALEXANDRITE_DOOR);
  }

  public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
    this.withExistingParent(
            ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
        .texture(
            "texture",
            new ResourceLocation(
                JpryosMod.MODID,
                "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
  }

  public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
    this.withExistingParent(
            ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
        .texture(
            "wall",
            new ResourceLocation(
                JpryosMod.MODID,
                "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
  }

  public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
    this.withExistingParent(
            ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
        .texture(
            "texture",
            new ResourceLocation(
                JpryosMod.MODID,
                "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
  }

  private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
        .texture("layer0", new ResourceLocation(JpryosMod.MODID, "item/" + item.getId().getPath()));
  }

  private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
    return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0",
      new ResourceLocation(JpryosMod.MODID, "item/" + item.getId().getPath()));
  }
}
