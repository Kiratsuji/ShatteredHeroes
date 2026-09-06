package org.kiratsuji.shatteredheroes;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesEntities;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesItems;

@Mod(Shatteredheroes.MODID)
public class Shatteredheroes {
    // ── Variables ─────────────────────────────────────────────────────────────
    public static final String MODID = "shatteredheroes";

    // ── Constructor ───────────────────────────────────────────────────────────
    public Shatteredheroes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        ShatteredHeroesItems.ITEMS.register(modEventBus);
        ShatteredHeroesEntities.ENTITIES.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
