package org.kiratsuji.shatteredheroes.registries;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.entity.custom.SwordsmanMasterEntity;

public class ShatteredHeroesEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Shatteredheroes.MODID);

    public static final RegistryObject<EntityType<SwordsmanMasterEntity>> SWORDSMAN_MASTER = ENTITIES.register("swordsman_master",
            ()-> EntityType.Builder.of(SwordsmanMasterEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.95f)
                    .build("swordsman_master"));
}