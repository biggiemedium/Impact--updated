//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

package me.axua.impactplus.mixin.mixins;

import java.util.List;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.chat.BetterChat;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({GuiNewChat.class})
public abstract class MixinGuiNewChat {
  @Shadow
  private int scrollPos;
  
  @Shadow
  @Final
  private List<ChatLine> drawnChatLines;
  
  @Shadow
  public abstract int getLineCount();
  
  @Redirect(method = {"drawChat"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"))
  private void drawRectBackgroundClean(int left, int top, int right, int bottom, int color) {
    if (!ModuleManager.isModuleEnabled("BetterChat") || !((BetterChat)ModuleManager.getModuleByName("BetterChat")).clearBkg.getValBoolean())
      Gui.drawRect(left, top, right, bottom, color); 
  }
}
