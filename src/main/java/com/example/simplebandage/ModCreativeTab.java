package com.example.simplebandage;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {

    public static final ResourceKey<CreativeModeTab> SIMPLEBANDAGE_TAB_KEY =
            ResourceKey.create(
                    Registries.CREATIVE_MODE_TAB,
                    Identifier.fromNamespaceAndPath(
                            Simplebandage.MOD_ID,
                            "simplebandage"
                    )
            );

    public static final CreativeModeTab SIMPLEBANDAGE_TAB =
            FabricItemGroup.builder()
                    .title(Component.translatable(
                            "itemGroup.simplebandage"
                    ))
                    .icon(() -> new ItemStack(ModItems.BANDAGE))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BANDAGE);
                    })
                    .build();

    public static void initialize() {
        BuiltInRegistries.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                SIMPLEBANDAGE_TAB_KEY,
                SIMPLEBANDAGE_TAB
        );
    }
}


