package traits;

import cards.Card;

public class Deploy extends Trait{

public Deploy(String name, Card summon, int totalSummons, int charges, boolean useOnPlace, boolean useOnDeath) {
	super(name, summon, totalSummons, charges, useOnPlace, useOnDeath);}

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
