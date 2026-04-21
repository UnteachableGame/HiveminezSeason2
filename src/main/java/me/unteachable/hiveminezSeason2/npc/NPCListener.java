package me.unteachable.hiveminezSeason2.npc;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class NPCListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        for (ServerPlayer npc : HiveminezSeason2.getNpcManager().getNPCS().values()) {
            Player p = e.getPlayer();
            CraftPlayer craftPlayer = (CraftPlayer) p;
            ServerPlayer serverPlayer = craftPlayer.getHandle();
            ServerGamePacketListenerImpl listener = serverPlayer.connection;

            Location location = npc.getBukkitEntity().getLocation();
            location.setDirection(e.getPlayer().getLocation().subtract(location).toVector());

            float yaw = location.getYaw();
            float pitch = location.getPitch();

            listener.send(new ClientboundRotateHeadPacket(npc, (byte) ((yaw % 360) * 256 / 360)));
            listener.send(new ClientboundMoveEntityPacket.Rot(npc.getBukkitEntity().getEntityId(),
                    (byte) ((yaw % 360) * 256 / 360), (byte) ((pitch % 360) * 256 / 360), false));
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        new NPCs().spawnNPCs();
    }

}
