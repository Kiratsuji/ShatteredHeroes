package org.kiratsuji.shatteredheroes.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.item.KatanaItem;

public class ShatteredHeroesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Shatteredheroes.MODID);

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            ()-> new KatanaItem(Tiers.IRON, new Item.Properties()));
}
