package hpl.content.blocks;

import hpl.content.HPLItems;
import hpl.graphics.HPLPal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.production.Pump;

import static mindustry.type.ItemStack.with;

public class HPLLiquidBlocks {
    public static Block
    impulsePump, liquidPipe, liquidPipeJunction, liquidCanister, liquidPipeRouter, pipeBridgeConduit;
    public static void load() {
        impulsePump = new Pump("impulse-pump"){{
            requirements(Category.liquid, with(HPLItems.fors, 90, HPLItems.craside, 70, HPLItems.ferbium, 30));

            squareSprite = false;
            pumpAmount = 10f / 60f;
            liquidCapacity = 140f;
            researchCostMultiplier = 0.3f;
            size = 2;
            consumePower(1.5f / 3f);
        }};

        liquidPipe = new ArmoredConduit("liquid-pipe"){{
            requirements(Category.liquid, with(HPLItems.fors, 1, HPLItems.ferbium, 1));
            botColor = HPLPal.aureliaOutline;
            leaks = true;
            liquidCapacity = 25f;
            liquidPressure = 1.1f;
            health = 300;
            researchCostMultiplier = 0.3f;
            underBullets = true;
        }};
        liquidPipeJunction = new LiquidJunction("liquid-pipe-junction"){{
            requirements(Category.liquid, with(HPLItems.fors, 3, HPLItems.ferbium, 5));
            buildCostMultiplier = 3f;
            health = 320;
            ((Conduit)liquidPipe).junctionReplacement = this;
            researchCostMultiplier = 0.3f;
            solid = false;
            underBullets = true;
        }};

        pipeBridgeConduit = new LiquidBridge("pipe-bridge-conduit"){{
            requirements(Category.liquid, with(HPLItems.fors, 3, HPLItems.ferbium, 8));
            range = 5;
            hasPower = false;
            researchCostMultiplier = 0.3f;
            underBullets = true;
            arrowSpacing = 6f;

            ((Conduit)liquidPipe).rotBridgeReplacement = this;
        }};

        liquidPipeRouter = new LiquidRouter("liquid-pipe-router"){{
            requirements(Category.liquid, with(HPLItems.fors, 3, HPLItems.ferbium, 5));
            liquidCapacity = 35f;
            liquidPadding = 1.0f;
            researchCostMultiplier = 0.3f;
            underBullets = true;
            solid = false;
        }};

        liquidCanister = new LiquidRouter("liquid-canister") {{
            requirements(Category.liquid, with(HPLItems.fors, 15, HPLItems.ferbium, 35));
            liquidCapacity = 3545f;
            size = 2;
            liquidPadding = 1.0f;
            researchCostMultiplier = 0.3f;
            underBullets = true;
        }};
    }
}
