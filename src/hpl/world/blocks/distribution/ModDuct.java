package hpl.world.blocks.distribution;

import arc.func.Boolf;
import arc.math.Mathf;
import arc.math.geom.Geometry;
import arc.math.geom.Point2;
import arc.struct.Seq;
import arc.util.Nullable;
import hpl.content.HPLBlocks;
import mindustry.content.Blocks;
import mindustry.entities.units.BuildPlan;
import mindustry.input.Placement;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;

public class ModDuct extends Duct {
    public @Nullable
    Block junctionReplacement, bridgeReplacement;

    public ModDuct(String name) {
        super(name);
    }

    @Override
    public void init(){
        super.init();

        if(junctionReplacement == null) junctionReplacement = HPLBlocks.impulseJunction;
        if(bridgeReplacement == null || !(bridgeReplacement instanceof DuctBridge)) bridgeReplacement = HPLBlocks.impulseBridge;
    }

    @Override
    public void handlePlacementLine(Seq<BuildPlan> plans){
        if(bridgeReplacement == null) return;

        Placement.calculateBridges(plans, (DuctBridge)bridgeReplacement, true, b -> b instanceof Duct || b instanceof StackConveyor || b instanceof Conveyor);
    }

    @Override
    public Block getReplacement(BuildPlan req, Seq<BuildPlan> plans){
        if(junctionReplacement == null) return this;

        Boolf<Point2> cont = p -> plans.contains(o -> o.x == req.x + p.x && o.y == req.y + p.y && (req.block instanceof Duct || req.block instanceof Junction));
        return cont.get(Geometry.d4(req.rotation)) &&
                cont.get(Geometry.d4(req.rotation - 2)) &&
                req.tile() != null &&
                req.tile().block() instanceof Duct &&
                Mathf.mod(req.tile().build.rotation - req.rotation, 2) == 1 ? junctionReplacement : this;
    }
}
