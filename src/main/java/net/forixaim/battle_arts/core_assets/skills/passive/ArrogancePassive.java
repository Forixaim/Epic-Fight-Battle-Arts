package net.forixaim.battle_arts.core_assets.skills.passive;

import com.mojang.blaze3d.vertex.PoseStack;
import net.forixaim.battle_arts.initialization.registry.BattleArtsDataKeys;
import net.minecraft.client.gui.GuiGraphics;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.passive.PassiveSkill;

public class ArrogancePassive extends PassiveSkill
{
	public ArrogancePassive(SkillBuilder<?> builder)
	{
		super(builder);
	}

	@Override
	public void onInitiate(SkillContainer container, EntityEventListener listener)
	{
		super.onInitiate(container, listener);

        listener.registerEvent(EpicFightEventHooks.Animation.BEGIN, event -> {
            if (!event.getEntityPatch().isLogicalClient())
                container.getDataManager().setDataSync(BattleArtsDataKeys.ANIM_ID, false);
        }, this);

        listener.registerEvent(EpicFightEventHooks.Entity.DELIVER_DAMAGE_POST, event -> {
            if (!container.getDataManager().getDataValue(BattleArtsDataKeys.ANIM_ID))
            {
                container.getDataManager().setDataSync(BattleArtsDataKeys.ANIM_ID, true);
                if (container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK) < 10)
                    container.getDataManager().setDataSyncF(BattleArtsDataKeys.ARROGANCE_STACK, data -> data + 1);
            }
        }, this);

        listener.registerEvent(EpicFightEventHooks.Entity.MODIFY_ATTACK_SPEED, event -> {
            int stack = (int) (container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK) + 0.95f);
            float attackSpdBonus = 0.05f * stack;
            event.setAttackSpeed(event.getAttackSpeed() * (1 + attackSpdBonus));
        }, this);

        listener.registerEvent(EpicFightEventHooks.Entity.TAKE_DAMAGE_INCOME, event -> {
            int stack = (int) (container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK) + 0.95f);
            if (event.isParried())
            {
                if (container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK) < 10)
                {
                    container.getDataManager().setDataSyncF(BattleArtsDataKeys.ARROGANCE_STACK, data -> data + 1);
                }
            }
            else if (event.getResult() == AttackResult.ResultType.BLOCKED)
            {
                container.getDataManager().setDataSyncF(BattleArtsDataKeys.ARROGANCE_STACK, data -> data - 2);
                if (container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK) < 0)
                    container.getDataManager().setDataSync(BattleArtsDataKeys.ARROGANCE_STACK, 0f);

            }
            else if (event.getResult() == AttackResult.ResultType.SUCCESS)
            {
                container.getDataManager().setDataSync(BattleArtsDataKeys.ARROGANCE_STACK, 0f);
            }
        }, this);
	}

	@Override
	public void onRemoved(SkillContainer container)
	{
		super.onRemoved(container);
	}

	@Override
	public boolean shouldDraw(SkillContainer container)
	{
		return true;
	}

	@Override
	public void drawOnGui(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float pt)
	{
		PoseStack poseStack = guiGraphics.pose();
		poseStack.pushPose();
		guiGraphics.blit(getSkillTexture(), (int)x-4, (int)y-4, 36, 36, 0, 0, 1, 1, 1, 1);
		Float Heat = container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK);
		String Heat_Level = String.format("%.0f", Heat);
		guiGraphics.drawString(gui.getFont(), Heat_Level, x + 4, y + 6, 16777215, true);
		poseStack.popPose();
	}

	@Override
	public void updateContainer(SkillContainer container)
	{
		super.updateContainer(container);
		if (!container.getExecutor().isLogicalClient())
		{
			if (container.getDataManager().getDataValue(BattleArtsDataKeys.ARROGANCE_STACK) > 0)
				container.getDataManager().setDataSyncF(BattleArtsDataKeys.ARROGANCE_STACK, data -> data - 0.01f);

		}
	}
}
