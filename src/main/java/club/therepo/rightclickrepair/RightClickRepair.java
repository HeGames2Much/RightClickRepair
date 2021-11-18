package club.therepo.rightclickrepair;

import org.bukkit.plugin.java.JavaPlugin;

public final class RightClickRepair extends JavaPlugin {
    public static RightClickRepairPlugin plugin;

    @Override
    public void onEnable(){
        //Fired when the server starts and enables all plugins
        plugin = new RightClickRepairPlugin(this);
        plugin.enable();

    }



    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
        plugin.disable();
    }
}
