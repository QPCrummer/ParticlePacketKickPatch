package org.bacon.noviaversionkick.network;

import net.minecraft.network.ClientConnection;

public interface PacketConnectionAttachment {
    void noviaversionkick$setConnection(ClientConnection connection);

    ClientConnection noviaversionkick$getConnection();
}
