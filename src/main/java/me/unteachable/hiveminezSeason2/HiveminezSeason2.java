package me.unteachable.hiveminezSeason2;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import me.unteachable.hiveminezSeason2.commands.GiveStarterPickaxe;
import me.unteachable.hiveminezSeason2.commands.UtilCommands;
import me.unteachable.hiveminezSeason2.features.mining.BoxRegenerators;
import me.unteachable.hiveminezSeason2.features.mining.Compressor;
import me.unteachable.hiveminezSeason2.features.mining.DropManager;
import me.unteachable.hiveminezSeason2.features.mining.tracker.MiningTracker;
import me.unteachable.hiveminezSeason2.items.manager.AllItemsManager;
import me.unteachable.hiveminezSeason2.items.OreItems;
import me.unteachable.hiveminezSeason2.items.ToolItems;
import me.unteachable.hiveminezSeason2.items.WeaponItems;
import me.unteachable.hiveminezSeason2.listeners.BlockBreakListener;
import me.unteachable.hiveminezSeason2.listeners.UtilListeners;
import me.unteachable.hiveminezSeason2.menus.CompressorInfoMenu;
import me.unteachable.hiveminezSeason2.menus.shopmenus.ShopMenu;
import me.unteachable.hiveminezSeason2.npc.NPCListener;
import me.unteachable.hiveminezSeason2.npc.NPCManager;
import me.unteachable.hiveminezSeason2.npc.NPCs;
import me.unteachable.hiveminezSeason2.utils.PlayerMenuUtility;
import me.unteachable.hiveminezSeason2.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HiveminezSeason2 extends JavaPlugin {

    /*
        Focus towards box mining the progression of vanilla Minecraft from the first piece of wood to the elytra.

        Mining:
            Vanilla Miner/Chopper Role:
                Ores/Resources items
                    Progression
                        (overworld) wood, stone, coal, copper, iron, (ender dragon fight)
                        (nether) gold [retrieve nether items],
                        (overworld) redstone, lapis, emerald, diamond, (ender dragon fight)
                        (nether) netherite (ender dragon fight)
                    Metamorphic Progression
                        Tier    Ore Name            Hex Color (Example)         Physical Logic
                        Tier 1  Sediment Slate      §#A9A9A9 (Dark Grey)       Found in the "Crust." Brittle but easy to refine.
                        Tier 2  Oxidized Core       §#D97706 (Burnt Orange)    Ores that have reacted with the air/surface heat.
                        Tier 3  Crystalline Marrow  §#22D3EE (Electric Blue)   Found in the "Mantle." These ores have begun to glow.
                        Tier 4  Abyssal Shard       §#1E3A8A (Deep Indigo)     High-pressure minerals from the ocean floor area.
                        Tier 5  Sentient Pulse      §#F472B6 (Vibrant Pink)    Ores that "vibrate" and move (The Sentient Tier).
                        Final   Singularity         §#000000 (Void Black)      Ores that have collapsed under their own weight.

                        Classic Ore,    Tier 1: Sediment,   Tier 2: Oxidized,   Tier 3: Crystalline,    Tier 4: Abyssal,    Tier 5: Sentient,   Tier 6: Singularity
                        Wood,           Splintered Pine,    Charred Bark,       Amber-Glass,            Sunken Drift,       Living Root,        World-Tree Seed
                        Stone,          Gritty Shale,       Molten Slate,       Geode Slate,            Monolith Shard,     Pulsing Pebble,     Deepslate Core
                        Coal,           Peat Dust,          Bituminous,         Anthracite,             Pressure Carbon,    Shifting Smoke,     Black Hole Fuel
                        Copper,         Verdigris,          Rusted Wire,        Teal Spark,             Trench Wire,        Magnetic Coil,      Superconductor
                        Iron,           Raw Flake,          Cast Iron,          Steel Luster,           Heavy Plate,        Thumping Metal,     Pure Neutron
                        Gold,           Soft Nugget,        Gilded Scuff,       Solar Gem,              Deep-Sea Gild,      Liquid Gold,        Crown Jewel
                        Redstone,       Low Charge,         Spark Wire,         Pulsing Fiber,          Signal Vein,        Neural Path,        Infinite Logic
                        Lapis,          Dye Speck,          Azure Dust,         Mana Crystal,           Deep-Ink Gem,       Arcane Eye,         Cosmic Blue
                        Emerald,        Beryl Chip,         Rough Jade,         Royal Beryl,            Dark Emerald,       Growing Vine,       Merchant’s Heart
                        Diamond,        Dull Gem,           Carbon Edge,        Prism Glass,            Pressure Blue,      Shiver Gem,         Star Diamond
                        Netherite,      Scrap Dust,         Burnt Ingot,        Soul Essence,           Void Scrap,         Ancient Heart,      The End of Time

                Tools & Weapons items
                    Progression
                        (overworld) wooden, stone (stone and coal), copper, iron,
                        (nether) gold [retrieve nether items via tool],
                        (overworld) [redstone] (special), [lapis] (special), [emerald] (special), diamond,
                        (nether) netherite
                    Tiers
                        Tier    Prefix      Hex Color   Special Effect
                        T1      Sediment    #94A3B8     None
                        T2      Oxidized    #F97316     Slight Smoke Particles
                        T3      Crystalline #22D3EE     Italicized Name
                        T4      Abyssal     #6366F1     Bold Name
                        T5      Sentient    #EC4899     Bold Italic + Glow
                        T6      Singularity #1E1B4B§k   (Glitch) + Bold

                        Base Material   Pickaxe (Miner) Axe (Lumber/War)    Sword (Duelist)     Spear (Warrior) Bow/Crossbow    Fishing Rod (Diver)
                        Wood            Splinter        Hatchet             Shank               Javelin         Shortbow        Twig-Line
                        Stone           Chipper         Cleaver             Blade               Pillar          Pebble-Shot     Stone-Reeler
                        Coal            Ember-Pick      Cinder-Axe          Char-Edge           Soot-Stake      Smoke-Bow       Ash-Rod
                        Copper          Wire-Drill      Static-Axe          Coil-Rapier         Volt-Lance      Arc-Caster      Copper-Wire
                        Iron            Heavy-Bit       Battle-Axe          Broadsword          Halberd         Arbalest        Steel-Caster
                        Gold            Gilded-Pick     Royal-Axe           Midas-Blade         Aurum-Point     Solar-Bow       Golden-Hook
                        Redstone        Pulse-Drill     Signal-Axe          Laser-Edge          Kinetic-Pole    Logic-Bolt      Signal-Line
                        Lapis           Mana-Pick       Arcane-Axe          Mystic-Saber        Spell-Stave     Rune-Bow        Enchanted-Rod
                        Emerald         Beryl-Spade     Jade-Cutter         Noble-Estoc         Gem-Sting       Rich-Bow        Barter-Hook
                        Diamond         Prism-Pick      Shard-Axe           Crystal-Long        Jewel-SpearG    lass-Bolt       Abyssal-Reeler
                        Netherite       Void-Breaker    Ruin-Axe            Soul-Reaper         Rift-Piercer    Wither-Shot     Ancient-Line

                Armor items
                    Progression:
                        (overworld) (ender dragon fight) leather, chainmeal (stone and coal), copper, iron,
                        (nether) gold, [fight nether mobs]
                        (overworld) red-leather, blue-leather, green-leather, diamond, (ender dragon fight)
                        (nether) netherite (ender dragon fight)
                    Tiers
                        s
                    Armor Trim Abilities (18 Armor Trims, 16 Base Colors)
                        The Dimensional Compass: A custom item that changes color based on your dimension and displays your
                        current active armor ability in the Action Bar (above the hotbar).
                        The "Discovery" System: Don't tell them what the trims do. Make them "discover" the abilities by
                        entering the dimensions. When they enter the Nether for the first time with a trim, a Toast
                        Notification pops up: "Nether Ability Unlocked: Magma Router!"

                        Trim Patterns
                           Bolt	        Conduit Charge	    Increases Spear jab speed and slightly reduces cooldown.
                           Flow	        Aerodynamics	    Increases movement speed by 5% per piece (max 20%).
                           Silence	    Phantom Veil	    Crouch to hide your nameplate; reduces mob detection range.
                           Tide	        Oceanic Soul	    Grants the Breath of the Nautilus effect (unlimited oxygen).
                           Ward	        Ancient Barrier	    Reduces damage taken from Dynamic Hazards (Gravity Flips, etc.).
                           Rib	        Skeleton Structure	Resistance I but increases damage taken from Smite-enchanted spears.
                           Sentry	    Watchman’s Eye	    Highlights nearby mobs or invisible players within 5 blocks.
                           Spire	    Levitation Guard	Negates fall damage from heights greater than 10 blocks.
                           Snout	    Piglin Greed	    Increases the yield of Gold and Gilded Blackstone ores.
                           Eye	        Stronghold Focus	Critical hits deal 1.2x more damage.
                           Vex	        Phase Shift	        A 10% chance to dodge a melee attack entirely.
                           Wild	        Overgrowth	        Standing on grass/leaves grants slow Health Regeneration I.
                           Dune	        Sand Shroud	        Immune to the "Sandstorm" Dynamic Hazard in the PvP arena.
                           Coast	    Swift Swimmer	    Increases swim speed (stacks with Depth Strider).
                           Host	        Summoner	        Increases the stats of your Nautilus or Camel mounts.
                           Raiser	    Archeologist	    Higher chance to find "Legacy Items" in the mining zones.
                           Shaper	    Blacksmith	        Reduces the cost of upgrading gear at the Spire.
                           Wayfinder    Pathfinder	        Shows a particle trail leading to the nearest "Rich Ore Vein."

                       Trim Patterns - 1.21.11 Exclusive Mechanics
                           Bolt         Storm Charge        Increases the Charge attack speed of Spears by 20%.
                           Flow         Aero-DashPressing   Jump while sprinting triggers a Dash (similar to a Camel).
                           Silence      Null Void           While sneaking, you are invisible to the Zombie Nautilus PvE mobs.
                           Tide         Nautilus Heart      Passive Breath of the Nautilus (stops oxygen drain).
                           WardGuardian Wall                Reflects 10% of Spear Jab damage back to the attacker.
                           Rib          Death’s Reach       Increases Spear Jab range by 1.5 blocks.
                           Sentry       Radar Ping          Nearby ores "glow" through walls for 1 second every 10 seconds.
                           Spire        Sky-Leap            Standing on a Wind Charge launches you 2x higher.
                           Snout        Greed Sense         Breaking an ore has a 5% chance to spawn a Piglin Brute guard that fights for you.
                           Eye          Insight             You can see other players' health bars above their heads.
                           Vex          Phase Step          When hit, you have a 5% chance to teleport 3 blocks behind the enemy.
                           Wild         Nature’s Wrath      Spears deal +2 damage if the target is standing on grass or leaves.
                           Dune         Sand-Stride         No movement penalty while walking through water or "Hazard Sand."
                           Coast        Dolphin’s Grace     Grants permanent Speed I while in any water area.
                           Host         Mount Master        Tamed Nautilus mounts move 30% faster when you ride them.
                           Raiser       Ancient Luck        Double loot from Suspicious Sand in the mines.
                           Shaper       Mole’s Vision       Permanent Night Vision while below Y-level 0.
                           Wayfinder    Homing              Your Spear Charge slightly curves toward nearby enemies.

                       Color Families
                            The "Core" Metals
                                White (Quartz): Flash. Triggers a small blind effect on enemies when you are hit.
                                Light Grey (Iron): Magnetism. Automatically pulls dropped ores toward you.
                                Grey (Netherite): Heavyweight. Reduces knockback from Spears and explosions.
                                Black (Coal/Blackstone): Shadow. Increases damage dealt while at low light levels.
                                Yellow (Gold): Midas. Small chance for ores to drop an extra ingot.
                            The "Elemental" Shards
                                Red (Redstone): Haste. Increases mining speed by +1 level per piece.
                                Blue (Lapis): Enchanted. Increases the potency of Spear enchantments (like Lunge).
                                Cyan (Diamond): Hardened. Increases armor toughness.
                                Green (Emerald): Merchant. Gets better trade prices from the AI NPC.
                                Purple (Amethyst): Resonance. Creates a "Ding" sound and particle when a rare ore is nearby.
                            The "Special" Dyes (1.21.11 Exclusive)
                                Orange (Resin): Adhesive. Allows you to climb walls like a spider (if 3+ pieces are worn).
                                Pink (Cherry): Soft Landing. Creates a "cloud" of particles when you land, slowing your fall.
                                Lime (Slime): Bouncy. Increases jump height slightly.
                                Magenta/Pink: Life Link. Sharing food heals nearby teammates.

            Creative Miner Role:
                The Gaseous Tier (Early):
                    Ores like "Cloud Copper" that float upward when mined. You have to catch them or use a "Vacuum Hopper."
                The Liquid Tier (Mid):
                    "Mercury Iron." When you break the block, it turns into a falling liquid. You have to "bucket" it and
                    take it to a Freezer NPC to solidify it into ingots.
                The Sentient Tier (Late):
                    "Mimic Gold." These blocks occasionally move or "hop" to a different spot in the mine when you look at them.
                The Unstable Tier (End):
                    "Void Shards." If you hold these in your inventory for more than 60 seconds without putting them in
                    a "Stabilizer Box," they vanish. This creates a "sprint" mechanic from the mine to the chest.

        Daily Ender Dragon Fight Event (a time every day)
            Fight the ender dragon with others as a requirement.
            Doing this will be the only way for the indiviual player to progress on the server.
            There will be tiers of diffculty based upon the player's full armor upgrades (default reward will be having access to the next stage of the map and
            box server progression.) Player team amounts of 2, 3, 4, 5, 6.
                No Armor [Hard], legendary rewards, (2, 3, 4, 5, 6)
                    rewards (e.g. legendary crate key)
                Iron Armor [Normal], epic rewards, (2, 3, 4, 5, 6)
                    rewards (e.g. epic crate key)
                Diamond Armor [Easy], uncommon rewards, (2, 3, 4, 5, 6)
                    rewards (e.g. uncommon crate key)
                Netherite Armor [Semi-Esay], common rewards, (2, 3, 4, 5, 6)
                    rewards (e.g. common crate key)

        Fishing:
            Fisherman role:
                Fish item class -

        PvP:
            Warrior role:
                Weapons item class -

         Items class
            types of items - ore, armor, tools, fish, weapons
                material
                name
                lore
                enchant
                break sound
                rarity
                unbreakable?
         */

    private ProtocolManager protocolManager;
    private static MiningTracker miningTracker;
    private static AllItemsManager allItemsManager;
    private static NPCManager npcManager;
    private static Map<Player, PlayerMenuUtility> playerMenuUtilityMap;
    private static Prefix prefix;
    private static DropManager dropManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        BoxRegenerators regen = new BoxRegenerators();
        regen.regenerateBoxes(Bukkit.getOnlinePlayers());

        protocolManager = ProtocolLibrary.getProtocolManager();
        miningTracker = new MiningTracker(); // create mining tracker instance once upon start up to then reference.
        allItemsManager = new AllItemsManager();
        npcManager = new NPCManager();
        playerMenuUtilityMap = new HashMap<>();
        prefix = new Prefix();
        dropManager = new DropManager();

        registerListenersAndCommands();
        protocolManagerRunner();
        configuration();
        new OreItems().setOreItemsInList();
        new ToolItems().setToolItemsInList();
        new WeaponItems().setWeaponItemsInList();
        new NPCs().spawnNPCs();
        getDropManager().makeDrops();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("HiveminezSeason2");
    }

    public void registerListenersAndCommands() {
        PluginManager manager = getServer().getPluginManager();

        // listeners
        manager.registerEvents(new BlockBreakListener(), this);
        manager.registerEvents(new UtilListeners(), this);
        manager.registerEvents(new NPCListener(), this);

        // commands
        getCommand("feed").setExecutor(new UtilCommands());
        getCommand("starterpickaxe").setExecutor(new GiveStarterPickaxe());
        getCommand("seeallitems").setExecutor(new UtilCommands());
    }

    public void configuration() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;

        if (playerMenuUtilityMap.containsKey(p)) {
            return playerMenuUtilityMap.get(p);
        } else {
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        }
    }

    public void protocolManagerRunner() {
        HiveminezSeason2 plugin2 = this;

        getProtocolManager().addPacketListener(new PacketAdapter(this, PacketType.Play.Client.USE_ENTITY) {
            @Override
            public void onPacketReceiving(PacketEvent e) {
                Player p = e.getPlayer();
                PacketContainer packet = e.getPacket();
                int entityID = packet.getIntegers().read(0);

                WrappedEnumEntityUseAction useAction = e.getPacket().getEnumEntityUseActions().read(0);

                if (entityID == getNpcManager().getNpcID(getNpcManager().getNPCS().get("ores"))) {
                    // right click
                    if (useAction.getAction() == EnumWrappers.EntityUseAction.INTERACT) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item != null) {
                                compressItemInfo(p);
                            }
                        }

                        // left click
                    } else if (useAction.getAction() == EnumWrappers.EntityUseAction.ATTACK) {
                        getServer().getScheduler().runTask(plugin, () -> new CompressorInfoMenu(getPlayerMenuUtility(p), plugin2).open());
                    }
                } else if (entityID == getNpcManager().getNpcID(getNpcManager().getNPCS().get("shop"))) {
                    getServer().getScheduler().runTask(plugin, () -> new ShopMenu(getPlayerMenuUtility(p)).open());
                }
            }
        });
    }

    public void compressItemInfo(Player p) {
        Map<ItemStack, String> ores = HiveminezSeason2.getAllItemsManager().getOreItems();
        List<ItemStack> oresList = new ArrayList<>(ores.keySet());

        int oreIndex = 1;
        for (int index = 0; index < oresList.size(); index++) {
            if (index + 1 >= ores.size()) break;

            ItemStack ore = oresList.get(index);
            ItemStack newOre = ore.clone();
            if (!newOre.hasItemMeta()) continue;
            String oreType = ores.get(newOre);

            Compressor.compress(p, AllItemsManager.addCount(oresList.get(index + 1), 1),
                    AllItemsManager.addCount(oresList.get(index),
                            getConfig().getInt(String.format("ores.%s.%d", oreType, oreIndex))));

            if (oreIndex == 6) {
                oreIndex = 0;
            }

            oreIndex++;
        }
    }

    public static MiningTracker getMiningTracker() {
        return miningTracker;
    }

    public static AllItemsManager getAllItemsManager() {
        return allItemsManager;
    }

    public static NPCManager getNpcManager() {
        return npcManager;
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public static Prefix getPrefix() {
        return prefix;
    }

    public static DropManager getDropManager() {
        return dropManager;
    }
}
