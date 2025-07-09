package designPatterns.Decorator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Icecream ic = new ChocolateSyrup(
                            new ChocolateScoop(
                                    new OrangeCone(
                                            new ChocolateSyrup(
                                                    new VanillaCone()))));

        System.out.println("Cost : " + ic.getCost());
        System.out.println("Desc : " + ic.getDescription());

        Scanner sc = new Scanner(System.in);

        Icecream ic2 = null;

        System.out.println("Please select a cone : 1. Vanilla Cone and 2. Orange Cone");
        int choice = sc.nextInt();
        if(choice == 1) {
            ic2 = new VanillaCone();
        } else {
            ic2 = new ChocolateScoop(ic2);
        }
    }
}
