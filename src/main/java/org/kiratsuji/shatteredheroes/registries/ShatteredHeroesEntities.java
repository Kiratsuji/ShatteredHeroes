package org.kiratsuji.shatteredheroes.registries;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.entity.custom.DojoMasterEntity;

public class ShatteredHeroesEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Shatteredheroes.MODID);

    public static final RegistryObject<EntityType<DojoMasterEntity>> DOJO_MASTER = ENTITIES.register("dojo_master",
            ()-> EntityType.Builder.of(DojoMasterEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.95f)
                    .build("dojo_master"));
}