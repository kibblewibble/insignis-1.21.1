package net.verdantmods.insignis.packet;

import dev.emi.trinkets.api.TrinketsApi;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.custom.AbstractCrown;

public class ActiveAbilityKeybind implements ModPackets.ReceiverPacket<ServerPlayNetworking.Context>{
    public static final ActiveAbilityKeybind INSTANCE = new ActiveAbilityKeybind();
    public static final CustomPayload.Id<ActiveAbilityKeybind> ID = new CustomPayload.Id<>(Identifier.of(Insignis.MOD_ID, "active_ability"));
    public static final PacketCodec<ByteBuf, ActiveAbilityKeybind> PACKET_CODEC = PacketCodec.unit(ActiveAbilityKeybind.INSTANCE);


    @Override
    public void receive(ServerPlayNetworking.Context context) {
        context.player().getComponent(TrinketsApi.TRINKET_COMPONENT).getEquipped(stack -> stack.getItem() instanceof AbstractCrown).forEach(slotReferenceItemStackPair -> {
            ItemStack stack = slotReferenceItemStackPair.getRight();
            ((AbstractCrown)stack.getItem()).ability(context.player(), stack);
        });
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
