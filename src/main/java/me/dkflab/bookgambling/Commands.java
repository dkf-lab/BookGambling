package me.dkflab.bookgambling;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // book help
        // book <enchant>
        if (args.length != 1) {
            // trigger help
            help(sender);
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage("must be a player");
            return true;
        }
        if (!sender.hasPermission("book.admin")) {
            sender.sendMessage(Utils.chat("&c&lInsufficient permissions."));
            return true;
        }
        Player p = (Player) sender;
        // correct args
        switch (args[0]) {
            case "sharpness":
                p.getInventory().addItem(ItemFactory.sharp);
                return true;
            case "protection":
                p.getInventory().addItem(ItemFactory.prot);
                return true;
            case "efficiency":
                p.getInventory().addItem(ItemFactory.eff);
                return true;
            case "unbreaking":
                p.getInventory().addItem(ItemFactory.unbreaking);
                return true;
            case "looting":
                p.getInventory().addItem(ItemFactory.looting);
                return true;
            case "debug":
                p.getInventory().addItem(ItemFactory.book);
                return true;
            default:
                help(sender);
                return true;
        }
    }

    private void help(CommandSender s) {
        s.sendMessage("Book Help");
        s.sendMessage("/book <enchant>");
        s.sendMessage("List of Enchants:");
        s.sendMessage("Sharpness");
        s.sendMessage("Protection");
        s.sendMessage("Efficiency");
        s.sendMessage("Unbreaking");
        s.sendMessage("Looting");
    }
}
