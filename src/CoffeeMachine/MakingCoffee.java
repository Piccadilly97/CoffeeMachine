package CoffeeMachine;

import CoffeeMachine.Display.DisplayConclusion;

public class MakingCoffee {
    private static double grainsResult;

    public static void setGrainsResult(double grainsResultIn) {
        grainsResult = grainsResultIn;
    }

    public static double getGrainsResult() {
        return grainsResult;
    }

    private static double milkResult;

    public static void setMilkResult(double milkResultIn) {
        milkResult = milkResultIn;
    }

    public static double getMilkResult() {
        return milkResult;
    }

    private static double sugarResult;

    public static void setSugarResult(double sugarResultIn) {
        sugarResult = sugarResultIn;
    }

    public static double getSugarResult() {
        return sugarResult;
    }

    public static String print="";
    public static void makingCoffee(int num) {
        CoffeeStorage b = new CoffeeStorage();
        if (num == 1) {
            System.out.println(print + "в колличестве " + num + " штуки");
            System.out.println(DisplayConclusion.WARNING);

        }
        if (num > 1) {
            System.out.println(print + "в колличестве " + num + " штук");
            System.out.println(DisplayConclusion.WARNING);
        }
        b.setGrains(b.getGrains() - b.getGrains() - MakingCoffee.getGrainsResult());
        b.setMilk(b.getMilk() - b.getMilk() - MakingCoffee.getMilkResult());
        b.setSugar(b.getSugar() - b.getSugar() - MakingCoffee.getSugarResult());
    }
}

