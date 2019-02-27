package abilities;

import cards.Card;

public abstract class Abilities {

protected String ability;
protected String range;

public Abilities(String ability, String range) {
	setAbility(ability);
	setRange(range);}

public String getAbility() {
	return ability;}

public void setAbility(String ability) {
	this.ability = ability;}

public String getRange() {
	return range;}

public void setRange(String range) {
	this.range = range;}

public abstract int useOnSelf(Card card);

public abstract int useOnOther(Card card);

public abstract int useOnRow(Card card);

public abstract int inFirstRow(Card card);

public abstract int inSecondRow(Card card);

public abstract int inLastRow(Card card);

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getRange()).append(" ").append(getAbility());
	return builder.toString();
}



}
