package mc.voidworld;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TeleportCommand implements CommandExecutor, TabCompleter {

    private final VoidWorld plugin;

    public TeleportCommand(VoidWorld plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Usage: /teleport <worldName>");
            return false;
        }

        String worldName = args[0];
        World world = Bukkit.getWorld(worldName);

        if (world == null) {
            player.sendMessage("World '" + worldName + "' does not exist.");
            return true;
        }

        player.teleport(new Location(world, 0, 100, 0));

        player.sendMessage("Teleported to world '" + worldName + "'.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            for (String worldName : Bukkit.getWorlds().stream().map(World::getName).toList()) {
                completions.add(worldName);
            }
        }

        return completions;
    }
}
