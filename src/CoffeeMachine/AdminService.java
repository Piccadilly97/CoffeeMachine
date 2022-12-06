package CoffeeMachine;

import CoffeeMachine.Display.DisplayConclusion;

import java.util.Scanner;

public class AdminService {

    CoffeeStorage b = new CoffeeStorage();
    //МЕТОД ПРОВЕРКИ ЗАПОЛНЕННОСТИ СКЛАДА
    public static void checkStorage() {
        CoffeeStorage d = new CoffeeStorage();
        if (d.getGrains() == 0 || d.getMilk() == 0 || d.getSugar() == 0) {
            System.out.println(DisplayConclusion.EMPTY_STORAGE);
            Scanner sc1 = new Scanner(System.in);
            while (true) {
                String storage = sc1.next();
                if (storage.equals("1234")) {
                    AdminMenu.AdminMenu();
                    return;
                } else {
                    System.out.println("Введите пароль снова");
                }
            }
        }
    }
    //МЕТОД ОШИБКИ В ВЫБОРЕ КОФЕ
   public static void error() {
       CoffeeCar car = new CoffeeCar();
       System.out.println("Вы можете выбрать ваш кофе снова, для этого нажмите 1");
       System.out.println("Нажмите 2 для того что бы выйти из программы");
       Scanner sc = new Scanner(System.in);
       int scanDef = sc.nextInt();
       if (scanDef == 1) {
           car.coffeeSelections();
       } else {
           exit();
       }
   }

   //МЕТОД ПРОВЕРКИ НАЛИЧИЯ
   public static void comparisonResult (double grainsResult, double milkResult, double sugarResult) {
       CoffeeCar car = new CoffeeCar();
       CoffeeStorage b = new CoffeeStorage();
       if (b.getGrains() < grainsResult || b.getMilk() < milkResult || b.getSugar() < sugarResult) {
           System.out.println("Извините, кажется мы не сможем приготовить столько кофе((\nНа складе нет столько ингридиентов");
           System.out.println("Выберите пожалуйста ваше кофе снова");
           car.coffeeSelections();
       }
   }

    //МЕТОД ПОВТОРА ЗАКАЗА
    public static void repeatOrder() {
        System.out.println("\nНажмите:\n1-сделать новый заказ\n2-выход в главное меню\n3-выход из программы");
        Scanner sc1 = new Scanner(System.in);
        String number = sc1.next();
        if (number.equals("1")) {
            CoffeeCar c1 = new CoffeeCar();
            c1.coffeeSelections();
        }
        if (number.equals("2")) {
            CoffeeCar.menu();
        }
        if (number.equals("3")) {
            AdminService.exit();
        }
    }

    //МЕТОД ОПЛАТЫ
 public static boolean cardOfCash;
    public static void payment (double price) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Цена вашего кофе " + price + " рублей");
        while (true) {
            System.out.println("Как вам будет удобнее платить?\nНажмите:\n1-картой\n2-наличными");
            String money = sc1.next();
            if (money.equals("1")) {
                System.out.println("Приложите пожалуйста карту здесьн\n");
                cardOfCash = true;
                break;
            }
            if (money.equals("2")) {
                System.out.println("Спасибо за оплату");
                cardOfCash = false;
                break;
            } else {
                System.out.println("Кожется вы допустили ошибку, выберите способ оплаты заново");
            }
        }
    }

    public static void exit() {
        System.out.println("Всего доброго, досвидания!");
        java.lang.System.exit(0);
    }


}

