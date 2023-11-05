package hpl.content;

import hpl.content.blocks.*;
import hpl.content.blocks.HPLDistribution;

public class HPLBlocks {
    public static void load() {
        HPLCoreRelatedBlocks.load();
        HPLDistribution.load();
        HPLDrills.load();
        HPLEnvironment.load();
        HPLLiquidBlocks.load();
        HPLPower.load();
        HPLProduction.load();
        HPLSandbox.load();
        HPLTurrets.load();
        HPLUnitRelatedBlocks.load();
        HPLWalls.load();
    }
}
