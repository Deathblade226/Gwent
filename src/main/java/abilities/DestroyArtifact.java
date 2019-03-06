package abilities;

import cards.Card;

public class DestroyArtifact extends Abilities{ //We dont use this because of artifacts being just decoys

public DestroyArtifact(String ability, String range) {
	super(ability, range,0,0,0,0,null,0);}

@Override
public int useOnSelf(Card card) {
	card.setAlive(false);
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