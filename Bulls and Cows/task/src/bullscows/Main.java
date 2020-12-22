package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BullsCowsGame bcgame = new BullsCowsGame(scanner);
        bcgame.playBCgame();
    }
}

class BullsCowsGame {
    Scanner scanner;
    String secretCode;
    int turnCount;

    public BullsCowsGame(Scanner scanner) {
        this.secretCode = sCodeFourDiffDigits();
        this.turnCount = 0;
        this.scanner = scanner;
    }

    String sCodeFourDiffDigits() {
        return "9305";
    }

    void playBCgame() {
        System.out.println("The secret code is prepared: ****.");
        while (true) {
            incrementTurnCount();
            System.out.printf("Turn %d. Answer:\n", turnCount);

            int Answer = scanner.nextInt();

            int[] bc = gradeAnswer(Answer);

            String Grade = "";

            if (bc[0] == 0 && bc[1] == 0) {
                Grade = "None";
            } else {

                if (bc[0] > 0) {

                    if (bc[0] == 1) {
                        Grade += "1 bull";
                    } else {
                        Grade += bc[0] + " bulls";
                    }

                    if (bc[1] == 1) {
                        Grade += " and 1 cow";
                    } else if (bc[1] != 0) {
                        Grade += " and " + bc[1] + " cows";
                    }

                } else {

                    if (bc[1] == 1) {
                        Grade += "1 cow";
                    } else if (bc[1] != 0) {
                        Grade += bc[1] + " cows";
                    }
                }
            }

            //System.out.printf("Grade: %s.\n", Grade);

            //temp to satisfy Stage 2 test
            System.out.printf("Grade: %s. The secret code is %s.\n", Grade, sCodeFourDiffDigits());
            break;

            /*if (bc[0] == 4) {
                System.out.printf("Congrats! The secret code is %s.\n", secretCode);
                break;
            }*/
        }
    }

    int[] gradeAnswer(int Answer) {
        int[] BullsCows = {0, 0};
        String sAnswer = Integer.toString(Answer);
        for (int i = 0; i < 4; i++) {
            if (sAnswer.charAt(i) == secretCode.charAt(i)) {
                BullsCows[0] += 1;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (sAnswer.charAt(i) == secretCode.charAt(j)) {
                        BullsCows[1] += 1;
                    }
                }
            }
        }
        return BullsCows;
    }

    void incrementTurnCount() {
        this.turnCount += 1;
    }
}
