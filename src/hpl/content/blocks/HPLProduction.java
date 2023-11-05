package hpl.content.blocks;

import hpl.content.HPLFx;
import hpl.content.HPLItems;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class HPLProduction {
    public static Block
    crasideBrewer;

    public static void load() {
        //TODO
        crasideBrewer = new GenericCrafter("craside-brewer") {{
            requirements(Category.crafting, with(HPLItems.fors, 60, HPLItems.khylid, 35));
            outputItem = new ItemStack(HPLItems.craside, 2);
            consumeItems(with(HPLItems.khylid, 1, HPLItems.volcanicSerrid, 1));
            craftTime = 60f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 3;
            craftEffect = HPLFx.crasideBrewerSmoke;
            consumePower(1f);
            researchCostMultiplier = 0.2f;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"){{
                        layer = Layer.block;
                    }},
                    new DrawRegion(){{
                        layer = Layer.block + 0.1f;
                    }},
                    new DrawRegion("-top"){{
                        layer = Layer.block + 0.2f;
                    }}
            );
        }};
    }
}
