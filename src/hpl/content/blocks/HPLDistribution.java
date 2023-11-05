package hpl.content.blocks;

import hpl.content.HPLItems;
import hpl.world.blocks.distribution.ModDuct;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;

import static mindustry.type.ItemStack.with;

public class HPLDistribution {
    public static Block
    impulseConveyor, impulseRouter, impulseSorter, impulseGate, impulseJunction, impulseBridge;
    public static void load() {
        impulseConveyor = new ModDuct("impulse-conveyor") {{
            requirements(Category.distribution, with(HPLItems.fors, 1));
            health = 130;
            speed = 5f;
            researchCost = with(HPLItems.fors, 5);
            junctionReplacement = HPLDistribution.impulseJunction;
            bridgeReplacement = HPLDistribution.impulseBridge;
        }};
        impulseJunction = new Junction("impulse-junction") {{
            requirements(Category.distribution, with(HPLItems.fors, 2));
            researchCost = with(HPLItems.fors, 10);
            speed = 6;
            capacity = 1;
            health = 140;
            buildCostMultiplier = 6f;
            squareSprite = false;
        }};
        impulseRouter = new Router("impulse-router") {{
            requirements(Category.distribution, with(HPLItems.fors, 3));
            researchCost = with(HPLItems.fors, 15);
            speed = 16;
            buildCostMultiplier = 4f;
            squareSprite = false;
        }};
        impulseSorter = new Sorter("impulse-sorter"){{
            requirements(Category.distribution, with(HPLItems.fors, 4));
            buildCostMultiplier = 3f;
        }};
        impulseGate = new OverflowGate("impulse-gate"){{
            requirements(Category.distribution, with(HPLItems.fors, 6));
            buildCostMultiplier = 3f;
        }};
        impulseBridge = new DuctBridge("impulse-bridge"){{
            requirements(Category.distribution, with(HPLItems.fors, 10));
            researchCost = with(HPLItems.fors, 20);
            health = 90;
            speed = 4f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
            squareSprite = false;
        }};
    }
}
