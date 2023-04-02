//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

package me.axua.impactplus.util;

import me.axua.impactplus.ImpactPlus;
import net.minecraft.client.Minecraft;

public class FontUtils {
  private static final Minecraft mc = Minecraft.getMinecraft();
  
  public static float drawStringWithShadow(boolean fontRenderer, String text, int x, int y, int color) {
    if (fontRenderer)
      return ImpactPlus.fontRenderer.drawStringWithShadow(text, x, y, color); 
    return mc.fontRenderer.drawStringWithShadow(text, x, y, color);
  }
  
  public static int getStringWidth(boolean fontRenderer, String str) {
    if (fontRenderer)
      return ImpactPlus.fontRenderer.getStringWidth(str); 
    return mc.fontRenderer.getStringWidth(str);
  }
  
  public static int getFontHeight(boolean fontRenderer) {
    if (fontRenderer)
      return ImpactPlus.fontRenderer.getHeight(); 
    return mc.fontRenderer.FONT_HEIGHT;
  }
}
