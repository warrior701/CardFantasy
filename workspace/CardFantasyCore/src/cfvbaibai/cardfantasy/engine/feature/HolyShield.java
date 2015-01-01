package cfvbaibai.cardfantasy.engine.feature;

import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.data.Skill;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.EntityInfo;
import cfvbaibai.cardfantasy.engine.SkillResolver;
import cfvbaibai.cardfantasy.engine.SkillUseInfo;

public final class HolyShield {
    public static boolean apply(SkillUseInfo skillUseInfo, SkillResolver resolver, EntityInfo attacker, CardInfo victim) {
        if (victim == null) {
            return false;
        }
        if (victim.hasUsed(skillUseInfo)) {
            return false;
        }
        Skill skill = skillUseInfo.getSkill();
        GameUI ui = resolver.getStage().getUI();
        ui.useSkill(victim, skill, true);
        victim.setUsed(skillUseInfo);
        return true;
    }
}
