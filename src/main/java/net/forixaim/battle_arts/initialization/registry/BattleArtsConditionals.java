package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.*;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.ex_cap.provider.ProviderConditional;
import yesman.epicfight.api.ex_cap.provider.ProviderConditionalType;
import yesman.epicfight.registry.deferred.ProviderConditionalRegister;
import yesman.epicfight.registry.deferred.holders.DeferredConditional;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public final class BattleArtsConditionals {
    public static final ProviderConditionalRegister REGISTRY = ProviderConditionalRegister.create(BattleArts.MOD_ID);

    public static final DeferredConditional JOURNEYMAN_DEFAULT = REGISTRY.registerConditional(
            "journeyman_default",
            () -> ProviderConditional.createSkillCondition(
                    JourmeymanStyles.JOURNEYMAN_PRIMARY, // The Style to apply
                    BattleArtsSkills.JOURNEYMAN,            // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,                  // Usually Passives/Masteries, or the slot it occupies
                    false,                               // activeCheck: false = existence check
                    false                                // itemCapabilityCheck
            )
    );

    public static final DeferredConditional RECRUIT_DEFAULT = REGISTRY.registerConditional(
            "recruit_spear_check",
            () -> ProviderConditional.createSkillCondition(
                    RecruitWieldStyles.RECRUIT_SPEAR,     // The Style to apply
                    BattleArtsSkills.RECRUIT,                // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,    // The specific slot
                    false,                                // existence check (not active check)
                    false                                 // itemCapabilityCheck
            )
    );

    public static final DeferredConditional RECRUIT_SHIELD = REGISTRY.registerConditional(
            "recruit_spear_shield",
            () -> ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(RecruitWieldStyles.RECRUIT_SPEAR_SHIELD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            RECRUIT_DEFAULT.get(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.SHIELD)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final DeferredConditional SQUIRE_DEFAULT = REGISTRY.registerConditional(
            "squire_check",
            () -> ProviderConditional.createSkillCondition(
                    SquireWieldStyles.SQUIRE_SWORD,       // The Style to apply
                    BattleArtsSkills.SQUIRE,                // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,    // The specific slot
                    false,                                // existence check (not active check)
                    false                                 // itemCapabilityCheck
            )
    );

    public static final DeferredConditional DUELIST_DEFAULT = REGISTRY.registerConditional(
            "duelist_style_check",
            () -> ProviderConditional.createSkillCondition(
                    DuelistStyles.DUELIST_SWORD,
                    BattleArtsSkills.DUELIST,
                    BattleArtsSkillSlots.BATTLE_STYLE,
                    false,
                    false
            )
    );

    public static final DeferredConditional DUELIST_LONGSWORDS = REGISTRY.registerConditional(
            "duelist_dual_longswords",
            () -> ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.get(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.LONGSWORD)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final DeferredConditional DUELIST_UCHIGATANAS = REGISTRY.registerConditional(
            "duelist_dual_uchigatana",
            () -> ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.get(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.UCHIGATANA)
                    )
    );

    public static final DeferredConditional DUELIST_SWORDS = REGISTRY.registerConditional(
            "duelist_dual_swords",
            () -> ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.get(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.SWORD)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final DeferredConditional DUELIST_TACHIS = REGISTRY.registerConditional(
            "duelist_dual_tachi",
            () -> ProviderConditional.builder()
                    .setType(ProviderConditionalType.COMPOSITE)
                    .setWieldStyle(DuelistStyles.DUELIST_DUAL_SWORD)
                    .isVisibleOffHand(true)
                    .setProviderConditionals(
                            DUELIST_DEFAULT.get(),
                            ProviderConditional.builder()
                                    .setType(ProviderConditionalType.WEAPON_CATEGORY)
                                    .setCategory(CapabilityItem.WeaponCategories.TACHI)
                                    .setHand(InteractionHand.OFF_HAND)
                    )
    );

    public static final DeferredConditional LANCER_DEFAULT = REGISTRY.registerConditional(
            "lancer_default",
            () -> ProviderConditional.createSkillCondition(
                    LancerStyles.LANCER_WEAPON_ART,       // The Style to apply
                    BattleArtsSkills.LANCER,                // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,    // The specific slot
                    false,                                // existence check (not active check)
                    false                                 // itemCapabilityCheck
            )
    );

    public static final DeferredConditional MERCENARY_DEFAULT = REGISTRY.registerConditional(
            "mercenary_default",
            () -> ProviderConditional.createSkillCondition(
                    MercenaryStyles.MERCENARY_WEAPON_ART,       // The Style to apply
                    BattleArtsSkills.MERCENARY,                // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,    // The specific slot
                    false,                                // existence check (not active check)
                    false                                 // itemCapabilityCheck
            )
    );

    public static final DeferredConditional RONIN_DEFAULT = REGISTRY.registerConditional(
            "ronin_style_default",
            () -> ProviderConditional.createSkillCondition(
                    RoninStyles.TRANQUIL_STATE,
                    BattleArtsSkills.RONIN,
                    BattleArtsSkillSlots.BATTLE_STYLE,
                    false,
                    false
            )
    );

    public static final DeferredConditional RONIN_SHEATH = REGISTRY.registerConditional(
            "ronin_style_sheath",
            () -> ProviderConditional.builder()
                    .setType(ProviderConditionalType.DATA_KEY)
                    .setWieldStyle(RoninStyles.SCATTER_STATE)
                    .isVisibleOffHand(false)
                    .setSlot(BattleArtsSkillSlots.BATTLE_STYLE)
                    .setKey(BattleArtsDataKeys.TRANQUILITY_SHEATH)
    );

    public static final DeferredConditional THIEF_DEFAULT = REGISTRY.registerConditional(
            "thief_style_check",
            () -> ProviderConditional.createSkillCondition(
                    ThiefStyles.THIEF_WEAPON,             // The Style to apply
                    BattleArtsSkills.THIEF,                  // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,    // The specific slot
                    false,                                // existence check
                    false                                 // itemCapabilityCheck
            )
    );

    public static final DeferredConditional FIGHTER_DEFAULT = REGISTRY.registerConditional(
            "fighter_default",
            () -> ProviderConditional.createSkillCondition(
                    FighterStyles.FIGHTER_WEAPON_ART,     // The Style to apply
                    BattleArtsSkills.FIGHTER,                // The Skill to check for
                    BattleArtsSkillSlots.BATTLE_STYLE,    // The specific slot
                    false,                                // existence check
                    false                                 // itemCapabilityCheck
            )
    );
}
