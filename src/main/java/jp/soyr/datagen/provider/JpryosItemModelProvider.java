package jp.soyr.datagen.provider;

import jp.soyr.JpryosMod;
import jp.soyr.items.JpryosItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(JpryosMod.MODID, "item/" + item.getId().getPath()));
    }
}
