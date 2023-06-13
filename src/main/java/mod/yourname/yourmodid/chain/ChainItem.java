package mod.yourname.yourmodid.chain;

import com.simibubi.create.content.contraptions.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.contraptions.relays.elementary.AbstractShaftBlock;
import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ChainItem extends Item {
    public ChainItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos clicked = pContext.getClickedPos();
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        Block block = level.getBlockState(clicked).getBlock();

        CompoundTag tag = pContext.getItemInHand().getOrCreateTag();
        BlockPos first = null;

        if (!(block instanceof CogWheelBlock)) {
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.AMETHYST_BLOCK_FALL, SoundSource.PLAYERS, 1.0F, 1.0F);
            return InteractionResult.FAIL;
        }

        if (tag.contains("First")) {
            first = NbtUtils.readBlockPos(tag.getCompound("First"));

            if  (first.equals(clicked)) {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.CHAIN_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
                tag.remove("First");
                return InteractionResult.FAIL;
            }
            System.out.println(first.toString() + "Is Connected to" + clicked);
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.CHAIN_PLACE, SoundSource.PLAYERS, 1.0F, 1.0F);
            return InteractionResult.CONSUME;
        }

        tag.put("First", NbtUtils.writeBlockPos(clicked));
        pContext.getItemInHand().setTag(tag);
        player.getCooldowns().addCooldown(this, 10);

        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.IRON_TRAPDOOR_CLOSE, SoundSource.PLAYERS, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }
}
