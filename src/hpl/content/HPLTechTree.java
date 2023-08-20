package hpl.content;

import static mindustry.content.TechTree.*;
import static hpl.content.HPLItems.*;
import static hpl.content.HPLBlocks.*;

public class HPLTechTree {

    public static void load(){
        HPLPlanets.auriona.techTree = nodeRoot("auriona", coreLegion, () -> {
            //region distribution
            node(impulseConveyor, () -> {
                node(impulseJunction, () -> {
                    node(impulseRouter, () -> {
                    });

                });
                node(impulseBridge, () -> {
                });

            });
            //endregion distribution
            //region crafting
            node(waveDrill, () -> {
                node(pumpDrill, () -> {

                });
            });
            //endregion crafting
            //region power
            node(plasmaNode, () -> {
                node(plasmaDistributor, () -> {

                });
            });

            node(thermalEvaporator, () -> {

            });
            //endregion power
            //region defense
            node(forsWall, () -> {
                node(forsWallLarge, () -> {

                });
            });
            //endregion defense
            //region turrets
            node(forceTurret, () -> {

            });
            //endregion turrets
            //endregion blocks
			       //region items and liquids
            nodeProduce(fors, () -> {
                nodeProduce(craside, () -> {
                    nodeProduce(khylid, () -> {
                        nodeProduce(ferbium, () -> {
                    });
                });
            });
        });
            node(HPLSectorPreset.abandonedShoreline, () -> {
            });
        //endregion items and liquids
        });
    }
}
