package me.unteachable.hiveminezSeason2.npc;

import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class NPCManager {

    private final Map<String, ServerPlayer> npcs;

    public void removeNPC(Player p, ServerPlayer npc) {
        CraftPlayer craftPlayer = (CraftPlayer) p;
        ServerPlayer serverPlayer = craftPlayer.getHandle();
        ServerGamePacketListenerImpl listener = serverPlayer.connection;

        listener.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));
        listener.send(new ClientboundRemoveEntitiesPacket(npc.getId()));
    }

    public NPCManager() {
        this.npcs = new HashMap<>();
    }

    public Map<String, ServerPlayer> getNPCS() {
        return npcs;
    }

    public int getNpcID(ServerPlayer npc) {
        return (npc == null) ? 0 : npc.getId();
    }
}
