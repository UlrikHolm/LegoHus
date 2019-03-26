package FunctionLayer;

public class Calculate {

    public static  int[] blocks (House house) {

        int length = house.getLenght();
        int width = house.getWidth();
        int high = house.getHeight();
        int metode = 1;
        int[] result = new int[3];
        String[] prString = new String[4];

        int[] sumBlocks = new int[3];
        int antalFourF = 0;
        int antalTwoF = 0;
        int antalOneF = 0;
        int antalFourG = 0;
        int antalTwoG = 0;
        int antalOneG = 0;
        int antalFourAll = 0;
        int antalTwoAll = 0;
        int antalOneAll = 0;
        int typeF = 0;
        int typeG = 0;

        if (metode==1){typeF=1; typeG=2;}
        if (metode==2){typeF=2; typeG=1;}

        result = antalBlocks(typeF, length, high);

        antalFourF = antalFourAll + result[0];
        antalTwoF = antalTwoAll + result[1];
        antalOneF = antalOneAll + result[2];

        result = antalBlocks(typeG, width, high);

        antalFourG = antalFourAll + result[0];
        antalTwoG = antalTwoAll + result[1];
        antalOneG = antalOneAll + result[2];

        sumBlocks[0] = 2*(antalFourF + antalFourG);
        sumBlocks[1] = 2*(antalTwoF + antalTwoG);
        sumBlocks[2] = 2*(antalOneF + antalOneG);

        return sumBlocks;

        /*System.out.println("Antal four-blok Facade = " + antalFourF);
        System.out.println("Antal two-blok Facade = " + antalTwoF);
        System.out.println("Antal one-blok Facade = " + antalOneF);


        System.out.println("Antal four-blok Gavl = " + antalFourG);
        System.out.println("Antal two-blok Gavl = " + antalTwoG);
        System.out.println("Antal one-blok Gavl = " + antalOneG);


        System.out.println("Antal four-blok = " + antalFourAll);
        System.out.println("Antal two-blok = " + antalTwoAll);
        System.out.println("Antal one-blok = " + antalOneAll);
*/

        /*

// PRINTING ------------------------------------------------------------
        prString = printWall(typeF, length, high);

        String smallLineF= prString[0];
        String bigLineF = prString[1];
        String smallF = prString[2];
        String bigF = prString[3];

        prString = printWall(typeG, width, high);

        String smallLineG= prString[0];
        String bigLineG = prString[1];
        String smallG = prString[2];
        String bigG = prString[3];

        int Row = high/2;

        System.out.println();

        System.out.print("FACADE");
        for (int i = 0; i <length-5 ; i++) {
            System.out.print(" ");
        }
        System.out.print("                    "+"GAVL");
        System.out.println();

        if (high % 2 == 0) {
            if (metode == 1) System.out.println(smallLineF+"                    "+bigLineG);
            if (metode == 2) System.out.println(bigLineF+"                    "+smallLineG);
        } else {
            if (metode == 1) {
                System.out.println(bigLineF+"                    "+smallLineG);
                System.out.println(bigF+"                    "+smallG);
            }
            if (metode == 2) {
                System.out.println(smallLineF+"                    "+bigLineG);
                System.out.println(smallF+"                    "+bigG);
            }
        }

        for (int i = 0; i < Row; i++) {
            if (metode == 1) {
                System.out.println(smallF +"                    "+bigG);
                System.out.println(bigF+"                    "+smallG);
            }
            {
                if (metode == 2) {
                    System.out.println(bigF+"                    "+smallG);
                    System.out.println(smallF+"                    "+bigG);
                }
            }
        }*/

    }


