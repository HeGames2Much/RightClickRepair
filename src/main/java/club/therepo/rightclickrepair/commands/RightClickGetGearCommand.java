package club.therepo.rightclickrepair.commands;

import club.therepo.customenchantments.CustomEnchantmentsPlugin;
import club.therepo.rightclickrepair.RightClickRepair;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
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
            AdminAxe.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminAxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            AdminAxe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            AdminAxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
            AdminAxe.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
            AdminAxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
            AdminAxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
            if (Bukkit.getServer().getPluginManager().getPlugin("CustomEnchantments") != null) {
                AdminAxe.addUnsafeEnchantment(CustomEnchantmentsPlugin.TELEPATHY, 10);
            }
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.axe")) {
                inventory.addItem(nameItem(AdminAxe, messages, messages));
            }

            ItemStack AdminSword = new ItemStack(Material.DIAMOND_SWORD);
            AdminSword.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminSword.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            AdminSword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            AdminSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
            AdminSword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
            AdminSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
            AdminSword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
            if (Bukkit.getServer().getPluginManager().getPlugin("CustomEnchantments") != null) {
                AdminSword.addUnsafeEnchantment(CustomEnchantmentsPlugin.TELEPATHY, 10);
            }
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.sword")) {
                inventory.addItem(nameItem(AdminSword, messages, messages));
            }

            ItemStack AdminPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
            AdminPickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
            if (Bukkit.getServer().getPluginManager().getPlugin("CustomEnchantments") != null) {
                AdminPickaxe.addUnsafeEnchantment(CustomEnchantmentsPlugin.TELEPATHY, 10);
            }
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.pickaxe")) {
                inventory.addItem(nameItem(AdminPickaxe, messages, messages));
            }

            ItemStack AdminShovel = new ItemStack(Material.DIAMOND_SHOVEL);
            AdminShovel.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminShovel.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            AdminShovel.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            AdminShovel.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
            AdminShovel.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
            AdminShovel.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
            AdminShovel.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
            if (Bukkit.getServer().getPluginManager().getPlugin("CustomEnchantments") != null) {
                AdminShovel.addUnsafeEnchantment(CustomEnchantmentsPlugin.TELEPATHY, 10);
            }
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.shovel")) {
                inventory.addItem(nameItem(AdminShovel, messages, messages));
            }

            ItemStack AdminChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            AdminChestPlate.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminChestPlate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminChestPlate, messages, messages));
            }

            ItemStack AdminBoots = new ItemStack(Material.DIAMOND_BOOTS);
            AdminBoots.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminBoots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminBoots, messages, messages));
            }

            ItemStack AdminHelmet = new ItemStack(Material.DIAMOND_HELMET);
            AdminHelmet.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminHelmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminHelmet, messages, messages));
            }

            ItemStack AdminLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
            AdminLeggings.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminLeggings.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.armor")) {
                inventory.addItem(nameItem(AdminLeggings, messages, messages));
            }

            ItemStack AdminBow = new ItemStack(Material.BOW);
            AdminBow.addUnsafeEnchantment(Enchantment.MENDING, 10);
            AdminBow.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            AdminBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
            AdminBow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
            AdminBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 10);
            AdminBow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("lore.bow")) {
                inventory.addItem(nameItem(AdminBow, messages, messages));
            }

            ItemStack AdminBook = new ItemStack(Material.ENCHANTED_BOOK);
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
