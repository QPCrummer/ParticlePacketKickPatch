package org.bacon.noviaversionkick.mixin;

import io.netty.channel.ChannelFutureListener;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import org.bacon.noviaversionkick.network.PacketConnectionAttachment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
    @Inject(method = "sendInternal(Lnet/minecraft/network/packet/Packet;Lio/netty/channel/ChannelFutureListener;Z)V", at = @At("HEAD"))
    private void noviaversionkick$tagConnection(Packet<?> packet, ChannelFutureListener listener, boolean flush, CallbackInfo ci) {
        if (packet instanceof PacketConnectionAttachment attachment) {
            attachment.noviaversionkick$setConnection((ClientConnection) (Object) this);
        }
    }

    @Inject(method = "sendInternal(Lnet/minecraft/network/packet/Packet;Lio/netty/channel/ChannelFutureListener;Z)V", at = @At("TAIL"))
    private void noviaversionkick$clearConnection(Packet<?> packet, ChannelFutureListener listener, boolean flush, CallbackInfo ci) {
        if (packet instanceof PacketConnectionAttachment attachment) {
            attachment.noviaversionkick$setConnection(null);
        }
    }
}
