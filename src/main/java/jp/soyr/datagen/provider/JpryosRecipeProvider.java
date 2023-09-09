package jp.soyr.datagen.provider;

import java.util.List;
import java.util.function.Consumer;
import jp.soyr.JpryosMod;
import jp.soyr.blocks.JpryosBlocks;
import jp.soyr.items.JpryosItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

public class JpryosRecipeProvider extends RecipeProvider implements IConditionBuilder {
  private static final List<ItemLike> ALEXANDRITE_SMELTABLES =
      List.of(
          JpryosItems.RAW_ALEXANDRITE.get(),
          JpryosBlocks.ALEXANDRITE_ORE.get(),
          JpryosBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
          JpryosBlocks.NETHER_ALEXANDRITE_ORE.get(),
          JpryosBlocks.END_STONE_ALEXANDRITE_ORE.get());

  public JpryosRecipeProvider(PackOutput packOutput) {
    super(packOutput);
  }

  @Override
  protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JpryosBlocks.ALEXANDRITE_BLOCK.get())
        .pattern("AAA")
        .pattern("AAA")
        .pattern("AAA")
        .define('A', JpryosItems.ALEXANDRITE.get())
        .unlockedBy(
            "has_alexandrite",
            inventoryTrigger(
                ItemPredicate.Builder.item().of(JpryosItems.ALEXANDRITE.get()).build()))
        .save(pWriter);

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JpryosItems.ALEXANDRITE.get(), 9)
        .requires(JpryosBlocks.ALEXANDRITE_BLOCK.get())
        .unlockedBy(
            "has_alexandrite_block",
            inventoryTrigger(
                ItemPredicate.Builder.item().of(JpryosBlocks.ALEXANDRITE_BLOCK.get()).build()))
        .save(pWriter);

    nineBlockStorageRecipes(
        pWriter,
        RecipeCategory.MISC,
        JpryosItems.RAW_ALEXANDRITE.get(),
        RecipeCategory.MISC,
        JpryosBlocks.RAW_ALEXANDRITE_BLOCK.get(),
        "jpryosmod:raw_alexandrite",
        "alexandrite",
        "jpryosmod:raw_alexandrite_block",
        "alexandrite");

    oreSmelting(
        pWriter,
        ALEXANDRITE_SMELTABLES,
        RecipeCategory.MISC,
        JpryosItems.ALEXANDRITE.get(),
        .25f,
        200,
        "alexandrite");

    oreBlasting(
        pWriter,
        ALEXANDRITE_SMELTABLES,
        RecipeCategory.MISC,
        JpryosItems.ALEXANDRITE.get(),
        .25f,
        100,
        "alexandrite");
  }

  protected static void oreSmelting(
      Consumer<FinishedRecipe> pFinishedRecipeConsumer,
      List<ItemLike> pIngredients,
      RecipeCategory pCategory,
      ItemLike pResult,
      float pExperience,
      int pCooking,
      String pGroup) {
    oreCooking(
        pFinishedRecipeConsumer,
        RecipeSerializer.SMELTING_RECIPE,
        pIngredients,
        pCategory,
        pResult,
        pExperience,
        pCooking,
        pGroup,
        "_from_smelting");
  }

  protected static void oreBlasting(
      Consumer<FinishedRecipe> pFinishedRecipeConsumer,
      List<ItemLike> pIngredients,
      RecipeCategory pCategory,
      ItemLike pResult,
      float pExperience,
      int pCooking,
      String pGroup) {
    oreCooking(
        pFinishedRecipeConsumer,
        RecipeSerializer.BLASTING_RECIPE,
        pIngredients,
        pCategory,
        pResult,
        pExperience,
        pCooking,
        pGroup,
        "_from_blasting");
  }

  protected static void oreCooking(
      Consumer<FinishedRecipe> pFinishedRecipeConsumer,
      RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
      List<ItemLike> pIngredients,
      RecipeCategory pCategory,
      ItemLike pResult,
      float pExperience,
      int pCooking,
      String pGroup,
      String pRecipeName) {
    for (ItemLike itemLike : pIngredients) {
      SimpleCookingRecipeBuilder.generic(
              Ingredient.of(itemLike),
              pCategory,
              pResult,
              pExperience,
              pCooking,
              pCookingSerializer)
          .group(pGroup)
          .unlockedBy(getHasName(itemLike), has(itemLike))
          .save(
              pFinishedRecipeConsumer,
              JpryosMod.MODID
                  + ":"
                  + getItemName(pResult)
                  + pRecipeName
                  + "_"
                  + getItemName(itemLike));
    }
  }
}
