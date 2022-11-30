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
            System.out.println("Нажмите:\n1-меню поставок\n2-переход в кофемашину\n3-просмотр склада\n4-просмотр заказов");
            int input1 = scanner.nextInt();
            if (input1 == 1) {
                c.shipment();
                break;
            }
            if (input1 == 2) {
                CoffeeCar.menu();
                break;
            }
            if (input1 == 3) {
                System.out.println(c.storageOutput() + "\n");
                Admin();
            }
            if(input1 == 4) {
                statisticsOut();
                storageStatisticOutput();
            }
            else {
                System.out.println("Кажется вы допустили ошибку, введите снова или выйдете в главное меню");
                System.out.println("Нажмите:\n1-вход в меню администрации\n2-выход в главное меню кофейни");
                int input2 = scanner.nextInt();
                int x = 0;
                while (x < 3) {
                    if (input2 == 1) {
                        Admin();
                    }
                    if (input2 == 2) {
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

    //МЕТОД ДЛЯ ПОКАЗА СТАТИСТИКИ
    public static void statisticsOut () {
        for (String orderOut:orders) {
            System.out.println(orderOut);
        }
    }
     //МЕТОД ДЛЯ ЗАПОЛНЕНИЯ ЗАТРАТ
       static ArrayList<String> usedProducts = new ArrayList<>();
    public static void storageStatistic (String spentGrains, String spentMilk, String spentSugar) {
        String txt = "Наши затраты на заказ номер №";
        orderNum -=1;
        usedProducts.add(txt + orderNum + spentGrains + spentMilk + spentSugar);
        orderNum++;
    }

    //метод для показа затрат
    public static void storageStatisticOutput () {
        System.out.println("Использованные продукты:");
        for (String usedProductOut:usedProducts) {
            System.out.println(usedProductOut);
        }
    }
}


