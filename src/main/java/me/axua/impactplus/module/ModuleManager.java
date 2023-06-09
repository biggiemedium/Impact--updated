//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

package me.axua.impactplus.module;

import java.util.ArrayList;
import java.util.stream.Collectors;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.modules.Client.CleanGUI;
import me.axua.impactplus.module.modules.chat.*;
//import me.axua.impactplus.module.modules.combat.*;
import me.axua.impactplus.module.modules.combat.AutoTrap;
import me.axua.impactplus.module.modules.combat.FastBow;
import me.axua.impactplus.module.modules.combat.SmartOffhand;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.module.modules.components1.ArmorHUD;
import me.axua.impactplus.module.modules.components1.Closest;
import me.axua.impactplus.module.modules.components1.Coords;
import me.axua.impactplus.module.modules.components1.Crystals;
import me.axua.impactplus.module.modules.components1.CurrentHole;
import me.axua.impactplus.module.modules.components1.Direction;
import me.axua.impactplus.module.modules.components1.DubCount;
import me.axua.impactplus.module.modules.components1.Entitys;
import me.axua.impactplus.module.modules.components1.Exp;
import me.axua.impactplus.module.modules.components1.Gapples;
import me.axua.impactplus.module.modules.components1.Inventory;
import me.axua.impactplus.module.modules.components1.ModList;
import me.axua.impactplus.module.modules.components1.PlayerPreview;
import me.axua.impactplus.module.modules.components1.PotionEffects;
import me.axua.impactplus.module.modules.components1.PvpInfo;
import me.axua.impactplus.module.modules.components1.TextRadar;
import me.axua.impactplus.module.modules.components1.TheDate;
import me.axua.impactplus.module.modules.components1.Time;
import me.axua.impactplus.module.modules.components1.Totems;
import me.axua.impactplus.module.modules.components2.Biome;
import me.axua.impactplus.module.modules.components2.Bps;
import me.axua.impactplus.module.modules.components2.Dimension;
import me.axua.impactplus.module.modules.components2.Durability;
import me.axua.impactplus.module.modules.components2.Fps;
import me.axua.impactplus.module.modules.components2.Gamemode;
import me.axua.impactplus.module.modules.components2.Ping;
import me.axua.impactplus.module.modules.components2.PlayerCount;
import me.axua.impactplus.module.modules.components2.ServerIp;
import me.axua.impactplus.module.modules.components2.Tps;
import me.axua.impactplus.module.modules.components2.Watermark;
import me.axua.impactplus.module.modules.components2.WelcomerGui;
import me.axua.impactplus.module.modules.misc.*;
import me.axua.impactplus.module.modules.movement.*;
import me.axua.impactplus.module.modules.player.*;
import me.axua.impactplus.module.modules.render.*;
import me.axua.impactplus.util.ImpactPlusTessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ModuleManager {
  public static ArrayList<Module> modules;
  
  public ModuleManager() {
    modules = new ArrayList<>();
    addMod((Module)new AutoTrap());
    addMod((Module)new FastBow());
    addMod((Module)new SmartOffhand());
    addMod((Module)new Surround());
    addMod((Module)new ElytraSwap());
    addMod((Module)new FakeGamemode());
    addMod((Module)new FastUse());
    addMod((Module)new AutoWalk());
    addMod((Module)new AutoNomadHut());
    addMod((Module)new BreakTweaks());
    addMod((Module)new CopyIp());
    addMod((Module)new MiddleClickFriends());
    addMod((Module)new Notifications());
    addMod((Module)new RpcModule());
    addMod((Module)new AutoEZ());
    addMod((Module)new AutoReply());
    addMod((Module)new BetterChat());
    addMod((Module)new ChatSuffix());
    addMod((Module)new ChatTimeStamps());
    addMod((Module)new ToggleMsgs());
    addMod((Module)new VisualRange());
    addMod((Module)new Welcomer());
    addMod((Module)new BlockHighlight());
    addMod((Module)new BlockHighlight2());
    addMod((Module)new CapesModule());
    addMod((Module)new CleanGui());
    addMod((Module)new CsgoESP());
    addMod((Module)new FovModule());
    addMod((Module)new HoleESP());
    addMod((Module)new NoRender());
    addMod((Module)new ShulkerPreview());
    addMod(new CleanGUI());
    addMod((Module)new ArmorHUD());
    addMod((Module)new Closest());
    addMod((Module)new Coords());
    addMod((Module)new Crystals());
    addMod((Module)new CurrentHole());
    addMod((Module)new Direction());
    addMod((Module)new DubCount());
    addMod((Module)new Entitys());
    addMod((Module)new Exp());
    addMod((Module)new Gapples());
    addMod((Module)new Inventory());
    addMod((Module)new ModList());
    addMod((Module)new PlayerPreview());
    addMod((Module)new TextRadar());
    addMod((Module)new PotionEffects());
    addMod((Module)new PvpInfo());
    addMod((Module)new TheDate());
    addMod((Module)new Time());
    addMod((Module)new Totems());
    addMod((Module)new Biome());
    addMod((Module)new Bps());
    addMod((Module)new Dimension());
    addMod((Module)new Durability());
    addMod((Module)new Fps());
    addMod((Module)new Gamemode());
    addMod((Module)new Ping());
    addMod((Module)new PlayerCount());
    addMod((Module)new ServerIp());
    addMod((Module)new Tps());
    addMod((Module)new Watermark());
    addMod((Module)new WelcomerGui());
  }
  
  public static void addMod(Module m) {
    modules.add(m);
  }

  public Module getModule(final Class<? extends Module> clazz) {
    return ModuleManager.modules.stream().filter(module -> module.getClass() == clazz).findFirst().orElse(null);
  }
  
  public static void onUpdate() {
    modules.stream().filter(Module::isEnabled).forEach(Module::onUpdate);
  }
  
  public static void onRender() {
    modules.stream().filter(Module::isEnabled).forEach(Module::onRender);
  }
  
  public static void onWorldRender(RenderWorldLastEvent event) {
    (Minecraft.getMinecraft()).mcProfiler.startSection("osiris");
    (Minecraft.getMinecraft()).mcProfiler.startSection("setup");
    GlStateManager.disableTexture2D();
    GlStateManager.enableBlend();
    GlStateManager.disableAlpha();
    GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
    GlStateManager.shadeModel(7425);
    GlStateManager.disableDepth();
    GlStateManager.glLineWidth(1.0F);
    Vec3d renderPos = getInterpolatedPos((Entity)(Minecraft.getMinecraft()).player, event.getPartialTicks());
    RenderEvent e = new RenderEvent((Tessellator)ImpactPlusTessellator.INSTANCE, renderPos, event.getPartialTicks());
    e.resetTranslation();
    (Minecraft.getMinecraft()).mcProfiler.endSection();
    modules.stream().filter(module -> module.isEnabled()).forEach(module -> {
          (Minecraft.getMinecraft()).mcProfiler.startSection(module.getName());
          module.onWorldRender(e);
          (Minecraft.getMinecraft()).mcProfiler.endSection();
        });
    (Minecraft.getMinecraft()).mcProfiler.startSection("release");
    GlStateManager.glLineWidth(1.0F);
    GlStateManager.shadeModel(7424);
    GlStateManager.disableBlend();
    GlStateManager.enableAlpha();
    GlStateManager.enableTexture2D();
    GlStateManager.enableDepth();
    GlStateManager.enableCull();
    ImpactPlusTessellator.releaseGL();
    (Minecraft.getMinecraft()).mcProfiler.endSection();
    (Minecraft.getMinecraft()).mcProfiler.endSection();
  }

  public static Vec3d getInterpolatedPos(Entity entity, float ticks) {
    return (new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ)).add(getInterpolatedAmount(entity, ticks));
  }

  public static Vec3d getInterpolatedAmount(Entity entity, double ticks) {
    return getInterpolatedAmount(entity, ticks, ticks, ticks);
  }

  public static Vec3d getInterpolatedAmount(Entity entity, double x, double y, double z) {
    return new Vec3d((entity.posX - entity.lastTickPosX) * x, (entity.posY - entity.lastTickPosY) * y, (entity.posZ - entity.lastTickPosZ) * z);
  }
  
  public static ArrayList<Module> getModules() {
    return modules;
  }
  
  public static ArrayList<Module> getModulesInCategory(Module.Category c) {
    ArrayList<Module> list = (ArrayList<Module>)getModules().stream().filter(m -> m.getCategory().equals(c)).collect(Collectors.toList());
    return list;
  }
  
  public static void onBind(int key) {
    if (key == 0 || key == 0)
      return; 
    modules.forEach(module -> {
          if (module.getBind() == key)
            module.toggle(); 
        });
  }
  
  public static Module getModuleByName(String name) {
    Module m = getModules().stream().filter(mm -> mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    return m;
  }
  
  public static boolean isModuleEnabled(String name) {
    Module m = getModules().stream().filter(mm -> mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    return (m != null && m.isEnabled());
  }
  
  public static boolean isModuleEnabled(Module m) {
    return m.isEnabled();
  }
}
