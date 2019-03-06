package controllers;

public class GameMaster {

public static void run() {
	menu();
}

public static void menu() {
	boolean running = true;
	String[] options = {"1 Player","2 Player","Help","Exit"};
do {System.out.println("Gwent - Neumont Edition:");
	int in = lib.ConsoleIO.promptForMenuSelection(options, true);
	switch(in) {
	case 1: System.out.println("WIP"); break; //lib.ConsoleIO.lineBuilder("=", 40); Game.start(1);
	case 2: lib.ConsoleIO.lineBuilder("=", 40); Game.start(2); break;
	case 3: break;
	case 4: running = false; break;}
}while(running);}}
