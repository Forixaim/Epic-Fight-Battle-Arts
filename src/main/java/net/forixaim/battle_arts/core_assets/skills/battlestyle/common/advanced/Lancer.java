package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts_api.battle_arts_skills.CoreAPIDataKeys;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class Lancer extends BattleStyle
{
    public static Skill DASHING_IMPALE;

    private static final UUID EVENT_UUID = UUID.fromString("efdb4124-1e26-46bd-8984-dd395ac220da");

    public static void buildSkill(SkillBuildEvent.ModRegistryWorker worker)
    {
        DASHING_IMPALE = worker.build("dashing_impale", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                .setAnimations(LancerSpearAnimations.DASHING_IMPALE)).newProperty();
    }

    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_HURT, EVENT_UUID, CommonEvents::BUILD_METER);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_HURT, EVENT_UUID);
    }

    public Lancer(Builder<?> builder)
    {
        super(builder);
    }
}
