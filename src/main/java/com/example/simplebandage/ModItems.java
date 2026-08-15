package com.example.simplebandage;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final ResourceKey<Item> BANDAGE_KEY =
            ResourceKey.create(
                    Registries.ITEM,
                    Identifier.fromNamespaceAndPath(
                            Simplebandage.MOD_ID,
                            "bandage"
                    )
            );

    public static final Item BANDAGE = Registry.register(
            BuiltInRegistries.ITEM,
            BANDAGE_KEY,
            new BandageItem(
                    new Item.Properties().setId(BANDAGE_KEY)
            )
    );

    public static void initialize() {
        Simplebandage.LOGGER.info(
                "Registered bandage: {}",
                BuiltInRegistries.ITEM.getKey(BANDAGE)
        );
    }
}
