package net.verdantmods.insignis.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class CrownOfStealth extends AbstractCrown{
    public CrownOfStealth(Settings settings) {
        super(settings);
    }

    @Override
    public void activeAbility(PlayerEntity player, ItemStack stack) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100, 0, false, false));
    }
}
