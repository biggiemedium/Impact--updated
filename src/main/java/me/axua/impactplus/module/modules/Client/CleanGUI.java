package me.axua.impactplus.module.modules.Client;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.gui.clickgui.ClickGUI;
import me.axua.impactplus.gui.settings.Setting;
import me.axua.impactplus.module.Module;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class CleanGUI extends Module {

    public CleanGUI INSTANCE;

    public CleanGUI() {
        super("CleanGui", Module.Category.RENDER);
        setBind(Keyboard.KEY_RSHIFT);
        this.INSTANCE = this;
    }

    public Setting textmode;

    public void setup() {
        ArrayList<String> textmodes = new ArrayList<>();
        textmodes.add("Left");
        textmodes.add("Middle");
        ArrayList<String> styles = new ArrayList<>();
        styles.add("Old");
        styles.add("New");
        styles.add("WeepCraft");
        (ImpactPlus.getInstance()).settingsManager.rSetting(new Setting("Red", this, 68.0D, 0.0D, 255.0D, true, "ClickGuiRed"));
        (ImpactPlus.getInstance()).settingsManager.rSetting(new Setting("Green", this, 68.0D, 0.0D, 255.0D, true, "ClickGuiGreen"));
        (ImpactPlus.getInstance()).settingsManager.rSetting(new Setting("Blue", this, 255.0D, 0.0D, 255.0D, true, "ClickGuiBlue"));
        (ImpactPlus.getInstance()).settingsManager.rSetting(new Setting("Rainbow", this, true, "ClickGuiRainbow"));
        rSetting(new Setting("Tooltips", this, true, "ClickGuiTooltips"));
        rSetting(new Setting("Style", this, "New", styles, "ClickGuiStyle"));
        rSetting(new Setting("Text Align", this, "Left", textmodes, "ClickGuiTextMode"));
    }

    public void onEnable() {
        if(ImpactPlus.getInstance().clickGui != null) {
            mc.displayGuiScreen(ImpactPlus.getInstance().clickGui);
            disable();
        }
    }
}
