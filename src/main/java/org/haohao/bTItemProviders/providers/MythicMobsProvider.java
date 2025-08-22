package org.haohao.bTItemProviders.providers;

import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTItemProviders.ItemProvider;

public class MythicMobsProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            return MythicBukkit.inst().getItemManager().getItemStack(key.split(":")[1]);
        } catch (Exception e) {
            return null;
        }
    }
}

