package CoffeeMachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {
    public static void Admin() {
        Scanner scanner = new Scanner(System.in);
        CoffeStorage c = new CoffeStorage();
        System.out.println("Добро пожаловать в меню для администрирования кофейни");
        int y = 0;
        while (y < 1) {
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
                Admin();
            }
            if(input1.equals("4")) {
                int z = 0;
                while (z < 2) {
                    System.out.println("\nНажмите:\n1-история заказов\n2-детализация затрат\n3-общие затраты\n4-вся статистика\n5-выход в меню");
                    Scanner scanner1 = new Scanner(System.in);
                    String sc1 = scanner1.next();
                    if (sc1.equals("1")) {
                    statisticsOut();
                    }
                    if (sc1.equals("2")) {
                        storageStatisticOutput();
                    }
                    if (sc1.equals("3")) {
                        costsOut();
                    }
                    if(sc1.equals("4")) {
                        statisticsOut();
                        storageStatisticOutput();
                        costsOut();
                    }
                    if (sc1.equals("5")) {
                        break;
                    }
                }
            }
            else {
                System.out.println("Кажется вы допустили ошибку, введите снова или выйдете в главное меню");
                System.out.println("Нажмите:\n1-вход в меню администрации\n2-выход в главное меню кофейни");
                String input2 = scanner.next();
                int x = 0;
                while (x < 3) {
                    if (input2.equals("1")) {
                        Admin();
                    }
                    if (input2.equals("2")) {
                        CoffeeCar.menu();
                        break;
                    }
                }
            }
        }
    }

    //метода для статистики заказов
    private static int orderNum = 1;
    static ArrayList<String> orders = new ArrayList<>();
    public static void statistics(String orderInfo) {
        String orderText = "Заказ №";
        orders.add(orderText + orderNum + orderInfo);
        orderNum += 1;
    }

    //МЕТОД ДЛЯ ПОКАЗА ЗАКАЗОВ
    public static void statisticsOut () {
        System.out.println("");
        for (String orderOut:orders) {
            System.out.println(orderOut);
        }
    }
     //МЕТОД ДЛЯ ЗАПОЛНЕНИЯ ЗАТРАТ
       static ArrayList<String> usedProducts = new ArrayList<>();
    public static void storageStatistic (String spentGrains, String spentMilk, String spentSugar) {
        String txt = "Наши затраты на заказ номер №";
        orderNum -= 1;
        usedProducts.add(txt + orderNum + spentGrains + spentMilk + spentSugar);
        orderNum++;
    }

    //МЕТОДА ДЛЯ ПОКАЗА ЗАТРАТ НА КАЖДЫЙ ЗАКАЗ
    public static void storageStatisticOutput () {
        System.out.println("\nИспользованные продукты:");
        for (String usedProductOut:usedProducts) {
            System.out.println(usedProductOut);
        }
    }
    //МЕТОД ДЛЯ СЧЁТА ОБЩИХ ЗАТРАТ
    static double totalCostsGrains;
    static double totalCostsMilk;
    static double totalCostsSugar;
    public static void totalCosts (double totalGrains, double totalMilk, double totalSugar) {
        totalCostsGrains += totalGrains;
        totalCostsMilk += totalMilk;
        totalCostsSugar += totalSugar;
    }
//МЕТОД ДЛЯ ПОКАЗА СУММЫ ВСЕХ ЗАТРАТ
    public static void costsOut () {
        System.out.println("\nВсего потраченно:\nЗерна: " + totalCostsGrains + "\nМолока: " + totalCostsMilk + "\nСахара: " + totalCostsSugar);
    }
}


