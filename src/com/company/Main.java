package com.company;
//Imports
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Main Method
public class Main {
    static Scanner input;


    public static void main(String[] args) {
        input = new Scanner(System.in);
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int plPoints = 0;
        int comPoints = 0;
        int pl1Points = 0;
        int pl2Points = 0;
        int players;

        System.out.println("HOW MANY PLAYERS ARE PLAYING?");
        players = input.nextInt();

        if ((players > 2) || (players < 1)) {
            while (players > 2) {
                System.out.println("There are a maximum of 2 players");
                System.out.println("HOW MANY PLAYERS ARE PLAYING?");
                players = input.nextInt();
            }
            while (players < 1) {
                System.out.println("There are a minimum of 2 players");
                System.out.println("HOW MANY PLAYERS ARE PLAYING?");
                players = input.nextInt();
            }
        }

        if (players == 1) {
            System.out.println("THIS GAME IS FIRST TILL 3!");

            while ((plPoints < 3) && (comPoints < 3)) {
                int compInput = rand.nextInt(3) + 1;

                System.out.println("-------------------------------------------------------------");
                System.out.println("Your options are : ROCK, PAPER, or SCISSORS");
                System.out.println("What you would like to play?");

                String plInput = sc.next();
                String rock = "rock";
                String paper = "paper";
                String scissors = "scissors";

                if ((plInput.equals(rock) && compInput == 3) || (plInput.equals(paper) && compInput == 1) || (plInput.equals(scissors) && compInput == 2)) {
                    System.out.println("YOU GET ONE POINT!");
                    plPoints++;
                } else if ((compInput == 1 && plInput.equals(scissors)) || (compInput == 2 && plInput.equals(rock)) || (compInput == 3 && plInput.equals(paper))) {
                    System.out.println("COMPUTER GETS ONE POINT!");
                    comPoints++;
                } else if ((compInput == 1 && plInput.equals(rock)) || (compInput == 2 && plInput.equals(paper)) || (compInput == 3 && plInput.equals(scissors))) {
                    System.out.println("IT'S A DRAW!");
                }

                System.out.println("YOU: " + plPoints);
                System.out.println("COMPUTER: " + comPoints);

                if (plPoints == 3) {
                    System.out.println("==============================================================");
                    System.out.println("GREAT JOB! YOU WIN!");
                } else if (comPoints == 3) {
                    System.out.println("==============================================================");
                    System.out.println("NICE TRY, BUT COMPUTER WON!");
                }

                System.out.println("-----------------------------");
                System.out.println("Score:");
                System.out.println("YOU: " + plPoints);
                System.out.println("COMPUTER: " + comPoints);

            }
        }

        if (players == 2) {
            System.out.println("THIS GAME IS FIRST TILL 3!");

            System.out.println("Player 1, what is your name?");
            String player1name = sc.next();

            System.out.println("Player 2, what is your name?");
            String player2name = sc.next();

            while ((pl1Points < 3) && (pl2Points < 3)) {

                System.out.println("-------------------------------------------------------------");
                System.out.println("Your options are : ROCK, PAPER, or SCISSORS");
                System.out.println(player1name + ", what you would like to play?");
                String pl1Input = sc.next();
                clearScreen();

                System.out.println("-------------------------------------------------------------");
                System.out.println("Your options are : ROCK, PAPER, or SCISSORS");
                System.out.println(player2name + ", what you would like to play?");
                String pl2Input = sc.next();
                clearScreen();

                String rock = "rock";
                String paper = "paper";
                String scissors = "scissors";

                String Rock = "Rock";
                String Paper = "Paper";
                String Scissors = "Scissors";

                boolean pl1rock = (pl1Input.equals(rock) || pl1Input.equals(Rock));
                boolean pl1paper = (pl1Input.equals(paper) || pl1Input.equals(Paper));
                boolean pl1scissors = (pl1Input.equals(scissors) || pl1Input.equals(Scissors));

                boolean pl2rock = (pl2Input.equals(rock) || pl2Input.equals(Rock));
                boolean pl2paper = (pl2Input.equals(paper) || pl2Input.equals(Paper));
                boolean pl2scissors = (pl2Input.equals(scissors) || pl2Input.equals(Scissors));

                boolean pl1wins = (pl1rock && pl2scissors) || (pl1paper && pl2rock) || (pl1scissors && pl2paper);
                boolean pl2wins = (pl2rock && pl1scissors) || (pl2paper && pl1rock) || (pl2scissors && pl1paper);

                if (pl1wins) {
                    System.out.println("PLAYER 1 GETS ONE POINT!");
                    pl1Points++;
                } else if (pl2wins) {
                    System.out.println("PLAYER 2 GETS ONE POINT!");
                    pl2Points++;
                } else if (pl2Input.equals(pl1Input)) {
                    System.out.println("IT'S A DRAW!");
                }

                System.out.println("----------------------");
                System.out.println(player1name + ": " + pl1Points);
                System.out.println(player2name + ": " + pl2Points);

                try {
                    TimeUnit.SECONDS.sleep(3);
                    clearScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (pl1Points == 3) {
                System.out.println("==============================================================");
                System.out.println("CONGRATULATIONS, " + player1name + "! YOU WIN!");
            } else if (pl2Points == 3) {
                System.out.println("==============================================================");
                System.out.println("CONGRATULATIONS, " + player2name + "! YOU WIN!");
            }

            System.out.println("-----------------------------");
            System.out.println("Score:");
            System.out.println(player1name + ": " + pl1Points);
            System.out.println(player2name + ": " + pl2Points);
        }
    }

    static void clearScreen() {
        for(int clear = 0; clear < 5; clear++)
        {
            System.out.println("\b") ;
        }
    }
}