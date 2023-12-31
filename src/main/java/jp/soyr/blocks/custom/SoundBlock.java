package jp.soyr.blocks.custom;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SoundBlock extends Block {

  public SoundBlock(Properties props) {
    super(props);
  }

  @Override
  public InteractionResult use(
      @NotNull BlockState pState,
      Level pLevel,
      @NotNull BlockPos pPos,
      @NotNull Player pPlayer,
      InteractionHand pHand,
      BlockHitResult pHit) {

    if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
      if (pPlayer.isCrouching()) {
        pLevel.playSound(
            null, pPos, SoundEvents.NOTE_BLOCK_BANJO.get(), SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
      } else {
        pLevel.playSound(
            null, pPos, SoundEvents.NOTE_BLOCK_COW_BELL.get(), SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.CONSUME;
      }
    }
    return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
  }

  @Override
  public void stepOn(
      Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Entity pEntity) {
    pLevel.playSound(pEntity, pPos, SoundEvents.NOTE_BLOCK_BIT.get(), SoundSource.BLOCKS, 1f, 1f);
    super.stepOn(pLevel, pPos, pState, pEntity);
  }

  @Override
  public void appendHoverText(
      @NotNull ItemStack pStack,
      @Nullable BlockGetter pLevel,
      @NotNull List<Component> pTooltip,
      TooltipFlag pFlag) {
    pTooltip.add(Component.translatable("tooltip.jpryosmod.sound_block"));
    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
  }
}
