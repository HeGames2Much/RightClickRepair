package club.therepo.rightclickrepair.listeners;

import club.therepo.rightclickrepair.RightClickRepair;
import club.therepo.rightclickrepair.RightClickRepairPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class RightClickRepairListener implements Listener {

    private final RightClickRepairPlugin plugin;

    public RightClickRepairListener(RightClickRepairPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin.plugin);
    }

    // This method checks for incoming players and sends them a message
    @EventHandler(priority = EventPriority.LOWEST)
    public void onRightClick(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();
        ItemStack i = event.getItem();

        if (RightClickRepair.plugin.plugin.getConfig().getBoolean("options.enable")) {
            if (action.equals(Action.RIGHT_CLICK_AIR)) {
                if (i.getItemMeta().getLore() != null) {
                    if (i.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.axe")))
                            || i.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.sword")))
                            || i.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.pickaxe")))
                            || i.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.shovel")))) {
                        for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("accept")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages
                                    .replaceAll("%gear%".toLowerCase(), i.getItemMeta().getDisplayName())
                            ));
                        }
                        ItemMeta itemMeta = i.getItemMeta();
                        if (itemMeta instanceof Damageable){
                            ((Damageable) itemMeta).setDamage((short) 0);
                        }
                        i.setItemMeta(itemMeta);
                    }
                    if (i.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.bow")))) {
                        for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("accept")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages
                                    .replaceAll("%gear%".toLowerCase(), i.getItemMeta().getDisplayName())
                            ));
                        }
                        ItemMeta itemMeta = i.getItemMeta();
                        if (itemMeta instanceof Damageable){
                            ((Damageable) itemMeta).setDamage((short) 0);
                        }
                        i.setItemMeta(itemMeta);
                    }
                    if (i.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.armor")))) {
                        final ItemStack[] content = player.getInventory().getArmorContents();
                        for (int b = 0; b < content.length; b++) {
                            final ItemStack item = content[b];
                            if (item != null) {
                                if (item.getItemMeta().getLore().toString().equals(ChatColor.translateAlternateColorCodes('&', plugin.plugin.getConfig().getString("lore.armor")))) {
                                    ItemMeta itemMeta = i.getItemMeta();
                                    if (itemMeta instanceof Damageable){
                                        ((Damageable) itemMeta).setDamage((short) 0);
                                    }
                                    i.setItemMeta(itemMeta);
                                }
                            }
                        }
                        for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("accept")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages
                                    .replaceAll("%gear%".toLowerCase(), i.getItemMeta().getDisplayName())
                            ));
                        }
                    }
                }
            }
        }
    }
}