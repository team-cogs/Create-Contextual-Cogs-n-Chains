package mod.teamcogs.c_cubic

import com.simibubi.create.foundation.data.CreateRegistrate
import mod.TeamCogs.c_cubic.BuildConfig
import mod.teamcogs.c_cubic.register.*
import net.minecraftforge.data.loading.DatagenModLoader
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT

@Mod(BuildConfig.MODID)
object C_Cubic {
    var modEventBus: IEventBus? = null
    val registrate: CreateRegistrate = CreateRegistrate.create(BuildConfig.MODID)

    init {
        // TODO: Delete the tutorial and convert to kotlin for ponder
        modEventBus = MOD_CONTEXT.getKEventBus()
        ModItems.register(registrate)
        ModBlocks.register(registrate)
        ModEntities.register(registrate)
        ModTiles.register(registrate)

        if (DatagenModLoader.isRunningDataGen()) {
            modEventBus!!.addListener { g: GatherDataEvent? -> ModPonder.generateLang(registrate, g) }
        }

        modEventBus!!.addListener { e: FMLClientSetupEvent -> ModPonder.register() }
//        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) { ModPartials() }
    }
}