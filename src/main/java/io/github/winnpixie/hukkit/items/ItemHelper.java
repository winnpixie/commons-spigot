package io.github.winnpixie.hukkit.items;

import java.util.function.Consumer;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemHelper {
    public static void editMetaData(ItemStack itemStack, Consumer<ItemMeta> consumer) {
        ItemMeta metadata = itemStack.getItemMeta();
        consumer.accept(metadata);
        itemStack.setItemMeta(metadata);
    }
}
