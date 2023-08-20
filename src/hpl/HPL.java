package hpl;
//SEX!
import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import hpl.utils.ManyPlanetSystems;
import mindustry.game.EventType;
import mindustry.mod.*;
import mindustry.type.SectorPreset;
import mindustry.ui.dialogs.BaseDialog;
import hpl.content.*;

public class HPL extends Mod{

    public HPL(){
        Log.info("Loaded ExampleJavaMod constructor.");

        Events.on(EventType.ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {

                BaseDialog dialog = new BaseDialog("ATTENTION!");
                dialog.cont.add("THIS IS A BETA VERSION OF THE MOD WHICH MAY NOT DISPLAY THE FINAL QUALITY OF THE PROJECT\nTHIS MOD CONTAINS \"DIFFERENT\" CONTENT PLEASE READ THE DESCRIPTION OF THE BLOCKS, ITEMS, UNITS ETC.").row();

                dialog.cont.image(Core.atlas.find("hpl-fors")).pad(20f).row();
                dialog.cont.button("OK", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });

    }
    @Override
    public void init() {
        super.init();
        ManyPlanetSystems.init();
    }

    @Override
    public void loadContent(){
        HPLItems.load();
        HPLLiquids.load();
        HPLStatusEffects.load();
        HPLBullets.load();
        HPLUnits.load();
        HPLBlocks.load();
        HPLLoadouts.load();
        HPLPlanets.load();
        HPLSectorPreset.load();
        HPLTechTree.load();
    }
}
