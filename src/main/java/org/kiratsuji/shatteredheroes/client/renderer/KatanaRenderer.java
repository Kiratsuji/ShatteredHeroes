package org.kiratsuji.shatteredheroes.client.renderer;

import mod.azure.azurelib.render.item.AzItemRenderer;
import mod.azure.azurelib.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;
import org.kiratsuji.shatteredheroes.Shatteredheroes;

public class KatanaRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            Shatteredheroes.MODID,
            "geo/item/katana.geo.json");
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(
            Shatteredheroes.MODID,
            "textures/item/katana.png");

    public KatanaRenderer() {super(AzItemRendererConfig.builder(GEO, TEXTURE).build());}
}
