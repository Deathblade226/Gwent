package traits;

import cards.Card;

public class DeathWish extends Trait{ //name,summon,totalSummon,charges,useOnPlace,useOnDeath

public DeathWish(String name) {
	super(name, null, 0, 0, false, true, "DeathWish");}

@Override
public void useAbility(Card card) {
	
}

@Override
public int setCharges(Card card) {
	
return 0;}

@Override
public int useCharge(Card card) {
	
return 0;}

@Override
public int summon(Card card) {

return 0;}

	
}
