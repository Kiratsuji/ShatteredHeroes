package org.kiratsuji.shatteredheroes.events.client;


import mod.azure.azurelib.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.render.item.AzItemRendererRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.item.KatanaRenderer;
import org.kiratsuji.shatteredheroes.item.MasterKimonoRenderer;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesItems;

@Mod.EventBusSubscriber(modid = Shatteredheroes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){

        AzItemRendererRegistry.register(KatanaRenderer::new, ShatteredHeroesItems.KATANA.get());

        event.enqueueWork(()-> AzArmorRendererRegistry.register(
                MasterKimonoRenderer::new,
                ShatteredHeroesItems.RONIN_HAT.get(),
                ShatteredHeroesItems.MASTER_KIMONO.get(),
                ShatteredHeroesItems.BLACK_HAKAMA.get(),
                ShatteredHeroesItems.SANDALS.get()
        ));
    }
}
