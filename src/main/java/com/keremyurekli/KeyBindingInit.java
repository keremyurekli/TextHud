package com.keremyurekli;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import org.lwjgl.input.Keyboard;

import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyBindingInit {

    public static KeyBinding keyBinding;
    public static void register(FMLInitializationEvent event){
        keyBinding = create("reload_config", KeyEvent.VK_Y);

        ClientRegistry.registerKeyBinding(keyBinding);
    }
    private static KeyBinding create(String name, int key){

        return new KeyBinding("key."+ Main.MOD_ID + "." + name, key,"key.category."+Main.MOD_ID);
    }
}
