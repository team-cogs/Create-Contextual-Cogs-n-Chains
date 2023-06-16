package mod.teamcogs.c_cubic.pipecap

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.DirectionalBlock
import net.minecraft.world.level.block.state.BlockState

class PipeCapBlock(p_52591_: Properties) : DirectionalBlock(p_52591_) {
    override fun canConnectRedstone(state: BlockState?, level: BlockGetter?, pos: BlockPos?, direction: Direction?): Boolean {
        return false
    }
}