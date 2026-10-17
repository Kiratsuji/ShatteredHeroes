package org.kiratsuji.shatteredheroes;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesEntities;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesItems;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesStructures;
import org.kiratsuji.shatteredheroes.registries.ShatteredHerosCreativeTabs;

@Mod(Shatteredheroes.MODID)
public class Shatteredheroes {
    // ── Variables ─────────────────────────────────────────────────────────────
    public static final String MODID = "shatteredheroes";

    // ── Constructor ───────────────────────────────────────────────────────────
    public Shatteredheroes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        ShatteredHeroesItems.ITEMS.register(modEventBus);
        ShatteredHerosCreativeTabs.CREATIVE_TABS.register(modEventBus);
        ShatteredHeroesEntities.ENTITIES.register(modEventBus);
        ShatteredHeroesStructures.STRUCTURE_TYPES.register(modEventBus);
        ShatteredHeroesStructures.STRUCTURE_PIECES.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
