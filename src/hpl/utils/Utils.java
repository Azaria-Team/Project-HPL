package hpl.utils;

import arc.Events;
import arc.math.geom.Vec2;
import arc.struct.IntSet;
import mindustry.entities.bullet.BulletType;
import mindustry.game.EventType;

import static mindustry.Vars.world;

public class Utils {
    private static final BoolGrid collideLineCollided = new BoolGrid();
    public static void init(){
        Events.on(EventType.WorldLoadEvent.class, event -> {
            collideLineCollided.updateSize(world.width(), world.height());
        });
    }

    public static int getByIndex(IntSet intSet, int index) {
        if (index < 0 || index >= intSet.size) {
            throw new IndexOutOfBoundsException();
        }

        final int[] value = {0};
        final int[] counter = {0};
        intSet.each((item) -> {
            if (counter[0] == index) {
                value[0] = item;
            }
            counter[0]++;
        });

        if (counter[0] > index) {
            return value[0];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public interface Targeting {
        default Vec2 targetPos(){
            return null;
        }
    }

    public static float getBulletDamage(BulletType type){
        return type.damage + type.splashDamage + (Math.max(type.lightningDamage / 2f, 0f) * type.lightning * type.lightningLength);
    }

}
