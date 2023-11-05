package hpl.world.blocks.power;

import acontent.world.meta.AStats;
import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import arc.util.Eachable;
import arc.util.Strings;
import arc.util.Tmp;
import hpl.world.meta.HPLStat;
import hpl.world.meta.HPLStatUnit;
import mindustry.Vars;
import mindustry.entities.units.BuildPlan;
import mindustry.game.Team;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.Tile;
import mindustry.world.blocks.power.ThermalGenerator;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.world.meta.StatValues;

import static mindustry.Vars.*;
import static mindustry.Vars.player;

public class ThermalEvaporator extends ThermalGenerator {

    public int spacing = 4;

    public ThermalEvaporator(String name){
        super(name);
    }

    @Override
    public void drawOverlay(float x, float y, int rotation){
        if(spacing < 1) return;
        Drawf.dashSquare(Pal.remove, x, y, (size + spacing / 2f + 3f) * tilesize);
    }

    @Override
    public void setStats() {
        super.setStats();

        stats.add(Stat.tiles, attribute, floating, size * size * displayEfficiencyScale, !displayEfficiency);
        stats.remove(generationType);
        stats.add(generationType, powerProduction * 60.0f / displayEfficiencyScale, StatUnit.powerSecond);

        if(outputLiquid != null){
            stats.add(Stat.output, StatValues.liquid(outputLiquid.liquid, outputLiquid.amount * size * size * 60f, true));
        }
        stats.add(HPLStat.placeSpacing.toStat(), spacing + size / 2f + 3f, StatUnit.blocks);
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        if(spacing < 1) return true;
        int off = 1 - size % 2;
        for(int x = tile.x - spacing + off; x < tile.x + spacing - -1; x++){
            for(int y = tile.y - spacing + off; y < tile.y + spacing - -1; y++){
                Tile t = world.tile(x, y);
                if(t != null &&  t.block() instanceof ThermalEvaporator s && (s == this || s.spacings(t.build.tile, tile))) return false;
            }
        }
        return tile.getLinkedTilesAs(this, tempTiles).sumf(other -> other.floor().attributes.get(attribute)) > minEfficiency;
    }

    public boolean spacings(int sx, int sy, int offx, int offy, int ext){
        if(spacing < 1) return true;
        int spacingOffset = spacing + ext;
        int sizeOffset = 1 - (size & 1);

        return offx >= sx + sizeOffset - spacingOffset && offx <= sx + spacingOffset &&
               offy >= sy + sizeOffset - spacingOffset && offy <= sy + spacingOffset;
    }

    public boolean spacings(Tile tile, Tile otherTile){
        return spacings(tile.x, tile.y, otherTile.x, otherTile.y, 0);
    }
}
