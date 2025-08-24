package net.verdantmods.insignis.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.verdantmods.insignis.effect.ModEffects;

public class CrownOfStealth extends AbstractCrown{
    public CrownOfStealth(Settings settings) {
        super(settings);
    }

    @Override
    public void activeAbility(PlayerEntity player, ItemStack stack) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 30*20, 0, false, false));
        player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_INVISIBILITY, 30*20, 0, false, false));
    }
}
