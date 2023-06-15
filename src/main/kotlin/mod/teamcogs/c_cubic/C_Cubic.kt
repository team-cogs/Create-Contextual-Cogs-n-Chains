package mod.teamcogs.c_cubic

import com.simibubi.create.foundation.data.CreateRegistrate
import com.tterrag.registrate.util.entry.ItemEntry
import mod.TeamCogs.c_cubic.BuildConfig
import mod.teamcogs.c_cubic.content.kinetic.chain.ChainItem
import mod.teamcogs.c_cubic.register.ModBlocks
import mod.teamcogs.c_cubic.register.ModEntities
import mod.teamcogs.c_cubic.register.ModItems
import mod.teamcogs.c_cubic.register.ModTiles
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager

// TODO: rename this class! and package name! package name should be mod.yourname.modid, see import of BuildConfig class
@Mod(BuildConfig.MODID)
class C_Cubic {
    companion object {
        // Directly reference a log4j logger.
        private val LOGGER = LogManager.getLogger(BuildConfig.MODID)
        var modEventBus: IEventBus? = null
        val registrate: CreateRegistrate = CreateRegistrate.create(BuildConfig.MODID)
        var CHAIN_ITEM: ItemEntry<ChainItem>? = null
    }

    init {
        // TODO: Delete the tutorial and convert to kotlin for ponder
        //modEventBus = FMLJavaModLoadingContext.get().getModEventBus(BuildConfig.MODID);
        ModItems.register(registrate)
        ModBlocks.register(registrate)
        ModEntities.register(registrate)
        ModTiles.register(registrate)
        CHAIN_ITEM = registrate.item<ChainItem>("chain") { ChainItem(it) }.register()

//		if (DatagenModLoader.isRunningDataGen()) {
//			modEventBus.addListener((GatherDataEvent g) -> ModPonder.generateLang(r, g));
//		}
//		modEventBus.addListener((FMLClientSetupEvent e) -> ModPonder.register());
//		DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
//				() -> ModPartials::load);
//		ModConfigs.register();
    }
}