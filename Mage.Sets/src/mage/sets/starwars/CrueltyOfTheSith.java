/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.starwars;

import java.util.UUID;
import mage.abilities.Mode;
import mage.abilities.effects.common.CounterTargetEffect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.effects.common.SacrificeEffect;
import mage.abilities.effects.common.discard.DiscardTargetEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.filter.FilterSpell;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.target.TargetPlayer;
import mage.target.TargetSpell;

/**
 *
 * @author Styxo
 */
public class CrueltyOfTheSith extends CardImpl {

    private static final FilterSpell filterNoncreature = new FilterSpell("noncreature spell");

    static {
        filterNoncreature.add(Predicates.not(new CardTypePredicate(CardType.CREATURE)));
    }

    public CrueltyOfTheSith(UUID ownerId) {
        super(ownerId, 190, "Cruelty of the Sith", Rarity.UNCOMMON, new CardType[]{CardType.INSTANT}, "{U}{B}{R}");
        this.expansionSetCode = "SWS";

        // Choose one - Counter target noncreature spell.
        this.getSpellAbility().addEffect(new CounterTargetEffect());
        this.getSpellAbility().addTarget(new TargetSpell(filterNoncreature));

        // Target player sacrifices a creture.
        Mode mode = new Mode();
        mode.getEffects().add(new SacrificeEffect(new FilterCreaturePermanent(), 1, "Target player"));
        mode.getTargets().add(new TargetPlayer());
        this.getSpellAbility().addMode(mode);

        // Cruelty of the Sith deals 3 damage to target player. That player discards a card.
        mode = new Mode();
        mode.getEffects().add(new DamageTargetEffect(3));
        mode.getEffects().add(new DiscardTargetEffect(1));
        mode.getTargets().add(new TargetPlayer());
        this.getSpellAbility().addMode(mode);

    }

    public CrueltyOfTheSith(final CrueltyOfTheSith card) {
        super(card);
    }

    @Override
    public CrueltyOfTheSith copy() {
        return new CrueltyOfTheSith(this);
    }
}