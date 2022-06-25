package models;

public class Hello {
    public static void main(String[] args) {
        magenDavid(13);
        printFigure(11);
    }

    public static void printFigure(int number){
        for(int i = 0; i < number; i++){

            for(int j = 0; j < number; j++){
                if(i == j || i == 0 || j == 0 || i == number -1 || j == number - 1 || number - j - 1 == i ||
                        j > i && number - j - 1 > i || i > j && number - i - 1 < j){
                    System.out.print("* ");
                   // System.out.print(" ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void magenDavid(int num){
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(i == 0 && (j != 0 && j == (num-3) / 2) ){
                        System.out.print("*");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
