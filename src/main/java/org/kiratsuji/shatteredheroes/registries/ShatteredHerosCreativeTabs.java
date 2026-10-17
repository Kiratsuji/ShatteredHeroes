package org.kiratsuji.shatteredheroes.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.kiratsuji.shatteredheroes.Shatteredheroes;

public class ShatteredHerosCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Shatteredheroes.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB =CREATIVE_TABS.register("main_tab",
            ()-> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(Items.NETHER_STAR))
                    .title(Component.translatable("creativetab.main_tab"))
                    .displayItems((pParameters, p0output)->{
                        p0output.accept(ShatteredHeroesItems.KATANA.get());
                    })
                    .build());

    public static void register(IEventBus bus){CREATIVE_TABS.register(bus);}
}
