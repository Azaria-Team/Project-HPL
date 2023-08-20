package hpl.content;

import hpl.graphics.HPLPal;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;

public class HPLBullets {
    public static BulletType
            none, forceBullet;

    public static void load() {
        forceBullet = new BasicBulletType(6f, 10f){{
           sprite = "hpl-dagger-missile";
           trailInterval = 0.5f;
           trailEffect = HPLFx.forceBulletTrail;
           hitEffect = HPLFx.forceBulletHit;
           despawnEffect = HPLFx.forceBulletDespawn;
           trailRotation = true;
           shrinkX = shrinkY = 0f;
           width = 8f;
           height = 12f;
           hitSize = 5;
           lifetime = 35;
           collidesGround = true;
           collidesAir = true;

            trailColor = HPLPal.vogPinkBack;
            backColor = HPLPal.vogPinkBack;
            frontColor = HPLPal.forceBullet;

           trailLength = 18;
           trailWidth = 1.7f;

            splashDamage = 35f;
            splashDamageRadius = 35f;
        }};
    }
}
