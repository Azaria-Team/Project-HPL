package hpl.content;

import arc.struct.Seq;
import mindustry.game.Objectives;

import static hpl.content.HPLLiquids.*;
import static hpl.content.blocks.HPLCoreRelatedBlocks.*;
import static hpl.content.blocks.HPLPower.*;
import static hpl.content.blocks.HPLWalls.*;
import static hpl.content.blocks.HPLDrills.*;
import static hpl.content.HPLSectorPreset.*;
import static mindustry.content.TechTree.*;
import static hpl.content.HPLItems.*;
import static hpl.content.blocks.HPLDistribution.*;
import static hpl.content.blocks.HPLProduction.*;
import static hpl.content.blocks.HPLTurrets.*;
import static hpl.content.blocks.HPLLiquidBlocks.*;
import static hpl.content.blocks.HPLUnitRelatedBlocks.*;
import static hpl.content.HPLUnits.*;


public class HPLTechTree {

    public static void load(){
        HPLPlanets.auriona.techTree = nodeRoot("Auriona", coreLegion, () -> {
            //region distribution
            node(impulseConveyor, () -> {
                node(impulseJunction, () -> {
                    node(impulseRouter, () -> {
                    });

                });
                node(impulseBridge, () -> {
                });
                node(impulseSorter, Seq.with(new Objectives.OnSector(caveEntrance)), () -> {
                    node(impulseGate, Seq.with(new Objectives.OnSector(caveEntrance)), () -> {

                    });
                });
            });
            node(caseI, Seq.with(new Objectives.SectorComplete(seaOutpost)), () -> {

            });
            //endregion distribution
            //region crafting
            node(forsDrill, () -> {
                node(waveDrill, Seq.with(new Objectives.OnSector(caveEntrance)), () -> {
                    node(oreDetector, Seq.with(new Objectives.SectorComplete(seaOutpost)), () -> {

                    });
                });
                node(pumpDrill, () -> {

                });
            });
            node(crasideBrewer, Seq.with(new Objectives.OnSector(caveEntrance)), () -> {

            });
            //endregion crafting
            //region liquid
            node(liquidPipe, Seq.with(new Objectives.OnSector(theOutskirts)), () -> {
                node(impulsePump, Seq.with(new Objectives.OnSector(theOutskirts)), () -> {

                });
                node(liquidPipeJunction, Seq.with(new Objectives.OnSector(theOutskirts)), () -> {
                    node(liquidPipeRouter, Seq.with(new Objectives.OnSector(theOutskirts)), () -> {

                    });
                });
                node(pipeBridgeConduit, Seq.with(new Objectives.OnSector(theOutskirts)), () -> {

                });
            });

            //endregion liquid
            //region power
            node(plasmaNode, () -> {
                node(thermalEvaporator, () -> {
                    node(oxyliteTurbine, Seq.with(new Objectives.OnSector(theOutskirts), new Objectives.Research(impulsePump)), () -> {

                    });
                });
                node(plasmaDistributor, () -> {

                });
            });


            //endregion power
            //region defense
            node(forceTurret, () -> {
                node(forsWall, () -> {
                    node(forsWallLarge, () -> {

                    });
                });
                node(hornTurret, Seq.with(new Objectives.SectorComplete(seaOutpost)), () -> {

                });
            });
            node(repairTurret, Seq.with(new Objectives.SectorComplete(caveEntrance)), () -> {
            });
            //endregion defense
            //endregion blocks
            //region units
            node(vectorFabricator, Seq.with(new Objectives.OnSector(seaOutpost)), () -> {
                node(vector);
            });
            //endregion units

            //region items and liquids
            nodeProduce(fors, () -> {
                nodeProduce(volcanicSerrid, () -> {
                });
                nodeProduce(khylid, () -> {
                    nodeProduce(craside, () -> {
                        nodeProduce(ferbium, () -> {
                        });
                    });
                });
            });
            nodeProduce(oxyliteLiq, () -> {
            });
            // node(HPLSectorPreset.abandonedShoreline, () -> {
            // });
            //endregion items and liquids
            //region sectors
            node(abandonedShoreline, () -> {
                node(caveEntrance, Seq.with(new Objectives.SectorComplete(abandonedShoreline)), () -> {
                    node(seaOutpost, Seq.with(new Objectives.SectorComplete(caveEntrance), new Objectives.Research(waveDrill), new Objectives.Research(crasideBrewer), new Objectives.Research(repairTurret)), () -> {
                        node(theOutskirts, Seq.with(new Objectives.SectorComplete(seaOutpost), new Objectives.Research(vectorFabricator), new Objectives.Research(oreDetector), new Objectives.Research(caseI)), () -> {
                        });
                    });
                });
            });
            //endregion sectors
        });
    }
}
