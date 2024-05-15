package io.github.winnpixie.commons.spigot;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.function.Consumer;

public class ItemHelper {
    // Shamelessly stolen and re-implemented from Paper API's javadocs
    public static void editMetaData(ItemStack stack, Consumer<ItemMeta> consumer) {
        editMetaData(stack, ItemMeta.class, consumer);
    }

    // Shamelessly stolen and re-implemented from Paper API's javadocs
    public static <T extends ItemMeta> void editMetaData(ItemStack stack, Class<T> metaCls, Consumer<T> consumer) {
        T metadata = metaCls.cast(stack.getItemMeta());
        consumer.accept(metadata);
        stack.setItemMeta(metadata);
    }
}
