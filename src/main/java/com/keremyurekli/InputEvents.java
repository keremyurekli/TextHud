package com.keremyurekli;


import net.minecraft.client.Minecraft;
import net.minecraft.profiler.Profiler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import scala.tools.nsc.ast.parser.Scanners;

import javax.xml.transform.Result;
import java.io.File;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Side.CLIENT)
public class InputEvents {

    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event){

        Minecraft mc = Minecraft.getMinecraft();
        if(mc.world == null){
            return;
        }
        if(mc.currentScreen == null && KeyBindingInit.keyBinding.isPressed()){
            System.out.println("Reloading config file!");
            Config.init(new File(Main.config.getPath(), Main.MOD_ID+".cfg"));
        }


    }

}
