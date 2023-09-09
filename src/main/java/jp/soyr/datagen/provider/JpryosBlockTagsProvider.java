package jp.soyr.datagen.provider;

import jp.soyr.JpryosMod;
import jp.soyr.blocks.JpryosBlocks;
import jp.soyr.util.JpryosTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.minecraftforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class JpryosBlockTagsProvider extends BlockTagsProvider {
    public JpryosBlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, JpryosMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(JpryosTags.Blocks.METAL_DETECTOR_VALUABLE)
                .add(JpryosBlocks.ALEXANDRITE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        JpryosBlocks.ALEXANDRITE_BLOCK.get(),
                        JpryosBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                        JpryosBlocks.ALEXANDRITE_ORE.get(),
                        JpryosBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        JpryosBlocks.END_STONE_ALEXANDRITE_ORE.get(),
                        JpryosBlocks.NETHER_ALEXANDRITE_ORE.get(),
                        JpryosBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        JpryosBlocks.ALEXANDRITE_BLOCK.get(),
                        JpryosBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                        JpryosBlocks.ALEXANDRITE_ORE.get(),
                        JpryosBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        JpryosBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        JpryosBlocks.END_STONE_ALEXANDRITE_ORE.get(),
                        JpryosBlocks.NETHER_ALEXANDRITE_ORE.get());
    }

    @Override
    public @NotNull String getName() {
        return "Block Tags";
    }

}
