package net.twilightdelight.init.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.twilightdelight.client.renderer.MazeStoveRenderer;
import net.twilightdelight.init.BlockTileEntityInit;

/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ClientEventInit {
    @SubscribeEvent
    public static void onClientEvent(FMLClientSetupEvent event){
        event.enqueueWork(()-> {
            MazeStoveRenderer.init(BlockTileEntityInit.MAZE_STOVE_TILEENTITY.get());
        });
    }

}
