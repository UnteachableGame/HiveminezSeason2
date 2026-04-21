package me.unteachable.hiveminezSeason2.npc;

import me.unteachable.hiveminezSeason2.HiveminezSeason2;
import me.unteachable.hiveminezSeason2.utils.NPC;
import me.unteachable.hiveminezSeason2.utils.npc.SkinData;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class NPCs {

    private final World world = Bukkit.getWorld("world");
    private static volatile ServerPlayer oreConverterNPC;
    private static volatile ServerPlayer shopNPC;

    public void spawnNPCs() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            spawnOreConverterNPC(onlinePlayer);
            spawnShopNPC(onlinePlayer);
        }
    }

    public void spawnOreConverterNPC(Player p) {
        oreConverterNPC = new NPC("Ore Converter", p, false).skinData(new SkinData(
                "ewogICJ0aW1lc3RhbXAiIDogMTc3NjIyNTA0NjQxNywKICAicHJvZmlsZUlkIiA6ICJmZDM2MzE4MzZlZjU0MThmYjhiZjI1N2FkYjExY2NlNSIsCiAgInByb2ZpbGVOYW1lIiA6ICJXaXphcmQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTMxNWRjNzRiNTQxMDUxMTAxODhlZGQwYzU0MmQ4NjZhNjM3ZjE1NzUzNmNhZjAzNzhhMDZkNTRjNWI3ZWQ1MSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9",
                "SZg/iMsHvyzdCbnt8PuTupdfYi9wbuvJZNhGLltxeSJoB886025/zBy1mzSyEs+AYTWk69FzGM8VAe5hte9SKoGOV8ZLTlTurluiojA4MKoCxvKjyUOEasdtVFxXNFJe/UBeiXH4+0ofZTUSDzDf6KJXj9NMpPDRqt4FAjmbMS7UyU0UtfJPwKIBiqFL7RRiKbBuJgFg58pbrP8/1K0E678J+0qi6ng0oAK2XkPwCryMWzhlH7psxs0z6pLlPizYXBCls1zoWE091r2zHb7gd2CwHIz/KMWsYVfQzyXBaOwYKA4KvVC/6fWReqltWK9Db0oSLnNYD1/WCouyGtsLyMPak28sQTQ17zOWMpejgYNsIIokjN66uDaoiivmWLPVfMf56ok56rWUOh3+gvUThk8te8gKYff8gHLw8QwMF6hcy0edGJviDutnDG6QipVD8DvztQ674c4AiUu9j9bsNAbwx5mjBgt7+Bz+YSHriki9SlQiFhWgOMo+FV0S/u09ZcSZZhiDtfx92I+/imJaYGXivOPELtY3vBiyT+qW8HZ1pft0SPMyu0lr7t3+uZLMIq6F/XX0n5tHUjDeXGmBhhiOk2azJ1iifOKLrNNPLgjkpqv4XVxYe+bHjaRKi5B8FL8P4lC1kMgZBJkE49rpLRD7r/UdyP9ibOqoWKVhQSw="
        )).location(new Location(world, 67, 68, 67)).createNPC();
        HiveminezSeason2.getNpcManager().getNPCS().put("ores", oreConverterNPC);
    }

    public void spawnShopNPC(Player p) {
        shopNPC = new NPC("Shop", p, false).skinData(new SkinData(
                "ewogICJ0aW1lc3RhbXAiIDogMTc3NjIyNTg1OTIwMCwKICAicHJvZmlsZUlkIiA6ICIzMzE0YWQ1YzA4M2U0MzBjYmFkZDU4MTUyZTQxOGYxMyIsCiAgInByb2ZpbGVOYW1lIiA6ICJTaG9wIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2IwMzZiNjUwNDM5NTZkYjgxY2U4ZGY4NTI4ODE4YTkzNmZhYWQyMmQwODAwMWY5MGUzYjlhNGRiOTdjMzc2NDUiCiAgICB9CiAgfQp9",
                "HZAk74AONMpOJ6UqJ6ag70eEjFkgF7mIAHhARSFngGx2/96LQ+LK/Do6NfR+rtRj03ukxJ0vH9Qj96J6wZYofeILhp7a5sgUEh81zi5S+o+lvOMXtwSSFhaIZOcBNVidDp0fcXrpfjpO3rp9cXdHMkLDDNOX0qmjKZ5lP0K0wPoJZJLGDwcDC4A8+KbN32lnoZUTIeNSVrtX/rcsNLl+LeSPrCUUhmCkYaul4Wi9GvmVa869MObVs3RwFObDU9wNOr1NlXR/iMt1wrdNlZpwRl2pHX+9GnMKe7ZJH5+sDMUM/7CuscgEjBaZ3QioQupgdTi6niSmZKB5jrlMFbhj77nmY+SrXCzoekyjogCqMRwdTjcolag0DqdAm1m5boGRVo7Xs8CZLw+ZsC6sndCCVH3PCtG5kcBuIITva/4xTfkNO08Y86ZJtPIQa/TiQQuEPumFqoHxtCZA37aRmDOXNOSl0Ohp6y7IwICw4ICfVof8CtIfLO+zEIcmqSWnJJ9O3b2xHTjAj5D8II7E/cWKLUNLnKWxaZJiJEC/ZVCi9SzdQPga5KWDYn1EPsoadYwd57C9hC8GJh9m76njkNAvwqHnTFlS1RPQe18XWr2ZPDBD0bXEYrSGzTCA52RjYJg3/qb1slnRiP4wBp7tEe+g4+J7+5w6VRrS5ZbKiixzYEQ="
        )).location(new Location(world, 69, 68, 65)).createNPC();
        HiveminezSeason2.getNpcManager().getNPCS().put("shop", shopNPC);
    }

}
