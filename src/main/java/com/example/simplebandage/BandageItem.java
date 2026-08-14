package com.example.simplebandage;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;

public class BandageItem extends Item {

    public BandageItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.NONE;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 70;
    }

    @Override
    public InteractionResult use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }

    @Override
    public ItemStack finishUsingItem(
            ItemStack stack,
            Level level,
            LivingEntity entity
    ) {
        if (!level.isClientSide()) {
            entity.heal(6.0F);

            if (entity instanceof Player player
                    && !player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }

        return stack;
    }
}
