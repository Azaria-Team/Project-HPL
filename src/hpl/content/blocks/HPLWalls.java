package hpl.content.blocks;

import hpl.content.HPLItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static mindustry.type.ItemStack.with;

public class HPLWalls {

    public static Block
            forsWall, forsWallLarge, compositeWall, compositeWallLarge;

    public static void load() {
        forsWall = new Wall("fors-wall") {{
            requirements(Category.defense, with(HPLItems.fors, 6));
            researchCost = with(HPLItems.fors, 100);
            health = 160 * 4;
            armor = 3f;
            buildCostMultiplier = 6f;
        }};

        forsWallLarge = new Wall("fors-wall-large") {{
            requirements (Category.defense, with(HPLItems.fors, 24));
            researchCost = with(HPLItems.fors, 450);
            health = 160 * 16;
            size = 2;
            armor = 3f;
            buildCostMultiplier = 6f;
        }};

        compositeWall = new Wall("composite-wall") {{
            requirements (Category.defense, with(HPLItems.craside, 4, HPLItems.khylid, 2));
            health = 800;
            buildCostMultiplier = 6f;
        }};

        compositeWallLarge = new Wall("composite-wall-large"){{
            requirements (Category.defense, with(HPLItems.craside, 20, HPLItems.khylid, 4));
            size = 2;
            buildCostMultiplier = 6f;
            health = 800 * 4;
        }};
    }
}
