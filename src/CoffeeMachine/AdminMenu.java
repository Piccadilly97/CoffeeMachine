package CoffeeMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {
    public static void Admin() {
        Scanner scanner = new Scanner(System.in);
        CoffeStorage c = new CoffeStorage();
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
                Admin();
            }
            if(input1.equals("4")) {
                while (true) {
                    System.out.println("\nНажмите:\n1-история заказов\n2-детализация затрат\n3-общие затраты\n4-выручка\n5-вся статистика\n6-выход в меню");
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
                    if (sc1.equals("4")) {
                        boxOfficePrint();
                    }
                    if(sc1.equals("5")) {
                        statisticsOut();
                        storageStatisticOutput();
                        boxOfficePrint();
                        costsOut();
                    }
                    if (sc1.equals("6")) {
                        break;
                    }
                }
            }
            else {
                System.out.println("Кажется вы допустили ошибку, введите снова или выйдете в главное меню");
                while (true) {
                    System.out.println("Нажмите:\n1-вход в меню администрации\n2-выход в главное меню кофейни");
                    String input2 = scanner.next();
                    if (input2.equals("1")) {
                        Admin();
                    }
                    if (input2.equals("2")) {
                        CoffeeCar.menu();
                        break;
                    }
                    else {
                        System.out.println("Вы допустили ошибку, введите снова");
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
       if(orders.isEmpty()) {
           System.out.println("Пока что заказов не было, скорее переходите в кофемашину");
       }
        for (String orderOut:orders) {
            System.out.println(orderOut);
        }
    }
     //МЕТОД ДЛЯ ЗАПОЛНЕНИЯ ЗАТРАТ
       static ArrayList<String> usedProducts = new ArrayList<>();
    public static void storageStatistic (String spentGrains, String spentMilk, String spentSugar) {
        String txt = "Заказ номер №";
        orderNum -= 1;
        usedProducts.add(txt + orderNum + spentGrains + spentMilk + spentSugar);
        orderNum++;
    }

    //МЕТОДА ДЛЯ ПОКАЗА ЗАТРАТ НА КАЖДЫЙ ЗАКАЗ
    public static void storageStatisticOutput () {
        System.out.println("\nИспользованные продукты:");
        if (orders.isEmpty()) {
            System.out.println("У нас не было затарат на заказы");
        }
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
        if (totalCostsMilk == 0||totalCostsSugar == 0||totalCostsGrains == 0) {
            System.out.println("\nМы не тратили продукты за последний период");
        }
        System.out.println("\nВсего потраченно:\nЗерна: " + totalCostsGrains + "\nМолока: " + totalCostsMilk + "\nСахара: " + totalCostsSugar);
    }

    //метод для ведения отчетности выручки
    static ArrayList<String> boxOffice = new ArrayList<>();
    static int totalPriceCash;
    static int totalPriceCard;
    public static void boxOffice(double price, boolean cardOrCash) {
    String strMoney = "Выручка за заказ №";
    orderNum--;
        if(cardOrCash) {
            boxOffice.add(strMoney + orderNum + " " + price + " безналичными");
        totalPriceCard+=price;
    }
    if (!cardOrCash) {
        boxOffice.add(strMoney + orderNum + " " + price + " наличными");
        totalPriceCash+=price;
    }
    orderNum+=1;
    }
//метод для вывода статистики выручки 
    public static void boxOfficePrint () {
        System.out.println("\n");
        for (String boxList:boxOffice) {
            System.out.println(boxList);
        }
        System.out.println();
        System.out.println("Мы выручили безналичными: " + totalPriceCard);
        System.out.println("Наличными: " + totalPriceCash);
    }
}


