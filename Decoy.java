package abilities;

import cards.Card;

public class Decoy extends Abilities{

public Decoy(String ability, String range) {
	super(ability, range);}

@Override
public int useOnSelf(Card card) {

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

@Override
public Card createCard(Card card) {
	
return null;}

}