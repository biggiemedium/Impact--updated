package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.module.ModuleManager;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({BlockSoulSand.class})
public class MixinBlockSoulSand {

  @Inject(method = {"onEntityCollidedWithBlock"}, at = {@At("HEAD")}, cancellable = true)
  public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn, CallbackInfo info) {
    if (ModuleManager.isModuleEnabled("NoSlow"))
      info.cancel(); 
  }
}
