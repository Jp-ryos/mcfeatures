package jp.soyr.datagen.provider;

import jp.soyr.blocks.JpryosBlocks;
import jp.soyr.items.JpryosItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class JpryosLootTablesSubProvider extends BlockLootSubProvider {
    public JpryosLootTablesSubProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(JpryosBlocks.ALEXANDRITE_BLOCK.get());
        this.dropSelf(JpryosBlocks.RAW_ALEXANDRITE_BLOCK.get());
        this.dropSelf(JpryosBlocks.SOUND_BLOCK.get());

        this.add(JpryosBlocks.ALEXANDRITE_ORE.get(),
                block -> createOreDrop(JpryosBlocks.ALEXANDRITE_ORE.get(), JpryosItems.RAW_ALEXANDRITE.get()));
        this.add(JpryosBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                block -> createOreDrop(JpryosBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), JpryosItems.RAW_ALEXANDRITE.get()));
        this.add(JpryosBlocks.END_STONE_ALEXANDRITE_ORE.get(),
                block -> createOreDrop(JpryosBlocks.END_STONE_ALEXANDRITE_ORE.get(), JpryosItems.RAW_ALEXANDRITE.get()));
        this.add(JpryosBlocks.NETHER_ALEXANDRITE_ORE.get(),
                block -> createOreDrop(JpryosBlocks.NETHER_ALEXANDRITE_ORE.get(), JpryosItems.RAW_ALEXANDRITE.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return JpryosBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
