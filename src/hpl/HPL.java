package hpl;
//SEX!
import arc.Core;
import arc.Events;
import arc.scene.ui.ImageButton;
import arc.scene.ui.layout.Table;
import arc.scene.ui.layout.WidgetGroup;
import arc.util.Log;
import arc.util.Time;
import hpl.content.blocks.HPLCoreRelatedBlocks;
import hpl.utils.ManyPlanetSystems;
import hpl.utils.Utils;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.game.Team;
import mindustry.gen.Tex;
import mindustry.mod.*;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import hpl.content.*;

import static mindustry.Vars.*;

public class HPL extends Mod{
    private static boolean show = false;
    public static String text(String str){
        return Core.bundle.format(str);
    }

    public static void dialog(){
        if(!mobile) {

            BaseDialog dialog = new BaseDialog("Project HPL") {
                private float leave = 4f * 60;
                private boolean canClose = false;

                {
                    update(() -> {
                        leave -= Time.delta;
                        if (leave < 0 && !canClose) {
                            canClose = true;
                        }
                    });
                    //cont.add("m-project-hpl").row();
                    cont.image(Core.atlas.find("hpl-title")).pad(3f).height(70).width(700).row();
                    cont.add(text("m-attention")).row();
                    //cont.add(Core.bundle.format("h.name")).row();
                    cont.add(Core.bundle.format("m.description")).row();
                    buttons.check(text("m-not-show-next"), !Core.settings.getBool("first-load"), b -> {
                        Core.settings.put("first-load", !b);
                    }).center();
                    buttons.button("", this::hide).update(b -> {
                        b.setDisabled(!canClose);
                        b.setText(canClose ? text("m-got-it") : "[accent]" + Math.floor(leave / 60) + text("m-seconds"));
                    }).size(150f, 50f).center();
                }
            };
            dialog.show();
        }
    }

    public static void dialogShow(){
        if(!mobile) {
            if (show) return;
            show = true;
            if (Core.settings.getBool("first-load")) {
                dialog();
            }
        }
    }
    @Override
    public void init() {
        super.init();
        ManyPlanetSystems.init();
    }

    public HPL(){
        super();
        if(!mobile) {
            Events.on(EventType.ClientLoadEvent.class, e -> Time.runTask(100f, HPL::dialogShow));
        }
        Events.on(EventType.FileTreeInitEvent.class, e -> HPLSounds.load());

        Log.info("Loaded ExampleJavaMod constructor.");
        if(!headless){
            Utils.init();
        }
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
        HPLWheather.load();
        HPLTechTree.load();
    }
}
