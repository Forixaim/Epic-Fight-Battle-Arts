package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Armatures;

public class JourneymanAxeAnims
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIRSLASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> INNATE;

    public static void Build(AnimationManager.AnimationBuilder event)
    {
        IDLE = event.nextAccessor("battle_style/novice/journeyman/axe/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        AUTO1 = event.nextAccessor("battle_style/novice/journeyman/axe/auto1", access -> new BasicAttackAnimation(0.2f, 0.0f, 0.7f, 0.8f, 1f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));
        AUTO2 = event.nextAccessor("battle_style/novice/journeyman/axe/auto2", access -> new BasicAttackAnimation(0.2f, 0.0f, 0.5f, 0.6f, 1.5f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));
        DASH = event.nextAccessor("battle_style/novice/journeyman/axe/dash", access -> new DashAttackAnimation(0.2f, 0.0f, 0.35f, 0.45f, 1.5f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));
        AIRSLASH = event.nextAccessor("battle_style/novice/journeyman/axe/airslash", access -> new AirSlashAnimation(0.2f, 0.0f, 0.5f, 0.65f, 1.5f, false, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));
        INNATE = event.nextAccessor("battle_style/novice/journeyman/axe/innate", access -> new AttackAnimation(0.2f, 0.0f, 0.8f, 1.2f, 2f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED));

    }
}
