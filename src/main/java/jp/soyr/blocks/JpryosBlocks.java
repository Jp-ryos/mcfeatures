package jp.soyr.blocks;

import java.util.function.Supplier;
import jp.soyr.JpryosMod;
import jp.soyr.blocks.custom.SoundBlock;
import jp.soyr.items.JpryosItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JpryosBlocks {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, JpryosMod.MODID);

  public static final RegistryObject<Block> ALEXANDRITE_BLOCK =
      registerBlock(
          "alexandrite_block",
          () ->
              new Block(
                  BlockBehaviour.Properties.of()
                      .mapColor(MapColor.METAL)
                      .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                      .requiresCorrectToolForDrops()
                      .strength(5.0f, 6.0f)
                      .sound(SoundType.METAL)));

  public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK =
      registerBlock(
          "raw_alexandrite_block",
          () ->
              new Block(
                  BlockBehaviour.Properties.of()
                      .mapColor(MapColor.METAL)
                      .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                      .requiresCorrectToolForDrops()
                      .strength(5.0f, 6.0f)
                      .sound(SoundType.METAL)));

  public static final RegistryObject<Block> ALEXANDRITE_ORE =
      registerBlock(
          "alexandrite_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.STONE)
                      .strength(5f)
                      .requiresCorrectToolForDrops(),
                  UniformInt.of(2, 5)));

  public static final RegistryObject<Block> NETHER_ALEXANDRITE_ORE =
      registerBlock(
          "nether_alexandrite_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                      .strength(5f)
                      .requiresCorrectToolForDrops(),
                  UniformInt.of(3, 7)));

  public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE =
      registerBlock(
          "deepslate_alexandrite_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                      .strength(5f)
                      .requiresCorrectToolForDrops(),
                  UniformInt.of(5, 8)));

  public static final RegistryObject<Block> END_STONE_ALEXANDRITE_ORE =
      registerBlock(
          "end_stone_alexandrite_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.END_STONE)
                      .strength(5f)
                      .requiresCorrectToolForDrops(),
                  UniformInt.of(3, 6)));

  public static final RegistryObject<Block> ALEXANDRITE_STAIRS =
      registerBlock(
          "alexandrite_stairs",
          () ->
              new StairBlock(
                  () -> JpryosBlocks.ALEXANDRITE_BLOCK.get().defaultBlockState(),
                  BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL)));

  public static final RegistryObject<Block> ALEXANDRITE_SLAB =
      registerBlock(
          "alexandrite_slab",
          () ->
              new SlabBlock(
                  BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL)));

  public static final RegistryObject<Block> ALEXANDRITE_PRESSURE_PLATE =
      registerBlock(
          "alexandrite_pressure_plate",
          () ->
              new PressurePlateBlock(
                  PressurePlateBlock.Sensitivity.EVERYTHING,
                  BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL),
                  BlockSetType.IRON));

  public static final RegistryObject<Block> ALEXANDRITE_BUTTON =
      registerBlock(
          "alexandrite_button",
          () ->
              new ButtonBlock(
                  BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL),
                  BlockSetType.IRON,
                  10,
                  true));

  public static final RegistryObject<Block> SOUND_BLOCK =
      registerBlock(
          "sound_block", () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(
      String name, RegistryObject<T> block) {
    return JpryosItems.ITEMS.register(
        name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus iEventBus) {
    BLOCKS.register(iEventBus);
  }
}
