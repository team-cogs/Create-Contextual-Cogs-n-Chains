package mod.yourname.yourmodid

import com.simibubi.create.foundation.data.CreateRegistrate
import com.simibubi.create.repack.registrate.util.entry.ItemEntry
import com.simibubi.create.repack.registrate.util.nullness.NonNullSupplier
import mod.yourname.yourmodid.kinetic.chain.ChainItem
import mod.yourname.yourmodid.register.ModBlocks
import mod.yourname.yourmodid.register.ModEntities
import mod.yourname.yourmodid.register.ModItems
import mod.yourname.yourmodid.register.ModTiles
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager


// TODO: rename this class! and package name! package name should be mod.yourname.modid, see import of BuildConfig class
@Mod(BuildConfig.MODID)
class CreateAddon {
    val registrate = CreateRegistrate.lazy(BuildConfig.MODID)

    var CHAIN_ITEM: ItemEntry<ChainItem>? = null

    init {
        // TODO: Delete the tutorial and convert to kotlin
        //modEventBus = FMLJavaModLoadingContext.get().getModEventBus(BuildConfig.MODID);
        val r: CreateRegistrate = registrate.get()
        ModItems.register(r)
        ModBlocks.register(r)
        ModEntities.register(r)
        ModTiles.register(r)
        CHAIN_ITEM = r.item<ChainItem>("Chain") { ChainItem(it) }.register()

//		if (DatagenModLoader.isRunningDataGen()) {
//			modEventBus.addListener((GatherDataEvent g) -> ModPonder.generateLang(r, g));
//		}
//		modEventBus.addListener((FMLClientSetupEvent e) -> ModPonder.register());
//		DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
//				() -> ModPartials::load);
//		ModConfigs.register();
    }

    companion object {
        // Directly reference a log4j logger.
        private val LOGGER = LogManager.getLogger(BuildConfig.MODID)
        var modEventBus: IEventBus? = null
        @JvmField
		val registrate: NonNullSupplier<CreateRegistrate> = CreateRegistrate.lazy(BuildConfig.MODID)
        @JvmField
		var CHAIN_ITEM: ItemEntry<ChainItem>? = null
    }
}
