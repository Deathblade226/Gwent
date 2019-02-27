package abilities;

import cards.Card;

public class Stacking extends Abilities{

private int buff;	
	
public Stacking(String ability, String range, int buff) {
	super(ability, range);
	setBuff(buff);}

@Override
public int useOnSelf(Card card) {
	card.buff(buff);
return 0;}

@Override
public int useOnOther(Card card) {
	
return 0;}

@Override
public int useOnRow(Card card) {

return 0;}

@Override
public int inFirstRow(Card card) {

return 0;}

@Override
public int inSecondRow(Card card) {

return 0;}

@Override
public int inLastRow(Card card) {

return 0;}

public int getBuff() {
return buff;}

public void setBuff(int buff) {
	this.buff = buff;}
	
}
