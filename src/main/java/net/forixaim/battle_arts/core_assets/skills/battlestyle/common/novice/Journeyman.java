package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class Journeyman extends BattleStyle
{


    public Journeyman(SkillBuilder<?> builder) {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener listener) {
        super.onInitiate(container, listener);

        listener.registerEvent(EpicFightEventHooks.Entity.MODIFY_ATTACK_DAMAGE, event -> {
            if (!(event.getEntityPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND) instanceof WeaponCapability))
            {
                event.attachValueModifier(ValueModifier.adder(2));
            }
        }, this);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        super.onRemoved(container);
    }
}
