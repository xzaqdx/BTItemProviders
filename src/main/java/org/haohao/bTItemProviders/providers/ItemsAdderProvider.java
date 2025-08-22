package org.haohao.bTItemProviders.providers;

import dev.lone.itemsadder.api.ItemsAdder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTItemProviders.ItemProvider;

public class ItemsAdderProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            String[] parts = key.split(":");
            return parts.length == 3 ? ItemsAdder.getCustomItem(parts[1] + ":" + parts[2]) : null;
        } catch (Exception e) {
            return null;
        }
    }
}

