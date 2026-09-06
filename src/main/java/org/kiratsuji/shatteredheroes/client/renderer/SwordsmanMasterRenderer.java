package org.kiratsuji.shatteredheroes.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.entity.custom.SwordsmanMasterEntity;

public class SwordsmanMasterRenderer extends MobRenderer<SwordsmanMasterEntity, HumanoidModel<SwordsmanMasterEntity>> {
    public static final ModelLayerLocation SWORDSMAN_MASTER_LAYER = new ModelLayerLocation(
            new ResourceLocation(Shatteredheroes.MODID, "swordsman_master"),"main");

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Shatteredheroes.MODID, "textures/entity/swordsman_master.png");


    public SwordsmanMasterRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(SWORDSMAN_MASTER_LAYER)),0.5F);

        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new HumanoidArmorLayer<>(this,
                new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
                context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(SwordsmanMasterEntity entity) {
        return TEXTURE;
    }
}
