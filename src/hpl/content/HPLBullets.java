package hpl.content;

import arc.math.Interp;
import hpl.graphics.HPLPal;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.ShrapnelBulletType;

public class HPLBullets {
    public static BulletType
            noneBullet, forceBullet, hornBullet, shrapnelBullet;

    public static void load() {

        noneBullet = new BasicBulletType(0f, 0f){{
            shrinkX = shrinkY = 0f;
            width = 0f;
            height = 0f;
            lifetime = 0;
            despawnEffect = hitEffect = Fx.none;
        }};
        forceBullet = new BasicBulletType(6f, 60f){{
           sprite = "hpl-dagger-missile";
           trailInterval = 0.5f;
           trailEffect = HPLFx.forceBulletTrail;
           hitEffect = HPLFx.forceBulletHit;
           despawnEffect = HPLFx.forceBulletDespawn;
           trailRotation = true;
           shrinkX = shrinkY = 0f;
           width = 8f;
           height = 12f;
           lifetime = 35;
           collidesGround = true;
           collidesAir = true;
           hitSize = 3;

           trailColor = HPLPal.vogPinkBack;
           backColor = HPLPal.vogPinkBack;
           frontColor = HPLPal.forceBullet;

           trailLength = 18;
           trailWidth = 1.7f;

            splashDamage = 40f;
            splashDamageRadius = 25f;
        }};

        hornBullet = new BasicBulletType(5f, 40f){{
            hitEffect = HPLFx.hornBulletHit;
            despawnEffect = HPLFx.hornBulletDespawn;
            width = 52f;
            height = 5;
            shrinkY = -2f;
            shrinkX = 0.1f;
            hitSize = 9;
            knockback = 3.3f;
            ammoMultiplier = 0;

            shrinkInterp = Interp.reverse;
            lifetime = 26;
            collidesGround = true;
            collidesAir = true;
            impact = true;
            pierce = true;
            pierceCap = 2;

            backColor = HPLPal.craside;
            frontColor = HPLPal.craside2;

        }};

        shrapnelBullet = new ShrapnelBulletType(){{
            damage = 1f;
            length = 110f;
        }};
    }
}
