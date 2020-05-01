package juuxel.gamemodeswitcher.mixin;

import com.mojang.minecraft.gamemode.GameMode;
import com.mojang.minecraft.gamemode.SurvivalMode;
import com.mojang.minecraft.gui.CreativeBuildScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SurvivalMode.class)
abstract class SurvivalModeMixin extends GameMode {
    private SurvivalModeMixin() {
        super(null);
    }

    @Override
    public void method_298() {
        minecraft.openScreen(new CreativeBuildScreen());
    }
}
