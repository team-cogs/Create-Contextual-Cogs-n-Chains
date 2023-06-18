package mod.teamcogs.c_cubic.content.kinetic.gearbox

import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.block.state.BlockState

class AdjustableGearboxBlock(properties: Properties) : RotatedPillarKineticBlock(properties) {
    override fun getStateForPlacement(context: BlockPlaceContext): BlockState {
        return defaultBlockState().setValue(AXIS, Direction.Axis.Y)
    }

    /* IRotate */

    override fun getRotationAxis(state: BlockState): Direction.Axis {
        return state.getValue(AXIS)
    }

    // TODO: BLOCKENTITY
}