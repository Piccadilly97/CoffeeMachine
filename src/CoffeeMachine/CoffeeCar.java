package CoffeeMachine;

import CoffeeMachine.Display.DisplayConclusion;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeCar {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        CoffeeCar c = new CoffeeCar();

        DisplayConclusion.helloMenu();  //ПРИВЕТСТВИЕ
        AdminService.checkStorage();       //ПРОВЕРКА НАЛИЧИЯ ПРОДУКТОВ НА СКЛАДЕ

        System.out.println(DisplayConclusion.NUM_OR_PASS);
        int x = 0;
        while (x < 3) {
            if (x > 0) {
                System.out.println(DisplayConclusion.REPEAT_PASSWORD);
                x = x - 1;
            }
            int menu = scanner.nextInt();
            if (menu == 1234) {
                AdminMenu.AdminMenu();
                x = x + 3;
            }
            if (menu > 999) {
                if (menu != 1234) {
                    System.out.println(DisplayConclusion.INVALID_PASSWORD);
                    System.out.println("Нажмите 1 для повтора попытки и 2 для перехода к заказу");
                    int menu1 = scanner.nextInt();
                    if (menu1 == 1) {
                        x = x + 1;
                    }
                    if (menu1 == 2) {
                        c.coffeeSelections();
                        return;
                    }
                }
            } else {
                c.coffeeSelections();
            }
        }
    }

    public void coffeeSelections() {
        CoffeeStorage b = new CoffeeStorage();
        Scanner scanner2 = new Scanner(System.in);

        //COFFEE INPUT
        Scanner scanner1 = new Scanner(System.in);
        String[] coffeeList = {"КАПУЧИНО", " ЛАТТЕ", " ЭСПРЕССО"};
        String str = String.join(",", coffeeList);
        String print = "";
        //переменная для статистики
        String orderHistory = " ";
        double price = 0;
        System.out.println("Какой кофе вы хотите?\nУ нас есть: " + str);
        String input = scanner1.next().toUpperCase();
        switch (input) {
            case "ЛАТТЕ" -> {
                MakingCoffee.print = "Вот ваш: Латте";
                MakingCoffee.setGrainsResult(1);
                MakingCoffee.setMilkResult(2);
                orderHistory = " Латте ";
                price = 150;
            }
            //ошибочный набор слова латте
            case "KFNNT" -> {
                System.out.println("Вы имели ввиду Латте?\nНажмите 1 если да, и 2 если нет");
                String error = scanner1.next();
                if (error.equals("1")) {
                    MakingCoffee.print = "Вот ваш: Латте";
                    MakingCoffee.setGrainsResult(1);
                    MakingCoffee.setMilkResult(2);
                    orderHistory = " Латте ";
                    price = 150;
                } else {
                    System.out.println(DisplayConclusion.TRY_AGAIN);
                    coffeeSelections();
                }
            }
            case "КАПУЧИНО" -> {
                MakingCoffee.print = "Вот ваш: Капучино";
                MakingCoffee.setGrainsResult(2);
                MakingCoffee.setMilkResult(1);
                orderHistory = " Капучино ";
                price = 140;
            }
            //ошибочный набор слова капучино
            case "RFGEXBYJ" -> {
                System.out.println("Вы имели ввиду Капучино?\nНажмите 1 если да, и 2 если нет");
                String error2 = scanner1.next();
                if (error2.equals("1")) {
                    MakingCoffee.print = "Вот ваш: Капучино";
                    MakingCoffee.setGrainsResult(2);
                    MakingCoffee.setMilkResult(1);
                    orderHistory = " Капучино ";
                    price = 140;
                } else {
                    System.out.println(DisplayConclusion.TRY_AGAIN);
                    coffeeSelections();
                }
            }
            case "ЭСПРЕССО" -> {
                MakingCoffee.print = "Вот ваш: Эспрессо";
                MakingCoffee.setGrainsResult(3);
                orderHistory = " Эспрессо ";
                price = 130;
            }
            //ошибочный набор слова эспрессо
            case "'CGHTCCJ" -> {
                System.out.println("Вы имели ввиду Эспрессо?\nНажмите 1 если да и 2 если нет");
                String error3 = scanner1.next();
                if (error3.equals("1")) {
                    MakingCoffee.print = "Вот ваш: Эспрессо";
                    MakingCoffee.setGrainsResult(3);
                    orderHistory = " Эспрессо ";
                    price = 130;
                } else {
                    System.out.println(DisplayConclusion.TRY_AGAIN);
                    coffeeSelections();
                }
            }
            default -> {
                System.out.println("Увы, такого кофе у нас нету:(((");
                AdminService.error();
            }
        }
        //VOLUME
        int[] volume = {200, 300, 400};
        String volumeStr = Arrays.toString(volume).replaceAll("[\\[\\]]", "");
        System.out.println("Какой объём кофе вы желаете?");
        System.out.println("У нас есть: " + volumeStr + " миллилитров");
        String volumeIn = scanner2.next();
        switch (volumeIn) {
            case "200", "1" -> {
                MakingCoffee.print += ", объёмом 200 миллилитров ";
                orderHistory += "200 мл";
            }
            case "300", "2" -> {
                MakingCoffee.print += ", объёмом 300 миллилитров ";
                MakingCoffee.setGrainsResult(MakingCoffee.getGrainsResult()*1.5);
                MakingCoffee.setMilkResult(MakingCoffee.getMilkResult()*1.5);
                orderHistory += "300 мл";
                price = price * 1.5;
            }
            case "400", "3" -> {
                MakingCoffee.print += ", объёмом 400 миллилитров ";
                MakingCoffee.setGrainsResult(MakingCoffee.getGrainsResult()*2);
                MakingCoffee.setMilkResult(MakingCoffee.getMilkResult()*2);
                orderHistory += "400 мил";
                price = price * 1.7;
            }
            default -> {
                System.out.println("Кажется, такого объёма у нас нету((");
                AdminService.error();
            }
        }
        //SUGAR
        System.out.println("Сколько сахара вам положить?");
        int sugarNum = scanner1.nextInt();

        if (sugarNum > -1) {
            MakingCoffee.setSugarResult(sugarNum);
            orderHistory += " " + "," + sugarNum + " сахар(а)";
        } else {
            System.out.println("Кажется вы выбрали колличество сахара менее чем 0");
            AdminService.error();
        }
        //QUANTITY
        System.out.println("Сколько кофе вы хотите?");
        int num = scanner2.nextInt();

        if (num < 1) {
            System.out.println(DisplayConclusion.NUM_LESS_ZERO);
            AdminService.error();
        }
        price = price * num;
        //передаём выбор пользователя в саму кофемашину
        MakingCoffee.setSugarResult(MakingCoffee.getSugarResult()*num);
        MakingCoffee.setMilkResult(MakingCoffee.getMilkResult()*num);
        MakingCoffee.setGrainsResult(MakingCoffee.getGrainsResult()*num);

        AdminService.comparisonResult(MakingCoffee.getGrainsResult(), MakingCoffee.getMilkResult(), MakingCoffee.getSugarResult());

        AdminService.payment(price);
        MakingCoffee.makingCoffee(num);


            //Statistic operation
            String ordersOutput = ":" + " " + num + orderHistory;
            String spentGrains = " зерно:" + MakingCoffee.getGrainsResult();
            String spentMilk = " молоко:" + MakingCoffee.getMilkResult();
            String spentSugar = " сахар(а):" + MakingCoffee.getSugarResult();

            //STORAGE INFO
            System.out.println(b.storageOutput());
            CoffeeCarStatistics.statistics(ordersOutput);
            CoffeeCarStatistics.storageStatistic(spentGrains, spentMilk, spentSugar);
            CoffeeCarStatistics.totalCosts(MakingCoffee.getGrainsResult(), MakingCoffee.getMilkResult(), MakingCoffee.getSugarResult());
            CoffeeCarStatistics.boxOffice(price,AdminService.cardOfCash);

            AdminService.repeatOrder();

        }


}