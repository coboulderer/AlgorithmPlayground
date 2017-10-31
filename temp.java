package rk.algos.codewars;

//sample regex pattern to use t[mqdzj][^j]*
public class AlphabetWars {

    private static String myBattleField;

    public static String woLoLoooooo(String battlefield) {
        myBattleField = battlefield;
        handlePriestChars();
        //sum up left side
        //sum right side
        //compare scores
        return myBattleField;
    }

    private static void handlePriestChars() {
        if (myBattleField.matches("(t|j)")) {
            lookForT();
            lookForJ();
        }
    }

    private static String lookForT() {
        int index = myBattleField.indexOf("t", 0);
        while (index != -1) {
            if (index == 0) {
                if (myBattleField.charAt(2) != 'j' && isRightSideChar(1)) {
                    swapLeftForRight(1);
                }
            } else if (index == 1){
                if (isRightSideChar(index - 1)) {
                    swapLeftForRight(index - 1);
                }
                if (myBattleField.charAt(index + 2) != 'j' && isRightSideChar(index + 1)) {
                    swapLeftForRight(index + 1);
                }
            } else if (index == myBattleField.length() - 1) {

            } else if (index == myBattleField.length() - 1) {

            } else {

            }
            index = myBattleField.indexOf("t", index + 1);
        }
        return myBattleField;
    }

    private static boolean isRightSideChar(int index) {
        if (myBattleField.charAt(index) == 'm' || myBattleField.charAt(index) == 'q' ||
            myBattleField.charAt(index) == 'd' || myBattleField.charAt(index) == 'z') {
            return true;
        } else {
            return false;
        }
    }

    private static void swapLeftForRight(int index) {
        StringBuilder swapper = new StringBuilder(myBattleField);
        if (myBattleField.charAt(index) == 'm') {
            swapper.setCharAt(index, 'w');
        } else if (myBattleField.charAt(index) == 'q') {
            swapper.setCharAt(index, 'p');
        } else if (myBattleField.charAt(index) == 'd') {
            swapper.setCharAt(index, 'b');
        } else if (myBattleField.charAt(index) == 'z') {
            swapper.setCharAt(index, 's');
        }
    }

    private static boolean isLeftSideChar(int index) {
        if (myBattleField.charAt(index) == 'w' || myBattleField.charAt(index) == 'p' ||
            myBattleField.charAt(index) == 'b' || myBattleField.charAt(index) == 's') {
            return true;
        } else {
            return false;
        }
    }

    private static void swapRightForLeft(int index) {
        StringBuilder swapper = new StringBuilder(myBattleField);
        if (myBattleField.charAt(index) == 'w') {
            swapper.setCharAt(index, 'm');
        } else if (myBattleField.charAt(index) == 'p') {
            swapper.setCharAt(index, 'q');
        } else if (myBattleField.charAt(index) == 'b') {
            swapper.setCharAt(index, 'd');
        } else if (myBattleField.charAt(index) == 's') {
            swapper.setCharAt(index, 'z');
        }
    }

    private static void lookForJ() {

    }
}
