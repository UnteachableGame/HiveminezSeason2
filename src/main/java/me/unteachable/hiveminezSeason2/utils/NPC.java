package me.unteachable.hiveminezSeason2.utils;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.datafixers.util.Pair;
import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.npc.EquipmentSlotData;
import me.unteachable.hiveminezSeason2.utils.npc.SkinData;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_21_R7.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R7.inventory.CraftItemStack;
import org.bukkit.entity.Player;

import java.util.*;

public class NPC {

    private final String displayName;
    private final Player p;
    private SkinData skinData;
    private Location location;
    private List<EquipmentSlotData> equipmentSlotData;
    private boolean lying = false;
    private boolean hideNameTag = false;
    private Pose pose;
    private ServerPlayer serverPlayer;
    private final boolean isOwnSkin;

    public NPC(String displayName, Player p, boolean isOwnSkin) {
        this.displayName = displayName;
        this.p = p;
        this.isOwnSkin = isOwnSkin;
    }

    public NPC skinData(SkinData skinData) {
        this.skinData = skinData;
        return this;
    }
    public NPC location(Location location) {
        this.location = location;
        return this;
    }
    public NPC equipment(EquipmentSlotData... equipmentSlotData) {
        this.equipmentSlotData = new ArrayList<>(List.of(equipmentSlotData));
        return this;
    }
    public NPC lying() {
        this.lying = true;
        return this;
    }
    public NPC hideNameTag() {
        this.hideNameTag = true;
        return this;
    }
    public Pose pose(Pose pose) {
        return pose;
    }

    public ServerPlayer createNPC() {

        CraftPlayer craftPlayer = (CraftPlayer) p;
        ServerPlayer serverPlayer = craftPlayer.getHandle();

        ServerLevel level = serverPlayer.level();
        MinecraftServer server = level.getServer();

        Multimap<String, Property> mutableMap = HashMultimap.create();
        if (location == null) {
            location = p.getLocation();
        }

        // Making the skin choice
        GameProfile gameProfile;
        if (!isOwnSkin && skinData.getSignature() == null && skinData.getTexture() == null) {
            this.skinData = new SkinData(false);
        }
        if (!isOwnSkin && skinData.getSignature() != null && skinData.getTexture() != null) {
            mutableMap.put("textures", new Property("textures", skinData.getTexture(), skinData.getSignature()));
            PropertyMap properties = new PropertyMap(mutableMap);
            gameProfile = new GameProfile(UUID.randomUUID(), displayName, properties);

        } else if (skinData.isOwnSkin()) {
            GameProfile playerProfile = craftPlayer.getProfile();

            Property property = (Property) playerProfile.properties().get("textures").toArray()[0];
            skinData.setSignature(property.signature());
            skinData.setTexture(property.value());

            mutableMap.put("textures", new Property("textures", skinData.getTexture(), skinData.getSignature()));

            PropertyMap properties = new PropertyMap(mutableMap);
            if (lying) {
                gameProfile = new GameProfile(UUID.randomUUID(), displayName, properties);
            } else {
                gameProfile = new GameProfile(UUID.randomUUID(), craftPlayer.getName(), properties);
            }

        } else {
            System.out.println("NPC was created with a default skin!");
            gameProfile = new GameProfile(UUID.randomUUID(), displayName);
        }

        // Now create the NPC using the updated profile
        ClientInformation clientInformation = ClientInformation.createDefault();
        ServerPlayer npc = new ServerPlayer(server, level, gameProfile, clientInformation);

        Connection dummyConnection = new Connection(PacketFlow.CLIENTBOUND);
        CommonListenerCookie cookie = CommonListenerCookie.createInitial(gameProfile, false);
        npc.connection = new ServerGamePacketListenerImpl(server, dummyConnection, npc, cookie);
        location.setY(location.getBlockY());

        // sets the npc to be on the ground
        while (location.getBlock().getType().equals(Material.AIR)) {
            location.subtract(0, 1, 0);
        }

        location.setY(location.getY() + 1);
        npc.setPos(location.getX(), location.getY(), location.getZ());

        // This gives the skin the layers of the second skin on the npc
        npc.getEntityData().set(net.minecraft.world.entity.player.Player.DATA_PLAYER_MODE_CUSTOMISATION, (byte) 0x7F);

        // Sets the pose of the npc
        if (lying) {
            npc.setPose(Pose.SLEEPING);
        }
        if (pose != null) {
            if (pose != Pose.SLEEPING) {
                npc.setPose(pose);
            } else {
                p.sendMessage(new Prefix().translateColorCodes("&cError! You can't set the condition lying and POSE.Sleeping to both be true."));
            }
        }

        // This hides the npc's nametag
        PlayerTeam team = new PlayerTeam(new Scoreboard(), displayName);
        if (hideNameTag || lying) {
            team.getPlayers().add("");
            team.setNameTagVisibility(Team.Visibility.NEVER);
        }


        ServerGamePacketListenerImpl listener = ((CraftPlayer) p).getHandle().connection;

        // This sends a packet to the player to add the npc to the client's tab list.
        listener.send(new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER), List.of(npc)));
        // This sends a packet to the player to put the npc body into the world.
        listener.send(new ClientboundAddEntityPacket(npc, 0, npc.blockPosition()));
        // This sends a packet to the player to update the metadata and appearance of the npc.
        listener.send(new ClientboundSetEntityDataPacket(npc.getId(), Objects.requireNonNull(npc.getEntityData().getNonDefaultValues())));

        if (equipmentSlotData != null) {
            List<Pair<EquipmentSlot, ItemStack>> pairs = new ArrayList<>();
            for (EquipmentSlotData data : equipmentSlotData) {
                pairs.add(new Pair<>(data.getEquipmentSlot(), CraftItemStack.asNMSCopy(data.getItem())));
            }
            listener.send(new ClientboundSetEquipmentPacket(npc.getBukkitEntity().getEntityId(), pairs));
        }

        if (lying) {
            listener.send(ClientboundSetPlayerTeamPacket.createRemovePacket(team));
            listener.send(ClientboundSetPlayerTeamPacket.createAddOrModifyPacket(team, true));

        }

        return npc;
    }

    public String getDisplayName() {
        return displayName;
    }

    public SkinData getSkinData() {
        return skinData;
    }

    public Location getLocation() {
        return location;
    }

    public List<EquipmentSlotData> getEquipmentSlotData() {
        return equipmentSlotData;
    }

    public void setServerPlayer(ServerPlayer serverPlayer) {
        this.serverPlayer = serverPlayer;
    }

    public ServerPlayer getServerPlayer() {
        return serverPlayer;
    }

}
