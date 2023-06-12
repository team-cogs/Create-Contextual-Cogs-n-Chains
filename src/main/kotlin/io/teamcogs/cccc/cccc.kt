package io.teamcogs.cccc

import com.simibubi.create.foundation.data.CreateRegistrate
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.data.loading.DatagenModLoader
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.util.function.Consumer
import java.util.function.Supplier

@Mod(BuildConfig.MODID)
public class cccc {
    private val LOGGER: Logger = LogManager.getLogger(BuildConfig.MODID)
    var modEventBus: IEventBus? = null

    val registrate = CreateRegistrate.lazy(BuildConfig.MODID)

    fun CreateAddon() {
        modEventBus = MOD_CONTEXT.get().modEventBus
        val r = registrate.get()
        ModItems.register(r)
        ModBlocks.register(r)
        ModEntities.register(r)
        ModTiles.register(r)
        if (DatagenModLoader.isRunningDataGen()) {
            modEventBus.addListener<GatherDataEvent>(Consumer<GatherDataEvent> { g: GatherDataEvent? ->
                ModPonder.generateLang(
                    r,
                    g
                )
            })
        }
        modEventBus.addListener<FMLClientSetupEvent>(Consumer<FMLClientSetupEvent> { e: FMLClientSetupEvent? -> ModPonder.register() })
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
            Supplier<Runnable> { ModPartials::load })
        ModConfigs.register()
    }
}