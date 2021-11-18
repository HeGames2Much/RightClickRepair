package club.therepo.rightclickrepair.commands;

import club.therepo.rightclickrepair.RightClickRepair;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RightClickRepairCommand implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp() || sender.hasPermission("rightclickrepair.use")) {
            for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("accept")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
            }
            String msg = "%sender% Ran the command %command%!"
                    .replaceAll("%sender%".toLowerCase(), sender.getName())
                    .replaceAll("%command%".toLowerCase(), command.getName());
            RightClickRepair.plugin.plugin.getLogger().info(msg);
        } else {
            if (sender instanceof Player) {

                for (String messages : RightClickRepair.plugin.plugin.getConfig().getStringList("accept")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
                }
                String msg = "%sender% Ran the command %command%!"
                        .replaceAll("%sender%".toLowerCase(), sender.getName())
                        .replaceAll("%command%".toLowerCase(), command.getName());
                RightClickRepair.plugin.plugin.getLogger().info(msg);
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
