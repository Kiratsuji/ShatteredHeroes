package org.kiratsuji.shatteredheroes.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.entity.custom.SwordsmanMasterEntity;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesEntities;

@Mod.EventBusSubscriber(modid = Shatteredheroes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event){
        event.put(ShatteredHeroesEntities.SWORDSMAN_MASTER.get(), SwordsmanMasterEntity.createAttributes().build());
    }
}