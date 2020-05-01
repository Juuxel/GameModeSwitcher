package juuxel.gamemodeswitcher

import com.mojang.minecraft.Minecraft
import com.mojang.minecraft.gamemode.CreativeMode
import com.mojang.minecraft.gamemode.GameMode
import com.mojang.minecraft.gamemode.SurvivalMode
import net.fabricmc.api.ModInitializer

object GameModeSwitcher : ModInitializer {
    private lateinit var creative: GameMode
    private lateinit var survival: GameMode

    override fun onInitialize() {
        // TODO: Add Minecraft and scaled[Width/Height] to HudRenderCallback
    }

    fun cycle(minecraft: Minecraft) {
        if (minecraft.gameMode is CreativeMode) {
            creative = minecraft.gameMode
            if (!::survival.isInitialized) {
                survival = SurvivalMode::class.java.constructors.first().newInstance(minecraft) as SurvivalMode
            }
            minecraft.gameMode = survival
            minecraft.gameMode.method_308(minecraft.level)
        } else {
            minecraft.gameMode = creative
        }
        minecraft.gameMode.applyTo(minecraft.level)
        minecraft.hud.addMessage("Game mode changed")
    }
}
