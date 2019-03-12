package traits;

import cards.Card;

public class NoTrait extends Trait{

public NoTrait(String name) {
	super(name);}

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
