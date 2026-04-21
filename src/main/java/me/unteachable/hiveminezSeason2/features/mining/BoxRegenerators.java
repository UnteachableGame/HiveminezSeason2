package me.unteachable.hiveminezSeason2.features.mining;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.Random;

public class BoxRegenerators extends Prefix {

    World world = Bukkit.getWorld("world");
    Random random = new Random();

    public void regenerateBoxes(Collection<? extends Player> players) {
        new BukkitRunnable() {
            @Override
            public void run() {
                // The wood mine
                setBlocks(new Location(world, 56, 68, 69), new Location(world, 66, 73, 77),
                        new Location(world, 67, 68, 73, 90.0F, 0),
                        Material.OAK_LOG, Material.MANGROVE_LOG);
                // The stone mine
                setBlocks(new Location(world, 83, 68, 65), new Location(world, 93, 75, 75),
                        new Location(world, 69, 68, 67, -90.0F, 0),
                        Material.STONE, Material.COBBLESTONE);
                // The coal mine
                setBlocks(new Location(world, 83, 68, 77), new Location(world, 93, 75, 87),
                        new Location(world, 70, 68, 80, -90.0F, 0),
                        Material.COAL_ORE, Material.COAL_BLOCK);
                // The copper mine
                setBlocks(new Location(world, 56, 68, 80), new Location(world, 66, 75, 90),
                        new Location(world, 67, 68, 73, 90.0F, 0),
                        Material.COPPER_ORE, Material.RAW_COPPER_BLOCK);
                // The iron mine
                setBlocks(new Location(world, 83, 68, 89), new Location(world, 93, 75, 99),
                        new Location(world, 69, 68, 67, -90.0F, 0),
                        Material.IRON_ORE, Material.RAW_IRON_BLOCK);
                // The gold mine
                setBlocks(new Location(world, 83, 68, 102), new Location(world, 93, 75, 112),
                        new Location(world, 70, 68, 80, -90.0F, 0),
                        Material.GOLD_ORE, Material.RAW_GOLD_BLOCK);
                // The redstone mine
                setBlocks(new Location(world, 56, 68, 93), new Location(world, 66, 75, 103),
                        new Location(world, 67, 68, 73, 90.0F, 0),
                        Material.REDSTONE_ORE, Material.REDSTONE_BLOCK);
                // The lapis mine
                setBlocks(new Location(world, 56, 68, 106), new Location(world, 66, 75, 116),
                        new Location(world, 67, 68, 73, 90.0F, 0),
                        Material.LAPIS_ORE, Material.LAPIS_BLOCK);
                // The emerald mine
                setBlocks(new Location(world, 56, 68, 118), new Location(world, 66, 75, 128),
                        new Location(world, 69, 68, 67, -90.0F, 0),
                        Material.EMERALD_ORE, Material.EMERALD_BLOCK);
                // The diamond mine
                setBlocks(new Location(world, 83, 68, 114), new Location(world, 93, 75, 124),
                        new Location(world, 70, 68, 80, -90.0F, 0),
                        Material.DIAMOND_ORE, Material.DIAMOND_BLOCK);
                // The netherite mine
                setBlocks(new Location(world, 83, 68, 127), new Location(world, 93, 75, 137),
                        new Location(world, 67, 68, 73, 90.0F, 0),
                        Material.ANCIENT_DEBRIS, Material.NETHERITE_BLOCK);

                for (Player p : players) {
                    // This will play a sound when the ore box regenerates.
                    p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                }
            }
        }.runTaskTimer(HiveminezSeason2.getPlugin(), 0, 20 * 60); // repeats every 60 seconds upon the 20 ticks
    }

    public void setBlocks(Location loc1, Location loc2, Location relocate, Material... materials) {
        // This will regenerate the boxes this the set materials.
        for (int x = loc1.getBlockX(); x < loc2.getBlockX(); x++) {
            for (int z = loc1.getBlockZ(); z < loc2.getBlockZ(); z++) {
                for (int y = loc1.getBlockY(); y < loc2.getBlockY(); y++) {
                    for (int i = 0; i < materials.length; i++) {
                        world.setType(new Location(world, x, y, z), Material.AIR);
                        Location blockSetLocation = new Location(world, x, y, z);

                        // This will use all the materials in the list to regenerate with a percentage amount.
                        int randomMatInt = random.nextInt(0, 100);
                        if (randomMatInt >= 0 && randomMatInt <= 70) {
                            world.setType(blockSetLocation, materials[0]);
                        } else {
                            world.setType(blockSetLocation, materials[1]);
                        }

                        // This will remove the items that are on the ground in a nearby 3x3x3 bounding box around the regenerated ore box.
                        Collection<? extends Entity> entities = world.getNearbyEntities(blockSetLocation, 3, 3, 3);
                        if (!entities.isEmpty()) {
                            for (Entity e : entities) {
                                if (!e.getType().equals(EntityType.PLAYER)) {
                                    e.teleport(relocate);
                                } else {
                                    relocate.setX(relocate.getX() + 0.5);
                                    relocate.setZ(relocate.getZ() + 0.5);
                                    // This will teleport all players that are inside the box to a specific location and sends a message.
                                    e.teleport(relocate);
                                    e.sendMessage(setHiveMinezFormat("The mine reset and you were teleported out!"));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
