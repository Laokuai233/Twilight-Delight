package net.twilightdelight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import net.twilightdelight.common.tileentity.MazeStoveTileEntity;

/**
 * @author Goulixiaoji
 */
@OnlyIn(Dist.CLIENT)
public class MazeStoveRenderer implements BlockEntityRenderer<MazeStoveTileEntity> {

    public static void init(BlockEntityType<? extends MazeStoveTileEntity> tileentityType){
        BlockEntityRenderers.register(tileentityType, MazeStoveRenderer::new);
    }

    protected MazeStoveRenderer(BlockEntityRendererProvider.Context context){
        super();
    }


    @Override
    public void render(MazeStoveTileEntity stoveEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
        Direction direction = ((Direction)stoveEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING)).getOpposite();
        ItemStackHandler inventory = stoveEntity.getInventory();
        int posLong = (int)stoveEntity.getBlockPos().asLong();

        for(int i = 0; i < inventory.getSlots(); ++i) {
            ItemStack stoveStack = inventory.getStackInSlot(i);
            if (!stoveStack.isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5D, 1.02D, 0.5D);
                float f = -direction.toYRot();
                poseStack.mulPose(Vector3f.YP.rotationDegrees(f));
                poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                Vec2 itemOffset = stoveEntity.getStoveItemOffset(i);
                poseStack.translate((double)itemOffset.x, (double)itemOffset.y, 0.0D);
                poseStack.scale(0.375F, 0.375F, 0.375F);
                if (stoveEntity.getLevel() != null) {
                    Minecraft.getInstance().getItemRenderer().renderStatic(stoveStack, ItemTransforms.TransformType.FIXED, LevelRenderer.getLightColor(stoveEntity.getLevel(), stoveEntity.getBlockPos().above()), combinedOverlayIn, poseStack, buffer, posLong + i);
                }

                poseStack.popPose();
            }
        }
    }
}
