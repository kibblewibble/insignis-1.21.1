package net.verdantmods.insignis.models;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.ModItems;
import net.verdantmods.insignis.item.custom.BannerOfRushing;
import net.verdantmods.insignis.item.custom.EmblemOfDefense;
import net.verdantmods.insignis.item.custom.EmblemOfOffense;
import net.verdantmods.insignis.item.custom.EmblemOfSupport;

import static net.verdantmods.insignis.entity.equipment.HasEquipped.isWearingTrinket;

public class HaloProvider {
    public static Identifier getHalo(AbstractClientPlayerEntity entity){
        if(isWearingTrinket(entity, ModItems.EMBLEM_OF_OFFENSE)) { return EmblemOfOffense.getHalo(); }
        else if(isWearingTrinket(entity, ModItems.EMBLEM_OF_DEFENSE)) { return EmblemOfDefense.getHalo(); }
        else if(isWearingTrinket(entity, ModItems.EMBLEM_OF_SUPPORT)) { return EmblemOfSupport.getHalo(); }

        else return Identifier.of(Insignis.MOD_ID, "textures/entity/blank.png");
    }

    public static Identifier getCrown(AbstractClientPlayerEntity entity){
        // OFFENSE CROWNS \\
        if(isWearingTrinket(entity, ModItems.CROWN_OF_DUELING)) { return EmblemOfOffense.getHalo(); }
        // DEFENSE CROWNS \\
        // SUPPORT CROWNS \\
        else if(isWearingTrinket(entity, ModItems.CROWN_OF_STEALTH)) { return EmblemOfSupport.getHalo(); }

        else return Identifier.of(Insignis.MOD_ID, "textures/entity/blank.png");
    }

    public static int getColor(AbstractClientPlayerEntity entity){
        if(isWearingTrinket(entity, ModItems.BANNER_OF_RUSHING)) { return BannerOfRushing.getColor(); }

        else return ColorHelper.Argb.getArgb(255, 255,255,255);
    }
}
