package mod.teamcogs.c_cubic.register

import com.simibubi.create.AllItems
import com.simibubi.create.foundation.data.CreateRegistrate
import mod.TeamCogs.c_cubic.BuildConfig
import mod.teamcogs.c_cubic.C_Cubic
import mod.teamcogs.c_cubic.chain.ChainItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object ModItems {
    var itemGroup: CreativeModeTab = object : CreativeModeTab(BuildConfig.MODID) {
        override fun makeIcon(): ItemStack {
            return ItemStack(AllItems.WRENCH.get())
        }
    }

    fun register(registrate: CreateRegistrate) {
        registrate.creativeModeTab({ itemGroup }, BuildConfig.DISPLAY_NAME)
        registrate.item<ChainItem>("chain") { ChainItem(it) }.register()
    }
}
