package me.axua.impactplus.module.modules.components2;

import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.gui.settings.Setting;
import me.axua.impactplus.module.Module;

public class Fps extends Module {
  public Setting red;
  
  public Setting green;
  
  public Setting blue;
  
  public Setting rainbow;
  
  public Setting fontRenderer;
  
  public Setting color;
  
  public Setting right;
  
  public Setting numbercolour;
  
  public Fps() {
    super("FPS", Module.Category.COMPONENTS2);
    setDrawn(true);
  }
  
  public void setup() {
    ArrayList<String> numbercolours = new ArrayList<>();
    numbercolours.add("None");
    numbercolours.add("White");
    numbercolours.add("Black");
    numbercolours.add("Gray");
    numbercolours.add("Dark Gray");
    numbercolours.add("Aqua");
    numbercolours.add("Dark Aqua");
    numbercolours.add("Blue");
    numbercolours.add("Dark Blue");
    numbercolours.add("Green");
    numbercolours.add("Dark Green");
    numbercolours.add("Light Purple");
    numbercolours.add("Dark Purple");
    numbercolours.add("Red");
    numbercolours.add("Dark Red");
    numbercolours.add("Yellow");
    numbercolours.add("Gold");
    this.red = new Setting("Red", this, 80.0D, 0.0D, 255.0D, true, "FpsRed");
    this.green = new Setting("Green", this, 80.0D, 0.0D, 255.0D, true, "FpsGreen");
    this.blue = new Setting("Blue", this, 255.0D, 0.0D, 255.0D, true, "FpsBlue");
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.red);
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.green);
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.blue);
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.rainbow = new Setting("Rainbow", this, true, "FpsRainbow"));
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.fontRenderer = new Setting("Custom Font", this, true, "FpsfontRenderer"));
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.right = new Setting("AlignRight", this, false, "FpsRight"));
    (ImpactPlus.getInstance()).settingsManager.rSetting(this.numbercolour = new Setting("Number Colour", this, "White", numbercolours, "FpsNumberColour"));
  }
  
  public void onEnable() {

  }
}
