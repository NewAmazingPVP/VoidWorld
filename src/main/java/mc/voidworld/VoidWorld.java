package mc.voidworld;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class VoidWorld extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("createvoidworld").setExecutor(new VoidWorldCommand(this));
        getCommand("worldteleport").setExecutor(new TeleportCommand(this));
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new EmptyChunkGenerator();
    }

}
