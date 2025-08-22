package org.haohao.bTItemProviders.providers;

import com.willfp.ecoitems.items.EcoItem;
import com.willfp.ecoitems.items.EcoItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTItemProviders.ItemProvider;

public class EcoItemsProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            String[] parts = key.split(":");
            EcoItem ecoItem = EcoItems.INSTANCE.getByID(parts[1]);
            return ecoItem != null ? ecoItem.getItemStack() : null;
        } catch (Exception e) {
            return null;
        }
    }
}

