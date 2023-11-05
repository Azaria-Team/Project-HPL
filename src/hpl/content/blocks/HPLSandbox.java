package hpl.content.blocks;

import hpl.content.HPLItems;
import hpl.world.blocks.defense.wall.IndestructibleWall;
import hpl.world.draw.DrawCrasideSmelt;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class HPLSandbox {
    public static Block
    indestructibleWall, indestructibleWallLarge, testBlock;

    public static void load() {
        indestructibleWall = new IndestructibleWall("indestructible-wall") {{
            size = 1;
            placeableLiquid = true;
        }};
        indestructibleWallLarge = new IndestructibleWall("indestructible-wall-large") {{
            size = 2;
            placeableLiquid = true;
        }};
        /*
        testBlock = new GenericCrafter("test-block") {{
            requirements(Category.crafting, with(HPLItems.fors, 50, HPLItems.khylid, 20));
            outputItem = new ItemStack(HPLItems.craside, 1);
            consumeItems(with(HPLItems.fors, 2, HPLItems.volcanicSerrid, 1));
            craftTime = 40f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            size = 3;
            craftEffect = Fx.none;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion(){{
                        layer = Layer.block;
                    }},
                    new DrawCrasideSmelt()
            );
        }};

         */
    }
}
