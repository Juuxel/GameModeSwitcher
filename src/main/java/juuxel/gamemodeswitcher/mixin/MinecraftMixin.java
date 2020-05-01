package juuxel.gamemodeswitcher.mixin;

import com.mojang.minecraft.Minecraft;
import juuxel.gamemodeswitcher.GameModeSwitcher;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
abstract class MinecraftMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;getEventKey()I", ordinal = 4))
    private int onGetEventKey() {
        int result = Keyboard.getEventKey();
        if (result == 50) {
            GameModeSwitcher.INSTANCE.cycle((Minecraft) (Object) this);
        }
        return result;
    }
}
