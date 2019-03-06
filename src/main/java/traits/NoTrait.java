package traits;

import cards.Card;

public class NoTrait extends Trait{

public NoTrait() {
	super("", null, 0, 0, false, false);}

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
