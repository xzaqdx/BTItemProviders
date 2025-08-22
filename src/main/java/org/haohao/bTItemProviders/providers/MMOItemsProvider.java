package org.haohao.bTItemProviders.providers;

import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTItemProviders.ItemProvider;

public class MMOItemsProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            String[] parts = key.split(":");
            Type type = Type.get(parts[1]);
            return type != null ? MMOItems.plugin.getItem(type, parts[2]) : null;
        } catch (Exception e) {
            return null;
        }
    }
}

