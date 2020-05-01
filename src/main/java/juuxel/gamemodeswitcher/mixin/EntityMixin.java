package juuxel.gamemodeswitcher.mixin;

import com.mojang.minecraft.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
abstract class EntityMixin {
    @Inject(method = "isCreativeModeAllowed", at = @At("HEAD"), cancellable = true)
    private void onIsCreativeModeAllowed(CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(true);
    }
}
