package org.haohao.bTItemProviders.item.providers;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.haohao.bTItemProviders.item.ItemProvider;
import pers.neige.neigeitems.manager.ItemManager;
public class NeigeItemsProvider implements ItemProvider {
    @Override
    public ItemStack getItem(String key, Player player) {
        try {
            return ItemManager.INSTANCE.getItemStack(key.split(":")[1], player, (String) null);
        } catch (Exception e) {
            return null;
        }
    }
}

