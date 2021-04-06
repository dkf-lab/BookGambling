package me.dkflab.bookgambling;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvManager implements InventoryHolder {

    private Inventory inv;
    private Inventory sharp;
    private Inventory prot;
    private Inventory eff;
    private Inventory unbreaking;
    private Inventory looting;

    public InvManager() {
        inv = Bukkit.createInventory(this, 9, "Lucky Book");
        sharp = Bukkit.createInventory(this, 9, "Lucky Book");
        prot = Bukkit.createInventory(this, 9, "Lucky Book");
        eff = Bukkit.createInventory(this, 9, "Lucky Book");
        unbreaking = Bukkit.createInventory(this, 9, "Lucky Book");
        looting = Bukkit.createInventory(this, 9, "Lucky Book");
        init();
    }

    private void init() {
        ItemStack lg = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.LIME.getDyeData());
        ItemMeta meta = lg.getItemMeta();
        meta.setLore(Collections.singletonList(Utils.chat("&r")));
        meta.setDisplayName(Utils.chat("&r"));
        lg.setItemMeta(meta);
        // sharpness
        sharp.setItem(1, lg);
        sharp.setItem(3, lg);
        sharp.setItem(5, lg);
        sharp.setItem(7, lg);
        // books
        sharp.setItem(0, createitem("&bSharpness 1", lore("Sharpness 1", "80")));
        sharp.setItem(2, createitem("&bSharpness 2", lore("Sharpness 2", "60")));
        sharp.setItem(4, createitem("&bSharpness 3", lore("Sharpness 3", "40")));
        sharp.setItem(6, createitem("&bSharpness 4", lore("Sharpness 4", "20")));
        sharp.setItem(8, createitem("&bSharpness 5", lore("Sharpness 5", "10")));
        //  eff
        eff.setItem(1, lg);
        eff.setItem(3, lg);
        eff.setItem(5, lg);
        eff.setItem(7, lg);
        eff.setItem(0, createitem("&bEfficiency 1", lore("Efficiency 1", "80")));
        eff.setItem(2, createitem("&bEfficiency 2", lore("Efficiency 2", "60")));
        eff.setItem(4, createitem("&bEfficiency 3", lore("Efficiency 3", "40")));
        eff.setItem(6, createitem("&bEfficiency 4", lore("Efficiency 4", "20")));
        eff.setItem(8, createitem("&bEfficiency 5", lore("Efficiency 5", "10")));
        // unbreaking
        unbreaking.setItem(1,lg);
        unbreaking.setItem(0,lg);
        unbreaking.setItem(2,lg);
        unbreaking.setItem(6,lg);
        unbreaking.setItem(7,lg);
        unbreaking.setItem(8,lg);
        unbreaking.setItem(3, createitem("&bUnbreaking 1", lore("Unbreaking 1", "75")));
        unbreaking.setItem(4, createitem("&bUnbreaking 2", lore("Unbreaking 2", "50")));
        unbreaking.setItem(5, createitem("&bUnbreaking 3", lore("Unbreaking 3", "25")));
        // looting
        looting.setItem(1,lg);
        looting.setItem(0,lg);
        looting.setItem(2,lg);
        looting.setItem(6,lg);
        looting.setItem(7,lg);
        looting.setItem(8,lg);
        looting.setItem(3, createitem("&bLooting 1", lore("Looting 1", "75")));
        looting.setItem(4, createitem("&bLooting 2", lore("Looting 2", "50")));
        looting.setItem(5, createitem("&bLooting 3", lore("Looting 3", "25")));
        // protection
        prot.setItem(0,lg);
        prot.setItem(2,lg);
        prot.setItem(4,lg);
        prot.setItem(6,lg);
        prot.setItem(8,lg);
        prot.setItem(1, createitem("&bProtection 1", lore("Protection 1", "80")));
        prot.setItem(3, createitem("&bProtection 2", lore("Protection 2", "60")));
        prot.setItem(5, createitem("&bProtection 3", lore("Protection 3", "40")));
        prot.setItem(7, createitem("&bProtection 4", lore("Protection 3", "20")));
    }

    private ItemStack createitem(String name, List<String> lore) {
        ItemStack item = new ItemStack(Material.BOOK ,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private List<String> lore(String name, String chance) {
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + name);
        lore.add(ChatColor.GREEN + "Chance: " + chance + "%");
        return lore;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
    public Inventory sharp() {
        return sharp;
    }
    public Inventory prot() {
        return prot;
    }
    public Inventory looting() {
        return looting;
    }
    public Inventory unbreaking() {
        return unbreaking;
    }
    public Inventory eff() {
        return eff;
    }
}
