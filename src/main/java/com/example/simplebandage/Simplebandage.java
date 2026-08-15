package com.example.simplebandage;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Simplebandage implements ModInitializer {

    public static final String MOD_ID = "simplebandage";

    public static final Logger LOGGER =
            LoggerFactory.getLogger(MOD_ID);

    public static final CreativeModeTab SIMPLEBANDAGE_TAB =
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.simplebandage"))
                    .icon(() -> new ItemStack(ModItems.BANDAGE))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BANDAGE);
                    })
                    .build();

    @Override
    public void onInitialize() {
        ModItems.initialize();

        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                id("simplebandage"),
                SIMPLEBANDAGE_TAB
        );

        LOGGER.info("SimpleBandage initialized!");
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
