package me.axua.impactplus;

import me.axua.impactplus.command.CommandManager;
import me.axua.impactplus.event.EventProcessor;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.gui.clickgui.ClickGUI;
import me.axua.impactplus.gui.settings.SettingsManager;
import me.axua.impactplus.hud.HudComponentManager;
import me.axua.impactplus.macro.MacroManager;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.util.CapeUtils;
import me.axua.impactplus.util.ConfigUtils;
import me.axua.impactplus.util.TpsUtils;
import me.axua.impactplus.util.Wrapper;
import me.axua.impactplus.util.font.CFontRenderer;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import java.awt.*;

@Mod(modid = "impactplus", name = "Impact+", version = "v2.4", clientSideOnly = true)
public class ImpactPlus {

    public static final String MODID = "impactplus";
    public static String MODNAME = "Impact+";
    public static final String VERSION = "v2.4";
    public static final String FORGENAME = "Impact+";

    public static final Logger log = LogManager.getLogger(MODNAME);
    public static final EventBus EVENT_BUS = (EventBus)new EventManager();

    public CapeUtils capeUtils;
    public static CFontRenderer fontRenderer;
    public ClickGUI clickGui;
    public SettingsManager settingsManager;
    public Friends friends;
    public ModuleManager moduleManager;
    EventProcessor eventProcessor;
    public MacroManager macroManager;
    public ConfigUtils configUtils;

    @Mod.Instance
    private static ImpactPlus INSTANCE;

    public ImpactPlus() {
        INSTANCE = this;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        this.eventProcessor = new EventProcessor();
        this.eventProcessor.init();
        TpsUtils tpsUtils = new TpsUtils();
        this.settingsManager = new SettingsManager();
        log.info("Settings initialized!");
        this.friends = new Friends();
        log.info("Friends initialized!");
        this.moduleManager = new ModuleManager();
        log.info("Modules initialized!");
        this.clickGui = new ClickGUI();
        HudComponentManager hudComponentManager = new HudComponentManager(0.0D, 0.0D, this.clickGui);
        log.info("ClickGUI initialized!");
        this.macroManager = new MacroManager();
        log.info("Macros initialized!");
        this.configUtils = new ConfigUtils();
        Runtime.getRuntime().addShutdownHook(new ShutDown());
        log.info("Config loaded!");
        CommandManager.initCommands();
        log.info("Commands initialized!");
        log.info("Initialization complete!\n");
        fontRenderer = new CFontRenderer(new Font("Arial", 0, 18), true, false);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Display.setTitle(MODNAME + " " + "v2.4");
        this.capeUtils = new CapeUtils();
        log.info("Capes initialised!");
        log.info("PostInitialization complete!\n");
    }

    public static ImpactPlus getInstance() {
        return INSTANCE;
    }
}
