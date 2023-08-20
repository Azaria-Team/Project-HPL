package hpl.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class HPLLiquids {
    public static Liquid
    oxylite, pinkie;

    public static void load() {

        oxylite = new Liquid("oxylite", Color.valueOf("53ad99")) {{
            viscosity = 0.65f;
            temperature = 0.3f;
        }};
    }
}
