package juuxel.gamemodeswitcher.mixin;

import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.mob.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mob.class)
abstract class MobMixin {
    @Redirect(method = {"die", "hurt"}, at = @At(value = "FIELD", target = "Lcom/mojang/minecraft/level/Level;creativeMode:Z"))
    private boolean isCreativeMode(Level level) {
        return false;
    }
}
