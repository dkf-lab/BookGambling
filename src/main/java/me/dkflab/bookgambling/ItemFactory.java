package me.dkflab.bookgambling;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    public static ItemStack book;
    public static ItemStack sharp;
    public static ItemStack prot;
    public static ItemStack eff;
    public static ItemStack unbreaking;
    public static ItemStack looting;

    public void init() {
        book = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = book.getItemMeta();
        meta.setDisplayName(Utils.chat("&a&lLucky Book!"));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.chat("&7No enchants. This is weird."));
        meta.setLore(lore);
        book.setItemMeta(meta);
        //sharp
        sharp = book.clone();
        addLore("Sharpness", sharp);
        // protection
        prot = book.clone();
        addLore("Protection", prot);
        // eff
        eff = book.clone();
        addLore("Efficiency", eff);
        // unbreaking
        unbreaking = book.clone();
        addLore("Unbrekaing", unbreaking);
        // looting
        looting = book.clone();
        addLore("Looting", looting);
    }

    private ItemStack addLore(String lore, ItemStack item) {
        List<String> l = new ArrayList<>();
        l.add(Utils.chat("&7" + lore));
        ItemMeta meta = item.getItemMeta();
        meta.setLore(l);
        item.setItemMeta(meta);
        return item;
    }
}
