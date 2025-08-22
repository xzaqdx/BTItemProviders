package org.haohao.bTItemProviders;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.haohao.bTItemProviders.providers.*;
import java.util.*;
import java.util.stream.Collectors;

public final class ItemProviderManager {
    private static final Map<String, ItemProvider> providers = new HashMap<>();

    private ItemProviderManager() {} // 防止实例化

    public static ItemStack getItem(String fullKey, Player player) {
        try {
            if (!fullKey.contains(":")) {
                fullKey = "mc:" + fullKey; // 默认原版前缀
            }

            String[] parts = fullKey.split(":", 2);
            ItemProvider provider = providers.get(parts[0].toLowerCase());
            return provider != null ? provider.getItem(fullKey, player) : null;
        } catch (Exception e) {
            return null; // 静默失败
        }
    }
    /**
     * 手动注册物品提供器
     */
    public static void registerProvider(String prefix, ItemProvider provider) {
        if (prefix != null && provider != null) {
            providers.put(prefix.toLowerCase(), provider);
        }
    }

    /**
     * 自动注册所有支持的提供器
     */
    public static void autoRegister() {
        Set<String> plugins = Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .map(Plugin::getName)
                .collect(Collectors.toSet());

        // 原版/Minecraft
        registerProvider("minecraft", new MinecraftProvider());
        registerProvider("mc", new MinecraftProvider());

        registerIfPluginExists(plugins, "BTCore",
                "btcore", new BTCoreProvider(),
                "bt", new BTCoreProvider());

        // 条件注册第三方插件
        registerIfPluginExists(plugins, "MMOItems",
                "mmoitems", new MMOItemsProvider(),
                "mi", new MMOItemsProvider());

        registerIfPluginExists(plugins, "NeigeItems",
                "neigeitems", new NeigeItemsProvider(),
                "ni", new NeigeItemsProvider());

        registerIfPluginExists(plugins, "MythicMobs",
                "mythicmobs", new MythicMobsProvider(),
                "mm", new MythicMobsProvider());

        registerIfPluginExists(plugins, "ItemsAdder",
                "itemsadder", new ItemsAdderProvider(),
                "ia", new ItemsAdderProvider());

        registerIfPluginExists(plugins, "EcoItems",
                "ecoitems", new EcoItemsProvider(),
                "ei", new EcoItemsProvider());
    }

    private static void registerIfPluginExists(Set<String> enabledPlugins,
                                               String pluginName,
                                               Object... registrations) {
        if (!enabledPlugins.contains(pluginName)) return;

        for (int i = 0; i < registrations.length; i += 2) {
            registerProvider((String)registrations[i], (ItemProvider)registrations[i+1]);
        }
    }
}
