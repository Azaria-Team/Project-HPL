package hpl.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class HPLLiquids {
    public static Liquid
            oxyliteLiq, pinkieLiq;

    public static void load() {

        oxyliteLiq = new Liquid("oxylite-liq", Color.valueOf("53ad99")) {{
            viscosity = 0.65f;
            heatCapacity = 0.3f;
        }}; //test
    }
}
