package me.xflyiwnl.testplugin;

import me.xflyiwnl.colorfulgui.ColorfulGUI;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    private static TestPlugin instance;

    private ColorfulGUI colorfulGUI;

    @Override
    public void onEnable() {
        instance = this;
        colorfulGUI = new ColorfulGUI(this);
        getCommand("test").setExecutor(new TestCommand());

    }

    public ColorfulGUI getColorfulGUI() {
        return colorfulGUI;
    }

    public static TestPlugin getInstance() {
        return instance;
    }

}
