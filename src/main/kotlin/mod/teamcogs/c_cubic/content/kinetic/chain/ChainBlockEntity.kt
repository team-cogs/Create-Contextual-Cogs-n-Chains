package mod.teamcogs.c_cubic.content.kinetic.chain

import com.simibubi.create.content.kinetics.base.KineticBlockEntity
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock
import com.simibubi.create.foundation.blockEntity.SyncedBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState

class ChainBlockEntity(type: BlockEntityType<*>, pos: BlockPos, state: BlockState):
    SyncedBlockEntity(type, pos, state),
    KineticBlockEntity(type, pos, state) {

}