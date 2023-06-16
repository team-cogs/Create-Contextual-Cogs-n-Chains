package mod.teamcogs.c_cubic.register

import com.simibubi.create.foundation.data.CreateRegistrate
import com.simibubi.create.foundation.ponder.PonderLocalization
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent

object ModPonder {
    fun register() {
        // Put your ponder here!
    }

    fun generateLang(registrate: CreateRegistrate?, event: GatherDataEvent?) {
        register()
        PonderLocalization.provideRegistrateLang(registrate)
    }
}
