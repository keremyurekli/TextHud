package com.keremyurekli;

import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class Config {
    public static Configuration config;


    public static String textString;
    public static int textSize;
    public static int textColor;
    
    public static float textX;
    public static float textY;

    public static boolean textShadow;


    public static void init(File file){
        config = new Configuration(file);

        String category;

        category = "Hud Settings";
        config.addCustomCategoryComment(category,"Edit settings\n" +
                "Text size is not working for now\n" +
                "Tags:\n" +
                "{player} -> Player name\n" +
                "{n} -> Line brake\n" +
                "And\n" +
                "You can use § color codes regardless of main color.");
        textString = config.getString("textString",category,"Default text","Text that will write on screen");
        textSize = config.getInt("textSize",category,2,0,20,"Size of texts");


        String temp = config.getString("textColor",category,"#FFFFFF","Color of text (HEX)");
        temp = temp.replace("#","");
        temp = "0x"+temp;
        textColor = Integer.decode(temp);

        textX = config.getInt("textX",category,0,-(Main.SCREEN_WIDTH/2),Main.SCREEN_WIDTH/2,"X offset of text");

        textY= config.getInt("textY",category,0,-(Main.SCREEN_HEIGHT/2),Main.SCREEN_HEIGHT/2,"Y offset of text");
        textShadow = config.getBoolean("textShadow",category,true,"Disable/Enable dropshadow effect");
        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event){
        Main.config = new File(event.getModConfigurationDirectory()+"/"+ Main.MOD_ID);
        Main.config.mkdirs();
        init(new File(Main.config.getPath(), Main.MOD_ID+".cfg"));
    }
}
