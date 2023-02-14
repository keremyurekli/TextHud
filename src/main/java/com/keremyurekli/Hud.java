package com.keremyurekli;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class Hud extends Gui {


    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void hej(RenderGameOverlayEvent event)
    {

        if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE)
        {
            return;
        }



        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution scr = new ScaledResolution(mc);
        Main.SCREEN_WIDTH = scr.getScaledWidth();
        Main.SCREEN_HEIGHT = scr.getScaledHeight();
//
//        System.out.println("WIDTH/HEIGHT: " + Main.SCREEN_WIDTH +"/"+ Main.SCREEN_HEIGHT);


        int finalX;
        int finalY;
        FontRenderer fontRenderer = FMLClientHandler.instance().getClient().fontRenderer;
        finalX = (int) ((Main.SCREEN_WIDTH/2)+Config.textX);
        finalY = (int) ((Main.SCREEN_HEIGHT/2)+Config.textY);
        if(Config.textString.contains("{player}")){
            Config.textString = Config.textString.replaceAll("\\{player\\}",mc.player.getName());
        }
        if(Config.textString.contains("{n}")){
            String[] parts = Config.textString.split("\\{n\\}");
            for(int i = 0; i<parts.length; i++){
                int fixOverlay = fontRenderer.getStringWidth(parts[i])/2;
                if(i==0){
                    fontRenderer.drawString(parts[i], finalX - fixOverlay, finalY, Config.textColor, Config.textShadow);
                }else{
                    fontRenderer.drawString(parts[i], finalX - fixOverlay, finalY+i*15, Config.textColor, Config.textShadow);
                }
            }

        }else{
            int fixOverlay = fontRenderer.getStringWidth(Config.textString)/2;
            fontRenderer.drawString(Config.textString, finalX - fixOverlay, finalY, Config.textColor, Config.textShadow);
        }

    }
}
