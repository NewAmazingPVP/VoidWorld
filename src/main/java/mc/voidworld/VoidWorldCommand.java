package mc.voidworld;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VoidWorldCommand implements CommandExecutor {

    private final VoidWorld plugin;

    public VoidWorldCommand(VoidWorld plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("Usage: /createvoidworld <worldName>");
            return false;
        }

        String worldName = args[0];

        WorldCreator creator = new WorldCreator(worldName);
        creator.environment(Environment.NORMAL);
        creator.generator(new EmptyChunkGenerator());
        creator.createWorld();

        sender.sendMessage("Void world '" + worldName + "' created.");
        return true;
    }
}
