package hpl.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class HPLItems {
    public static Item
    //items
    fors, craside, khylid, volcanicSerrid, ferbium, superdenseAlloy, ognium, neuroCrystal, hyperliosAlloy, arcanite;
    public static final Seq<Item> aurionaItems = new Seq<>();
    public static void load() {
        fors = new Item("fors", Color.valueOf("f3b2c1")) {{
        cost = 0.75f;
        hardness = 1;
        alwaysUnlocked = true;
        }};
        khylid = new Item("khylid", Color.valueOf("87d7bf")) {{
            cost = 0.3f;
        }};
        craside = new Item("craside", Color.valueOf("d9fa96")) {{
            cost = 0.6f;
        }};
        volcanicSerrid = new Item("volcanic-serrid", Color.valueOf("42373a")) {{
            cost = 1f;
        }};
        ferbium = new Item("ferbium", Color.valueOf("847bb1")) {{
            cost = 1f;
            hardness = 2;
        }};
            superdenseAlloy = new Item("superdense-alloy", Color.valueOf("313442")) {{
            cost = 1f;
        }};
        ognium = new Item("ognium", Color.valueOf("5e3143")) {{
            cost = 1f;
        }};
        neuroCrystal = new Item("neuro-crystal", Color.valueOf("4f2e6c")) {{
            cost = 1f;
        }};
        hyperliosAlloy = new Item("hyperlios-alloy", Color.valueOf("54686a")) {{
            cost = 1f;
        }};
        arcanite = new Item("arcanite"){{
            cost = 2f;
        }};

        aurionaItems.addAll(
                fors, craside, khylid, volcanicSerrid, ferbium, superdenseAlloy, ognium, neuroCrystal, hyperliosAlloy
        );
    }
}
