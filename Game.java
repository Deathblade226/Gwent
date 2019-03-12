package models;

public class Game {

private String name;
private Player[] players = new Player[2];

public Game(String name) {
	this.setName(name);}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}

public Player[] getPlayers() {
return players;}

public void setPlayers(Player[] players) {
	this.players = players;}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getName());
	return builder.toString();}





}