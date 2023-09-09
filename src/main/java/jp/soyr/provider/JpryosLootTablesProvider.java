package jp.soyr.provider;

import jp.soyr.datagen.loot.JpryosLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class JpryosLootTablesProvider {
    public static LootTableProvider create(PackOutput packOutput) {
        return new LootTableProvider(packOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(
                JpryosLootTables::new, LootContextParamSets.BLOCK)));
    }
}
