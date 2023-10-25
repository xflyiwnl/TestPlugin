package me.xflyiwnl.testplugin;

import me.xflyiwnl.colorfulgui.object.DynamicItem;
import me.xflyiwnl.colorfulgui.object.Gui;
import me.xflyiwnl.colorfulgui.object.StaticItem;
import me.xflyiwnl.colorfulgui.provider.ColorfulProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TestInventory extends ColorfulProvider<Gui> {

    public TestInventory(Player player) {
        super(player, 1); // update time 1 seconds
    }

    @Override
    public void init() {
        StaticItem barrierItem = TestPlugin.getInstance().getColorfulGUI().staticItem()
                .material(Material.BLACK_STAINED_GLASS_PANE)
                .name("Barrier item")
                .build();
        getGui().addMask("B", barrierItem);

        DynamicItem clockItem = TestPlugin.getInstance().getColorfulGUI().dynamicItem()
                .material(Material.CLOCK)
                .name("Clock")
                .lore(Arrays.asList(
                        "loading time..."
                ))
                .build();
        getGui().addMask("C", clockItem);

    }

    @Override
    public void onClick(InventoryClickEvent event) {
        event.setResult(Event.Result.DENY);
    }

    public static void showGUI(Player player) {
        TestPlugin.getInstance().getColorfulGUI().gui()
                .title("Test gui!")
                .rows(5)
                .mask(Arrays.asList(
                        "BBBBBBBBB",
                        "BOOOOOOOB",
                        "BOOOCOOOB",
                        "BOOOOOOOB",
                        "BBBBBBBBB"
                ))
                .holder(new TestInventory(player))
                .build();
    }

}