package org.haohao.bTItemProviders.providers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTCore.BTCore;
import org.haohao.bTItemProviders.ItemProvider;

public class BTCoreProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            String[] parts = key.split(":");
            return parts.length == 2 ? BTCore.getInstance().getItemManager().getItem(parts[1], player) : null;
        } catch (Exception e) {
            return null;
        }
    }
}

