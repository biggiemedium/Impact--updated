//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.text.DecimalFormat;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.gui.clickgui.ClickGUI;
import me.axua.impactplus.gui.clickgui.Panel;
import me.axua.impactplus.gui.clickgui.util.ColorUtil;
import me.axua.impactplus.gui.clickgui.util.FontUtil;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.components2.Bps;
import me.axua.impactplus.util.Rainbow;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.math.MathHelper;

public class BpsComponent extends Panel {
  Bps mod;
  
  Color c;
  
  boolean font;
  
  Color text;
  
  Color color;
  
  final DecimalFormat df;
  
  public BpsComponent(double ix, double iy, ClickGUI parent) {
    super("BPS", ix, iy, 10.0D, 10.0D, false, parent);
    this.mod = (Bps)ModuleManager.getModuleByName("BPS");
    this.df = new DecimalFormat("0.0");
    this.isHudComponent = true;
    this.isHudComponentPinned = true;
  }
  
  public void drawHud() {
    doStuff();
    ChatFormatting numbercf = null;
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("None"))
      numbercf = ChatFormatting.RESET; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("White"))
      numbercf = ChatFormatting.WHITE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Black"))
      numbercf = ChatFormatting.BLACK; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Gray"))
      numbercf = ChatFormatting.GRAY; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Gray"))
      numbercf = ChatFormatting.DARK_GRAY; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Aqua"))
      numbercf = ChatFormatting.AQUA; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Aqua"))
      numbercf = ChatFormatting.DARK_AQUA; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Blue"))
      numbercf = ChatFormatting.BLUE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Blue"))
      numbercf = ChatFormatting.DARK_BLUE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Green"))
      numbercf = ChatFormatting.GREEN; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Green"))
      numbercf = ChatFormatting.DARK_GREEN; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Light Purple"))
      numbercf = ChatFormatting.LIGHT_PURPLE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Purple"))
      numbercf = ChatFormatting.DARK_PURPLE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Red"))
      numbercf = ChatFormatting.RED; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Red"))
      numbercf = ChatFormatting.DARK_RED; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Yellow"))
      numbercf = ChatFormatting.YELLOW; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Gold"))
      numbercf = ChatFormatting.GOLD; 
    double deltaX = mc.player.posX - mc.player.prevPosX;
    double deltaZ = mc.player.posZ - mc.player.prevPosZ;
    float tickRate = mc.timer.tickLength / 1000.0F;
    String bps = "BPS " + numbercf + this.df.format((MathHelper.sqrt(deltaX * deltaX + deltaZ * deltaZ) / tickRate));
    float hi = ImpactPlus.fontRenderer.getStringWidth(bps);
    float hi2 = mc.fontRenderer.getStringWidth(bps);
    if (this.mod.right.getValBoolean()) {
      if (this.font) {
        ImpactPlus.fontRenderer.drawStringWithShadow(bps, (float)this.x - hi, (float)this.y, this.text.getRGB());
      } else {
        mc.fontRenderer.drawStringWithShadow(bps, (float)this.x - hi2, (float)this.y, this.text.getRGB());
      } 
    } else if (this.font) {
      ImpactPlus.fontRenderer.drawStringWithShadow(bps, (float)this.x, (float)this.y, this.text.getRGB());
    } else {
      mc.fontRenderer.drawStringWithShadow(bps, (float)this.x, (float)this.y, this.text.getRGB());
    } 
  }
  
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    doStuff();
    ChatFormatting numbercf = null;
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("None"))
      numbercf = ChatFormatting.RESET; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("White"))
      numbercf = ChatFormatting.WHITE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Black"))
      numbercf = ChatFormatting.BLACK; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Gray"))
      numbercf = ChatFormatting.GRAY; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Gray"))
      numbercf = ChatFormatting.DARK_GRAY; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Aqua"))
      numbercf = ChatFormatting.AQUA; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Aqua"))
      numbercf = ChatFormatting.DARK_AQUA; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Blue"))
      numbercf = ChatFormatting.BLUE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Blue"))
      numbercf = ChatFormatting.DARK_BLUE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Green"))
      numbercf = ChatFormatting.GREEN; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Green"))
      numbercf = ChatFormatting.DARK_GREEN; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Light Purple"))
      numbercf = ChatFormatting.LIGHT_PURPLE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Purple"))
      numbercf = ChatFormatting.DARK_PURPLE; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Red"))
      numbercf = ChatFormatting.RED; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Dark Red"))
      numbercf = ChatFormatting.DARK_RED; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Yellow"))
      numbercf = ChatFormatting.YELLOW; 
    if (this.mod.numbercolour.getValString().equalsIgnoreCase("Gold"))
      numbercf = ChatFormatting.GOLD; 
    double deltaX = mc.player.posX - mc.player.prevPosX;
    double deltaZ = mc.player.posZ - mc.player.prevPosZ;
    float tickRate = mc.timer.tickLength / 1000.0F;
    String bps = "BPS " + numbercf + this.df.format((MathHelper.sqrt(deltaX * deltaX + deltaZ * deltaZ) / tickRate));
    double w = (mc.fontRenderer.getStringWidth(bps) + 2);
    this.c = new Color(50, 50, 50, 100);
    if (this.isHudComponentPinned)
      this.c = new Color(ColorUtil.getClickGUIColor().darker().getRed(), ColorUtil.getClickGUIColor().darker().getGreen(), ColorUtil.getClickGUIColor().darker().getBlue(), 100); 
    if (this.dragging) {
      this.x = this.x2 + mouseX;
      this.y = this.y2 + mouseY;
    } 
    this.width = w;
    this.height = (FontUtil.getFontHeight() + 2);
    Gui.drawRect((int)this.x, (int)this.y, (int)this.x + (int)this.width, (int)this.y + (int)this.height, this.c.getRGB());
    ImpactPlus.fontRenderer.drawStringWithShadow(this.title, (int)this.x, ((int)(this.y + this.height / 2.0D - (FontUtil.getFontHeight() / 2.0F)) - 2), -1);
    if (this.extended) {
      double startY = this.y + this.height;
      Gui.drawRect((int)this.x, (int)startY, (int)this.x + (int)this.width, (int)startY + (int)this.height, this.c.getRGB());
      float hi = ImpactPlus.fontRenderer.getStringWidth(bps);
      float hi2 = mc.fontRenderer.getStringWidth(bps);
      if (this.mod.right.getValBoolean()) {
        if (this.font) {
          ImpactPlus.fontRenderer.drawStringWithShadow(bps, (float)this.x - hi, (float)this.y + 10.0F, this.text.getRGB());
        } else {
          mc.fontRenderer.drawStringWithShadow(bps, (float)this.x - hi2, (float)this.y + 10.0F, this.text.getRGB());
        } 
      } else if (this.font) {
        ImpactPlus.fontRenderer.drawStringWithShadow(bps, (float)this.x, (float)this.y + 10.0F, this.text.getRGB());
      } else {
        mc.fontRenderer.drawStringWithShadow(bps, (float)this.x, (float)this.y + 10.0F, this.text.getRGB());
      } 
    } 
  }
  
  private void doStuff() {
    this.color = new Color(this.mod.red.getValInt(), this.mod.green.getValInt(), this.mod.blue.getValInt());
    this.text = this.mod.rainbow.getValBoolean() ? Rainbow.getColor() : this.color;
    this.font = this.mod.fontRenderer.getValBoolean();
  }
}
