package me.axua.impactplus.module.modules.Client;

import me.axua.impactplus.module.Module;
import org.lwjgl.input.Keyboard;

public class NewGUI extends Module {

    public NewGUI INSTANCE;

    public NewGUI() {
        super("ClickGuiModule", Module.Category.RENDER);
        setBind(Keyboard.KEY_RSHIFT);
        this.INSTANCE = this;
    }

}