    public static int[] antalBlocks(int type, int l, int h) {
        int bigFour = 0;
        int bigNumberFour = 0;
        int bigNumberTwo = 0;
        int bigNumberOne = 0;
        int smallFour = 0;
        int smallNumberFour = 0;
        int smallNumberTwo = 0;
        int smallNumberOne = 0;
        int rest = 0;

        int bigRow = 0;
        int smallRow = 0;

        int[] result = new int[3];

        if (h % 2 == 0) {
            bigRow = h / 2;
            smallRow = h / 2;
        } else {
            if (type == 1) {
                bigRow = h / 2 + 1;
                smallRow = h / 2;
            }
            if (type == 2) {
                bigRow = h / 2;
                smallRow = h / 2 + 1;
            }
        }
        //System.out.println("bigRow = " + bigRow + "   smallRow = " + smallRow);

        rest = l % 4;

        if (rest == 0) {
            bigNumberOne = 0;
            bigNumberTwo = 0;
            bigNumberFour = 1;
            smallNumberOne = 0;
            smallNumberTwo = 0;
            smallNumberFour = 1;
        }

        if (rest == 1) {
            bigNumberOne = 1;
            bigNumberTwo = 0;
            bigNumberFour = 1;
            smallNumberOne = 1;
            smallNumberTwo = 0;
            smallNumberFour = 1;
        }

        if (rest == 2) {
            bigNumberOne = 0;
            bigNumberTwo = 1;
            bigNumberFour = 1;
            smallNumberOne = 2;
            smallNumberTwo = 0;
            smallNumberFour = 1;
        }

        if (rest == 3) {
            bigNumberOne = 1;
            bigNumberTwo = 1;
            bigNumberFour = 1;
            smallNumberOne = 1;
            smallNumberTwo = 1;
            smallNumberFour = 1;
        }

        bigFour = (l - rest) / 4;
        smallFour = bigFour - 1;

        //System.out.println("bigFour = " + bigFour + " smallFour = " + smallFour);

        result[0] = bigRow * (bigFour - 1 + bigNumberFour) + smallRow * (smallFour - 1 + smallNumberFour);
        result[1] = bigRow * bigNumberTwo + smallRow * smallNumberTwo;
        result[2] = bigRow * bigNumberOne + smallRow * smallNumberOne;

        return result;
    }

    /*public static String[] printWall(int type, int l, int h) {

        final String four = "|___";
        final String two = "|_";
        final String one = "|";
        final String end = "|";

        String bigStart = "";
        String bigEnd = "";
        String smallStart = "";
        String smallEnd = "";
        String bigLinieStart = "";
        String bigLinieEnd = "";
        String smallLinieStart = "";
        String smallLinieEnd = "";

        String[] prString = new String[4];

        int bigFour = 0;
        int smallFour = 0;

        int rest = 0;


        rest = l % 4;
        bigFour = (l - rest) / 4;
        smallFour = bigFour - 1;

        if (rest == 0) {
            bigEnd = four;
            smallEnd = four + two;
            bigLinieEnd = " ___ ";
            smallLinieEnd = " ___ _ ";
        }

        if (rest == 1) {
            bigEnd = (one + four);
            smallEnd = (four + one + two);
            bigLinieEnd = "  ___ ";
            smallLinieEnd = " ___  _ ";
        }

        if (rest == 2) {
            bigEnd = (two + four);
            smallEnd = (one + four + one + two);
            bigLinieEnd = " _ ___ ";
            smallLinieEnd = "  ___  _ ";
        }

        if (rest == 3) {
            bigEnd = (two + one + four);
            smallEnd = (one + two + four + two);
            bigLinieEnd = " _  ___ ";
            smallLinieEnd = "  _ ___ _ ";
        }

        for (int i = 0; i < bigFour - 1; i++) {
            bigStart = bigStart + four;
            bigLinieStart = bigLinieStart + " ___";
        }

        for (int i = 0; i < smallFour - 1; i++) {
            smallStart = smallStart + four;
            smallLinieStart = smallLinieStart + " ___";
        }

        prString[0] = " _" + smallLinieStart + smallLinieEnd;
        prString[1] = bigLinieStart + bigLinieEnd;
        prString[2] = two + smallStart + smallEnd + end;
        prString[3] = bigStart + bigEnd + end;

        return prString;

    }
*/

}



