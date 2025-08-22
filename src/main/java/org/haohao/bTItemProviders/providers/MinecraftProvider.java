package org.haohao.bTItemProviders.providers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTItemProviders.ItemProvider;

public class MinecraftProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            return new ItemStack(Material.valueOf(key.split(":")[1].toUpperCase()));
        } catch (Exception e) {
            return null;
        }
    }
}

