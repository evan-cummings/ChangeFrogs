package fletchmod.changefrogs;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChangeFrogs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("frog babeyy");
        this.getCommand("setfrogtype").setExecutor(new CommandClass());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
