package org.kiratsuji.shatteredheroes.client.renderer;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import org.kiratsuji.shatteredheroes.Shatteredheroes;

public class MasterKimonoRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(Shatteredheroes.MODID,"geo/item/master_kimono.geo.json");
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Shatteredheroes.MODID,"textures/armor/master_kimono.png");

    public MasterKimonoRenderer() {
        super(AzArmorRendererConfig.builder(GEO, TEXTURE).build());
    }
}
