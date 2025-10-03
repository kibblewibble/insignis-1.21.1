package net.verdantmods.insignis.item.custom;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.InsignisClient;
import net.verdantmods.insignis.effect.ModEffects;
import net.verdantmods.insignis.item.HaloProvider;

import java.util.List;

public class CrownOfStealth extends AbstractCrown implements HaloProvider {
    public CrownOfStealth(Settings settings) {
        super(settings);
    }

    @Override
    public void activeAbility(PlayerEntity player, ItemStack stack) {
        int duration = 20*20;
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, duration, 0, false, false, true));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, duration, 2, false, false, false));
        player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_INVISIBILITY, duration, 0, false, false, false));
    }

    @Override
    public void appendTooltip(ItemStack item, TooltipContext context, List<Text> tooltip, TooltipType options){
        Text text = InsignisClient.activeAbilityKeybind.getBoundKeyLocalizedText();
        tooltip.add(Text.translatable("tooltip.insignis.active_ability", text).formatted(Formatting.GRAY));
    }

    public Identifier getCrownTexture(AbstractClientPlayerEntity entity){
        return Identifier.of(Insignis.MOD_ID, "textures/entity/crown/crown_of_stealth.png");
    }
}
