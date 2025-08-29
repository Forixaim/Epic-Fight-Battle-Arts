package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonInputLocks;
import net.forixaim.battle_arts.core_assets.skills.combat_art.PowerGeyser;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class Mercenary extends BattleStyle
{
    public static Skill FIERCE_UPPER;
    public static Skill POWER_GEYSER;

    public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
    {
        FIERCE_UPPER = worker.build("fierce_upper", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(MercenaryGreatswordAnimations.FIERCE_UPPER)).newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4f));
        POWER_GEYSER = worker.build("power_geyser", PowerGeyser::new, CombatArt.createCombatArt().setResource(Resource.COOLDOWN));
    }

    private static final UUID EVENT_UUID = UUID.fromString("7e975e33-5226-47eb-8b0d-51fe9946f2e4");
    public Mercenary(Builder<?> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container)
    {
        super.onInitiate(container);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, POWER_GEYSER);

        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID, CommonInputLocks.LOCK_MOVEMENT_GUARDING);
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);

        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID);
    }
}
