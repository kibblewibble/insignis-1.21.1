package net.verdantmods.insignis.item.custom;

import com.mojang.brigadier.Message;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.verdantmods.insignis.InsignisClient;
import net.verdantmods.insignis.effect.ModEffects;

import java.util.List;

public class CrownOfStealth extends AbstractCrown{
    public CrownOfStealth(Settings settings) {
        super(settings);
    }

    @Override
    public void activeAbility(PlayerEntity player, ItemStack stack) {
        int duration = 30*20;
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, duration, 0, false, false, true));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, duration, 0, false, false, false));
        player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_INVISIBILITY, duration, 0, false, false, false));
    }

    @Override
    public void appendTooltip(ItemStack item, TooltipContext context, List<Text> tooltip, TooltipType options){
        Text text = InsignisClient.activeAbilityKeybind.getBoundKeyLocalizedText();
        tooltip.add(Text.translatable("tooltip.insignis.active_ability", text).formatted(Formatting.GRAY));
    }
}
