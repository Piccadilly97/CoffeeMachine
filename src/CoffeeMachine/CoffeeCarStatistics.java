package CoffeeMachine;

import java.util.ArrayList;

public class CoffeeCarStatistics {

    //МЕТОД ДЛЯ СЧИТЫВАНИЯ ЗАКАЗОВ И ЗАНЕСЕНИЯ ИХ В СПИСОК
    private static int orderNum = 1;
    static ArrayList<String> orders = new ArrayList<>();
    public static void statistics(String orderInfo) {
        String orderText = "Заказ №";
        orders.add(orderText + orderNum + orderInfo);
        orderNum += 1;
    }

    //МЕТОД ДЛЯ ПОКАЗА СПИСКА ЗАКАЗОВ
    public static void statisticsOut () {
        if(orders.isEmpty()) {
            System.out.println("Пока что заказов не было, скорее переходите в кофемашину");
        }
        for (String orderOut:orders) {
            System.out.println(orderOut);
        }
    }

    //МЕТОД ДЛЯ ФИКСАЦИИ ЗАТРАТ
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

