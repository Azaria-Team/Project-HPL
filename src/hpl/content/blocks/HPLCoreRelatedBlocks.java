package hpl.content.blocks;

import hpl.content.HPLItems;
import hpl.content.HPLUnits;
import hpl.graphics.HPLPal;
import hpl.world.blocks.defense.NavalMine;
import hpl.world.blocks.defense.turret.BlockRepairTurret;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;

import static mindustry.type.ItemStack.with;

public class HPLCoreRelatedBlocks {
    public static Block
            complexSurprise, coreLegion, caseI, repairTurret;
    public static void load() {
        //region traps
        coreLegion = new CoreBlock("core-legion") {{
            requirements(Category.effect, with(HPLItems.fors, 1200, HPLItems.khylid, 800));

            isFirstTier = true;
            unitType = HPLUnits.gyurza;
            health = 2500;
            itemCapacity = 2500;
            size = 3;
            armor = 2f;
            alwaysUnlocked = true;
            squareSprite = false;

            unitCapModifier = 12;
        }};

        caseI = new StorageBlock("case") {{
            requirements(Category.effect, with(HPLItems.fors, 100));
            size = 2;
            itemCapacity = 100;
            scaledHealth = 80;
            squareSprite = false;
            researchCostMultiplier = 0.7f;
        }};
        complexSurprise = new NavalMine("complex-surprise") {{
            size = 2;
            floating = true;
            outlineColor = HPLPal.aureliaOutline;
            requirements(Category.effect, with(HPLItems.ognium, 50, HPLItems.ferbium, 35));
            hasShadow = false;
            health = 1850;
            damage = 150;
            tileDamage = 450;
        }};

        repairTurret = new BlockRepairTurret("repair-turret"){{
            requirements(Category.effect, with(HPLItems.fors, 120, HPLItems.khylid, 30, HPLItems.craside, 80));
            repairSpeed = 0.75f;
            repairRadius = 180f;
            outlineColor = HPLPal.aureliaOutline;
            beamWidth = 1f;
            powerUse = 1f;
            size= 2;
            researchCostMultiplier = 0.9f;
        }};
    }
}
