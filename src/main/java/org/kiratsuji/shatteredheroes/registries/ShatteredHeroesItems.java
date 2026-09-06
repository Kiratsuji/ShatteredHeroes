package org.kiratsuji.shatteredheroes.registries;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.item.KatanaItem;
import org.kiratsuji.shatteredheroes.item.MasterKimonoItem;

public class ShatteredHeroesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Shatteredheroes.MODID);

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            ()-> new KatanaItem(Tiers.IRON, new Item.Properties()));

    public static final RegistryObject<Item> RONIN_HAT = ITEMS.register("ronin_hat",
            ()-> new MasterKimonoItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MASTER_KIMONO = ITEMS.register("master_kimono",
            ()-> new MasterKimonoItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLACK_HAKAMA = ITEMS.register("black_hakama",
            ()-> new MasterKimonoItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SANDALS = ITEMS.register("sandals",
            ()-> new MasterKimonoItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

}
