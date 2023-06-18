package mod.teamcogs.c_cubic.content.kinetic.gearbox

import com.simibubi.create.content.kinetics.base.DirectionalShaftHalvesBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class AdjustableGearboxBlockEntity(type: BlockEntityType<*>?, pos: BlockPos?, state: BlockState?) :
    DirectionalShaftHalvesBlockEntity(type, pos, state) {
    override fun isNoisy(): Boolean { return false }
}