package jp.soyr.items.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            var foundBlock = false;

            for (int i = 0; i < positionClicked.getY() + 64; i++) {
                BlockState blockState = context.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), Objects.requireNonNull(player), blockState.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                outputNoValuableFound(Objects.requireNonNull(player));
            }
        }
        context.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(context.getPlayer()), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.jpryosmod.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal(
                "Valuable Found: "
                + I18n.get(block.getDescriptionId())
                + " at ("
                + below.getX()
                + ", "
                + below.getY()
                + ", "
                + below.getZ()
                + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE) || blockState.is(Blocks.DIAMOND_BLOCK) || blockState.is(Blocks.DEEPSLATE_DIAMOND_ORE);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.jpryosmod.metal_detector.tooltip.shift"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.jpryosmod.metal_detector.tooltip"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
