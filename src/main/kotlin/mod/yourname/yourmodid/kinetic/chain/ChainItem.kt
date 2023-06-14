package mod.yourname.yourmodid.kinetic.chain

import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock
import com.simibubi.create.repack.registrate.util.nullness.NonNullFunction
import net.minecraft.nbt.NbtUtils
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext

class ChainItem(pProperties: Properties) : Item(pProperties) {
    override fun useOn(pContext: UseOnContext): InteractionResult {
        val clicked = pContext.clickedPos
        val level = pContext.level
        val player = pContext.player
        val block = level.getBlockState(clicked).block
        val tag = pContext.itemInHand.getOrCreateTag()
        if (block !is CogWheelBlock) {
            level.playSound(
                player,
                player!!.x,
                player.y,
                player.z,
                SoundEvents.AMETHYST_BLOCK_FALL,
                SoundSource.PLAYERS,
                0.2f,
                0.5f
            )
            return InteractionResult.FAIL
        }
        if (tag.contains("1")) {
            for (key in tag.allKeys) {
                if (key.matches(".*\\d.*".toRegex())) {
                    val currSel = NbtUtils.readBlockPos(tag.getCompound(key))
                    if (currSel == clicked) {
                        player!!.cooldowns.addCooldown(this, 20)
                        level.playSound(
                            player,
                            player.x,
                            player.y,
                            player.z,
                            SoundEvents.CHAIN_BREAK,
                            SoundSource.PLAYERS,
                            1.0f,
                            1.0f
                        )
                        tag.remove("First")
                        return InteractionResult.FAIL
                    }
                }
            }
            if (player!!.isShiftKeyDown) {
                val currSel = NbtUtils.readBlockPos(tag.getCompound("1"))
                println(currSel.toString() + "Is Connected to" + clicked)
                player.cooldowns.addCooldown(this, 10)
                level.playSound(
                    player,
                    player.x,
                    player.y,
                    player.z,
                    SoundEvents.CHAIN_PLACE,
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f
                )
                return InteractionResult.CONSUME
            }
            val last = tag.allKeys.size
            tag.put((last + 1).toString(), NbtUtils.writeBlockPos(clicked))
            pContext.itemInHand.tag = tag
            player.cooldowns.addCooldown(this, 10)
            level.playSound(
                player,
                player.x,
                player.y,
                player.z,
                SoundEvents.IRON_TRAPDOOR_OPEN,
                SoundSource.PLAYERS,
                1.0f,
                1.0f
            )
            return InteractionResult.SUCCESS
        }
        tag.put("1", NbtUtils.writeBlockPos(clicked))
        pContext.itemInHand.tag = tag
        player!!.cooldowns.addCooldown(this, 10)
        level.playSound(
            player,
            player.x,
            player.y,
            player.z,
            SoundEvents.IRON_TRAPDOOR_CLOSE,
            SoundSource.PLAYERS,
            1.0f,
            1.0f
        )
        return InteractionResult.SUCCESS
    }
}
