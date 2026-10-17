package org.kiratsuji.shatteredheroes.events.client;


import mod.azure.azurelib.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.render.item.AzItemRendererRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.client.renderer.KatanaRenderer;
import org.kiratsuji.shatteredheroes.client.renderer.MasterKimonoRenderer;
import org.kiratsuji.shatteredheroes.client.renderer.DojoMasterRenderer;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesEntities;
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

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DojoMasterRenderer.DOJO_MASTER_LAYER,
                () -> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0), 64, 64));
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ShatteredHeroesEntities.DOJO_MASTER.get(), DojoMasterRenderer::new);
    }
}