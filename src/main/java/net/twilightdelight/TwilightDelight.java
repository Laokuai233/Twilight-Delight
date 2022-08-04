package net.twilightdelight;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.twilightdelight.init.BlockInit;
import net.twilightdelight.init.BlockTileEntityInit;
import net.twilightdelight.init.ItemInit;
import net.twilightdelight.init.MobEffectInit;
import org.slf4j.Logger;

/**
 * @author Goulixiaoji
 */
@Mod(TwilightDelight.MOD_ID)
public class TwilightDelight {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "twilightdelight";
    public static final CreativeModeTab TAB_TWILIGHTDELIGHT = new CreativeModeTab("tab.twilightdelight") {
        @Override
        public ItemStack makeIcon() {
            Item iconItem = ItemInit.MAZE_STOVE.get();
            return new ItemStack(iconItem);
        }
    };

    public TwilightDelight() {
        MinecraftForge.EVENT_BUS.register(this);
        this.init(FMLJavaModLoadingContext.get().getModEventBus());
    }

    protected void init(IEventBus modBus){
        MobEffectInit.REGISTER.register(modBus);
        ItemInit.REGISTER.register(modBus);
        BlockInit.REGISTER.register(modBus);
        BlockTileEntityInit.REGISTER.register(modBus);
    }

}
