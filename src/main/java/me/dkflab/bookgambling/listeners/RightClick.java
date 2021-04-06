package me.dkflab.bookgambling.listeners;

import me.dkflab.bookgambling.InvManager;
import me.dkflab.bookgambling.ItemFactory;
import me.dkflab.bookgambling.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RightClick implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Action a = e.getAction();
        Player p = e.getPlayer();
        if (a==Action.LEFT_CLICK_AIR||a==Action.RIGHT_CLICK_AIR||a==Action.LEFT_CLICK_BLOCK||a==Action.RIGHT_CLICK_BLOCK) {
            if (p == null) {
                return;
            }
            if (p.getInventory() == null||p.getInventory().getItemInMainHand() == null||p.getInventory().getItemInMainHand().getItemMeta() == null) {
                return;
            }
            if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Utils.chat("&a&lLucky Book!"))) {
                e.setCancelled(true);
                ItemStack i = p.getInventory().getItemInMainHand();
                InvManager man = new InvManager();
                if (i.isSimilar(ItemFactory.eff)) {
                    p.openInventory(man.eff());
                }
                if (i.isSimilar(ItemFactory.looting)) {
                    p.openInventory(man.looting());
                }
                if (i.isSimilar(ItemFactory.prot)) {
                    p.openInventory(man.prot());
                }
                if (i.isSimilar(ItemFactory.sharp)) {
                    p.openInventory(man.sharp());
                }
                if (i.isSimilar(ItemFactory.unbreaking)) {
                    p.openInventory(man.unbreaking());
                }
            }
        }
    }

}
