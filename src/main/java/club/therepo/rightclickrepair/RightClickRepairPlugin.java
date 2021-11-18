package club.therepo.rightclickrepair;

import club.therepo.rightclickrepair.commands.RightClickGetGearCommand;
import club.therepo.rightclickrepair.commands.RightClickRepairCommand;
import club.therepo.rightclickrepair.listeners.RightClickRepairListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import java.util.Objects;

public class RightClickRepairPlugin {
    public final RightClickRepair plugin;

    RightClickRepairPlugin(RightClickRepair plugin) {
        this.plugin = plugin;
    }

    void enable() {
        plugin.getLogger().info("RightClickRepair is starting up!");
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveDefaultConfig();
        Objects.requireNonNull(plugin.getCommand("repair")).setExecutor(new RightClickRepairCommand());
        Objects.requireNonNull(plugin.getCommand("gear")).setExecutor(new RightClickGetGearCommand());
        new RightClickRepairListener(this);
    }

    void disable() {
        plugin.getLogger().info("RightClickRepair is shutting down!");
        HandlerList.unregisterAll(plugin);
        Bukkit.getScheduler().cancelTasks(plugin);
        plugin.getLogger().info("Goodbye!");
    }
}
