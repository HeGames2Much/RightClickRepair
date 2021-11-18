package club.therepo.rightclickrepair.commands;

import club.therepo.rightclickrepair.RightClickRepair;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RightClickGetGearCommand implements CommandExecutor {
    // This method is called, when somebody uses our command
    private ItemStack nameItem(ItemStack item, String name, String lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
        ArrayList<String> l = new ArrayList<String>();
        l.add(ChatColor.translateAlternateColorCodes('&',lore));
        meta.setLore(l);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        PlayerInventory inventory = player.getInventory();

        if (sender.isOp() || sender.hasPermission("rightclickrepair.use")) {
            ItemStack AdminAxe = new ItemStack(Material.DIAMOND_AXE);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.axe")) {
                inventory.addItem(nameItem(AdminAxe, messages, messages));
            }

            ItemStack AdminSword = new ItemStack(Material.DIAMOND_SWORD);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.sword")) {
                inventory.addItem(nameItem(AdminSword, messages, messages));
            }

            ItemStack AdminPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.pickaxe")) {
                inventory.addItem(nameItem(AdminPickaxe, messages, messages));
            }

            ItemStack AdminShovel = new ItemStack(Material.DIAMOND_SHOVEL);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.shovel")) {
                inventory.addItem(nameItem(AdminShovel, messages, messages));
            }

            ItemStack AdminChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminChestPlate, messages, messages));
            }

            ItemStack AdminBoots = new ItemStack(Material.DIAMOND_BOOTS);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminBoots, messages, messages));
            }

            ItemStack AdminHelmet = new ItemStack(Material.DIAMOND_HELMET);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminHelmet, messages, messages));
            }

            ItemStack AdminLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminLeggings, messages, messages));
            }

            ItemStack AdminBook = new ItemStack(Material.BOOK);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminBook, messages, messages));
            }

            String msg = "%sender% Ran the command %command%!"
                    .replaceAll("%sender%".toLowerCase(), sender.getName())
                    .replaceAll("%command%".toLowerCase(), command.getName());
            RightClickRepair.plugin.plugin.getLogger().info(msg);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
