package mod.teamcogs.c_cubic.register

import com.simibubi.create.foundation.data.CreateRegistrate
import mod.teamcogs.c_cubic.pipecap.PipeCapBlock

object ModBlocks {
    fun register(registrate: CreateRegistrate?) {
        registrate!!.block<PipeCapBlock>("pipe_cap") { PipeCapBlock(it) }.simpleItem().register()
    }
}
