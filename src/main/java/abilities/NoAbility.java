package abilities;

import cards.Card;

public class NoAbility extends Abilities{

public NoAbility() {super("Nothing", "Nothing");}

@Override
public int useOnSelf(Card card) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int useOnOther(Card card) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int useOnRow(Card card) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int inFirstRow(Card card) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int inSecondRow(Card card) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int inLastRow(Card card) {
	// TODO Auto-generated method stub
	return 0;
}	

}
