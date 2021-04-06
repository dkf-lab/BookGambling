package me.dkflab.bookgambling;

import me.dkflab.bookgambling.listeners.InvClick;
import me.dkflab.bookgambling.listeners.RightClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class BookGambling extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemFactory f = new ItemFactory();
        f.init();
        getCommand("book").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new RightClick(), this);
        getServer().getPluginManager().registerEvents(new InvClick(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
