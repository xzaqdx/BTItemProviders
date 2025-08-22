package org.haohao.bTItemProviders.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ItemProvider {
    /**
     * 获取物品
     * @param key 物品标识符 (格式如：mmoitems:SWORD:EXCALIBUR)
     * @param player 关联玩家(用于某些需要玩家上下文物品)
     * @return 物品堆栈
     */
    ItemStack getItem(String key, Player player);
}
