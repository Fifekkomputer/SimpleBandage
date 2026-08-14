package com.example.simplebandage;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    public static final ResourceKey<Item> BANDAGE_KEY =
            ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(
                            Simplebandage.MOD_ID,
                            "bandage"
                    )
            );

    public static final Item BANDAGE = register(
            BANDAGE_KEY,
            BandageItem::new,
            new Item.Properties()
    );

    private static <T extends Item> T register(
            ResourceKey<Item> key,
            Function<Item.Properties, T> factory,
            Item.Properties properties
    ) {
        T item = factory.apply(properties.setId(key));

        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                item
        );
    }

    public static void initialize() {
        // Klasa jest ładowana, więc rejestracja BANDAGE zostanie wykonana.
    }
}
