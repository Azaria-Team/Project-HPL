package hpl.content.blocks;

import arc.util.Time;
import hpl.content.HPLItems;
import hpl.content.HPLUnits;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class HPLUnitRelatedBlocks {
    public static Block
    angelsharkFabricator, vectorFabricator, unmakerFabricator;

    public static void load() {
        angelsharkFabricator = new UnitFactory("angelshark-fabricator"){{
            requirements(Category.units, with(HPLItems.fors, 200, HPLItems.khylid, 140, HPLItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(HPLUnits.angelshark, 15f * Time.toSeconds, with(HPLItems.fors, 40, HPLItems.khylid, 30, HPLItems.craside, 10)));
            researchCost = with(HPLItems.fors, 180, HPLItems.khylid, 100, HPLItems.craside, 40);
            regionSuffix = "-hpl";
            fogRadius = 3;
            consumePower(2f);
        }};

        vectorFabricator = new UnitFactory("vector-fabricator"){{
            requirements(Category.units, with(HPLItems.fors, 200, HPLItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(HPLUnits.vector, 10f * Time.toSeconds, with(HPLItems.fors, 50, HPLItems.craside, 30)));
            researchCost = with(HPLItems.fors, 220, HPLItems.craside, 80);
            regionSuffix = "-hpl";
            fogRadius = 3;
            researchCostMultiplier = 0.2f;
            consumePower(2f);
        }};
        unmakerFabricator = new UnitFactory("unmaker-fabricator") {{
            requirements(Category.units, with(HPLItems.fors, 200, HPLItems.craside, 100));
            size = 3;
            configurable = false;
            squareSprite = false;
            plans.add(new UnitPlan(HPLUnits.unmaker, 10f * Time.toSeconds, with(HPLItems.fors, 50, HPLItems.craside, 30)));
            researchCost = with(HPLItems.fors, 220, HPLItems.craside, 80);
            regionSuffix = "-hpl";
            fogRadius = 3;
            consumePower(2f);
        }};
    }
}
