package me.dkflab.bookgambling.listeners;

import me.dkflab.bookgambling.InvManager;
import me.dkflab.bookgambling.ItemFactory;
import me.dkflab.bookgambling.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.ArrayList;
import java.util.List;

public class InvClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof InvManager) {
            // inv is custom
            e.setCancelled(true);
            ItemStack i = e.getCurrentItem();
            if (i.getType().equals(Material.STAINED_GLASS_PANE)) {
                return;
            }
            // item must be book
            List<String> lore = new ArrayList<>();
            lore = i.getItemMeta().getLore();
            String[] arr = lore.get(0).split(" ");
            String type = arr[0].replaceAll(" ", "");
            type = ChatColor.stripColor(type);
            String strlevel = arr[1].replaceAll(" ", "");
            String strchance = lore.get(1).replaceAll("[§aChnce: %]","");
            Player player = (Player) e.getWhoClicked();
            int chance;
            int level;
            try {
                level = Integer.parseInt(strlevel);
                chance = Integer.parseInt(strchance);
            } catch (Exception er) {
                er.printStackTrace();
                return;
            }
            switch (type) {
                case "Sharpness":
                    givePlayerBook(Enchantment.DAMAGE_ALL, ItemFactory.sharp, player, level, chance);
                    return;
                case "Efficiency":
                    givePlayerBook(Enchantment.DIG_SPEED, ItemFactory.eff, player, level, chance);
                    return;
                case "Unbreaking":
                    givePlayerBook(Enchantment.DURABILITY, ItemFactory.unbreaking, player, level, chance);
                    return;
                case "Looting":
                    givePlayerBook(Enchantment.LOOT_BONUS_MOBS, ItemFactory.looting, player, level, chance);
                    return;
                case "Protection":
                    givePlayerBook(Enchantment.PROTECTION_ENVIRONMENTAL, ItemFactory.prot, player, level, chance);
                    return;
                default:
                    break;
            }
        }
    }

    private void givePlayerBook(Enchantment enchantment, ItemStack book, Player p, int level, int chance) {
        p.closeInventory();
        if (Math.random() <= (chance/100.0)) {
            // remove book
            p.getInventory().remove(book);
            // success
            ItemStack newBook = new ItemStack(Material.ENCHANTED_BOOK, 1);
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) newBook.getItemMeta();
            meta.addStoredEnchant(enchantment, level, false);
            newBook.setItemMeta(meta);
            p.getInventory().addItem(newBook);
            // send player message
            p.sendMessage(Utils.chat("&aYou were lucky and got a level " + level + " book!"));
        } else {
            p.sendMessage(Utils.chat("&cYour luck ran out and your book was destroyed!"));
            // remove book
            p.getInventory().remove(book);
        }
    }
}
