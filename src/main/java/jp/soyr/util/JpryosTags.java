package jp.soyr.util;

import jp.soyr.JpryosMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class JpryosTags {
  public static class Items {

    private static TagKey<Item> tag(String name) {
      return ItemTags.create(new ResourceLocation(JpryosMod.MODID, name));
    }

    private static TagKey<Item> forgeTag(String name) {
      return ItemTags.create(new ResourceLocation("forge", name));
    }
  }

  public static class Blocks {
    public static final TagKey<Block> METAL_DETECTOR_VALUABLE = tag("metal_detector_valuable");
    public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
    public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");

    private static TagKey<Block> tag(String name) {
      return BlockTags.create(new ResourceLocation(JpryosMod.MODID, name));
    }

    private static TagKey<Block> forgeTag(String name) {
      return BlockTags.create(new ResourceLocation("forge", name));
    }
  }
}
