package CoffeeMachine;

import java.util.Scanner;

public class AdminMenu {
    public static void AdminMenu() {
        Scanner scanner = new Scanner(System.in);
        CoffeeStorage c = new CoffeeStorage();
        System.out.println("Добро пожаловать в меню для администрирования кофейни");
        while (true) {
            System.out.println("Нажмите:\n1-меню поставок\n2-переход в кофемашину\n3-просмотр склада\n4-меню статистики");
            String input1 = scanner.next();
            if (input1.equals("1")) {
                c.shipment();
                break;
            }
            if (input1.equals("2")) {
                CoffeeCar.menu();
                break;
            }
            if (input1.equals("3")) {
                System.out.println(c.storageOutput() + "\n");
                AdminMenu();
            }
            if (input1.equals("4")) {
                while (true) {
                    System.out.println("\nНажмите:\n1-история заказов\n2-детализация затрат\n3-общие затраты\n4-выручка\n5-вся статистика\n6-выход в меню");
                    Scanner scanner1 = new Scanner(System.in);
                    String sc1 = scanner1.next();
                    if (sc1.equals("1")) {
                        CoffeeCarStatistics.statisticsOut();
                    }
                    if (sc1.equals("2")) {
                        CoffeeCarStatistics.storageStatisticOutput();
                    }
                    if (sc1.equals("3")) {
                        CoffeeCarStatistics.costsOut();
                    }
                    if (sc1.equals("4")) {
                        CoffeeCarStatistics.boxOfficePrint();
                    }
                    if (sc1.equals("5")) {
                        CoffeeCarStatistics.statisticsOut();
                        CoffeeCarStatistics.storageStatisticOutput();
                        CoffeeCarStatistics.boxOfficePrint();
                        CoffeeCarStatistics.costsOut();
                    }
                    if (sc1.equals("6")) {
                        break;
                    }
                }
            } else {
                System.out.println("Кажется вы допустили ошибку, введите снова или выйдете в главное меню");
                while (true) {
                    System.out.println("Нажмите:\n1-вход в меню администрации\n2-выход в главное меню кофейни");
                    String input2 = scanner.next();
                    if (input2.equals("1")) {
                        AdminMenu();
                    }
                    if (input2.equals("2")) {
                        CoffeeCar.menu();
                        break;
                    } else {
                        System.out.println("Вы допустили ошибку, введите снова");
                    }
                }
            }
        }
    }
}