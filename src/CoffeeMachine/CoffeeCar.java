package CoffeeMachine;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeCar {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Здравствуйте, это кофемашина построенная на языке Java");
        System.out.println("-------------------------------------------------------");
        menu();
    }

    public static void menu() {
        //MENU
        Scanner scanner = new Scanner(System.in);
        CoffeStorage d = new CoffeStorage();
        CoffeeCar c = new CoffeeCar();
        if(d.getGrains() == 0||d.getMilk() == 0||d.getSugar() == 0) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("К сожалению склад нашей кофемашины пуст, поэтому сделать заказ не получиться\nЕсли вы являетесь админом, то введите пароль");
           int v = 0;
            while (v < 1) {
                int storage = sc1.nextInt();
                if (storage == 1234) {
                    AdminMenu.Admin();
                    v=1;
                    return;
                } else {
                    System.out.println("Введите пароль снова");
                    v=0;
                }
            }
        }
        System.out.println("Введите любую цифру для заказа кофе или введите администраторский пароль");
        int x = 0;
        while (x < 3) {
            if (x > 0) {
                System.out.println("Введите пароль снова");
                x = x - 1;
            }
            int menu = scanner.nextInt();
            if (menu == 1234) {
                AdminMenu.Admin();
                x = x + 3;
            }
            if (menu > 999) {
                if (menu != 1234) {
                    System.out.println("Кажется пароль не верный");
                    System.out.println("Нажмите 1 для повтора попытки и 2 для перехода к заказу");
                    int menu1 = scanner.nextInt();
                    if (menu1 == 1) {
                        x = x + 1;
                    }
                    if (menu1 == 2) {
                        x = x + 3;
                        c.CoffeeMachine();
                        return;
                    }
                }
            }
            else {
                c.CoffeeMachine();
            }
        }
    }
    public void CoffeeMachine() {
        CoffeStorage b = new CoffeStorage();
        Scanner scanner2 = new Scanner(System.in);
        Scanner Scanner1 = new Scanner(System.in);
        //COFFEE INPUT
        double grainsResult = 0;
        double milkResult = 0;
        double sugarResult = 0;
        Scanner scanner1 = new Scanner(System.in);
        String warning = "Осторожно, горячо!";
        String[] coffeeList = {"КАПУЧИНО", " ЛАТТЕ", " ЭСПРЕССО"};
        String str = String.join(",", coffeeList);
        String print = "";
        //переменная для статистики
        String orderHistory = " ";
        System.out.println("Какой кофе вы хотите?\nУ нас есть: " + str);
        String input = scanner1.next().toUpperCase();
        switch (input) {
            case "ЛАТТЕ":
                print = "Вот ваш: Латте";
                grainsResult += 1;
                milkResult += 2;
                orderHistory = " Латте ";
                break;
                //ошибочный набор слова латте
            case "KFNNT":
                System.out.println("Вы имели ввиду Латте?\nНажмите 1 если да, и 2 если нет");
                String eror = Scanner1.next();
                if (eror.equals("1")) {
                    print = "Вот ваш: Латте";
                    grainsResult += 1;
                    milkResult += 2;
                    orderHistory = " Латте ";
                    break;
                }
                else {
                    System.out.println("Попробуйте выбрать ваш кофе сначала");
                    CoffeeMachine();
                    break;
                }
            case "КАПУЧИНО":
                print = "Вот ваш: Капучино";
                grainsResult += 2;
                milkResult += 1;
                orderHistory = " Капучино ";
                break;
                //ошибочный набор слова капучино
            case "RFGEXBYJ":
                System.out.println("Вы имели ввиду Капучино?\nНажмите 1 если да, и 2 если нет");
                String eror2 = scanner1.next();
                if (eror2.equals("1")) {
                    print = "Вот ваш: Капучино";
                    grainsResult += 2;
                    milkResult += 1;
                    orderHistory = " Капучино ";
                    break;
                }
                else {
                    System.out.println("Попробуйте выбрать ваш кофе сначала");
                    CoffeeMachine();
                    break;
                }
            case "ЭСПРЕССО":
                print = "Вот ваш: Эспрессо";
                grainsResult += 3;
                orderHistory = " Эспрессо ";
                break;
                //ошибочный набор слова эспрессо
            case "'CGHTCCJ" :
                System.out.println("Вы имели ввиду Эспрессо?\nНажмите 1 если да и 2 если нет");
                String eror3 = scanner1.next();
                if (eror3.equals("1")) {
                    print = "Вот ваш: Эспрессо";
                    grainsResult += 3;
                    orderHistory = " Эспрессо ";
                    break;
                }
                else {
                    System.out.println("Попробуйте выбрать ваш кофе сначала");
                    CoffeeMachine();
                    break;
                }
            default:
                System.out.println("Увы, такого кофе у нас нету:(((");
                System.out.println("Вы можете выбрать ваш кофе снова, для этого нажмите 1");
                System.out.println("Нажмите 2 для того что бы выйти из программы");
                Scanner sc = new Scanner(System.in);
                int scanDef = sc.nextInt();
                if (scanDef == 1) {
                    CoffeeMachine();
                } else {
                    exit();
                }
        }
        //VOLUME
        int[] volume = {200, 300, 400};
        String volumeStr = Arrays.toString(volume).replaceAll("\\[|\\]", "");
        System.out.println("Какой объём кофе вы желаете?");
        System.out.println("У нас есть: " + volumeStr + " миллилитров");
        String volumeOut = "";
        String volumeIn = scanner2.next();
        switch (volumeIn) {
            case "200":
                volumeOut = ", объёмом 200 миллилитров ";
                orderHistory += "200 мл";
                break;
            case "300":
                volumeOut = ", объёмом 300 миллилитров ";
                grainsResult = grainsResult * 1.5;
                milkResult = milkResult * 1.5;
                orderHistory += "300 мл";
                break;
            case "400":
                volumeOut = ", объёмом 400 миллилитров ";
                grainsResult = grainsResult * 2;
                milkResult = milkResult * 2;
                orderHistory += "400 мил";
                break;
            default:
                System.out.println("Кажется, такого объёма у нас нету((");
                System.out.println("Вы можете выбрать ваш кофе снова, для этого нажмите 1");
                System.out.println("Нажмите 2 для того что бы выйти из программы");
                Scanner sc = new Scanner(System.in);
                int scan = sc.nextInt();
                if (scan == 1) {
                    CoffeeMachine();
                } else {
                    exit();
                }
        }
        //SUGAR
        System.out.println("Сколько сахара вам положить?");
        int sugarNum = scanner1.nextInt();
        if (sugarNum > -1) {
            sugarResult += sugarNum;
            orderHistory += " " + "," + sugarNum + " сахар(а)";
        } else {
            System.out.println("Кажется вы выбрали колличество сахара менее чем 0");
            System.out.println("Вы можете выбрать ваш кофе снова, для этого нажмите 1");
            System.out.println("Нажмите 2 для того что бы выйти из программы");
            Scanner sc = new Scanner(System.in);
            int scan = sc.nextInt();
            if (scan == 1) {
                CoffeeMachine();
            } else {
                exit();
            }
        }
        //QUANTITY
        System.out.println("Сколько кофе вы хотите?");
        int num = scanner2.nextInt();
        sugarResult = sugarResult * num;
        milkResult = milkResult * num;
        grainsResult = grainsResult * num;

        if (b.getGrains() < grainsResult || b.getMilk() < milkResult || b.getSugar() < sugarResult) {
            System.out.println("Извините, кажется мы не сможем приготовить столько кофе((\nНа складе нет столько ингридиентов");
            System.out.println("Выберите пожалуйста ваше кофе снова");
            CoffeeMachine();
        }

        if (num < 1) {
            System.out.println("Кажется вы ввели значение меньше или равно нулю, мы не сможем приготовить столько кофе((");
            System.out.println("Вы можете выбрать ваш кофе снова, для этого нажмите 1");
            System.out.println("Нажмите 2 для того что бы выйти из программы");
            Scanner sc = new Scanner(System.in);
            int scan = sc.nextInt();
            if (scan == 1) {
                CoffeeMachine();
            } else {
                exit();
            }
        }
        //storage operation
        b.setGrains(b.getGrains() - b.getGrains() - grainsResult);
        b.setMilk(b.getMilk() - b.getMilk() - milkResult);
        b.setSugar(b.getSugar() - b.getSugar() - sugarResult);

        if (num == 1) {
            System.out.println(print + volumeOut + "в колличестве " + num + " штуки");
            System.out.println(warning);

        }
        if (num > 1) {
            System.out.println(print + volumeOut + "в колличестве " + num + " штук");
            System.out.println(warning);
        }
        //Statistic operation
        String ordersOutput =":" + " " + num + orderHistory;

        String spentGrains = " зерно:" + grainsResult;
        String spentMilk = " молоко:" + milkResult;
        String spentSugar = " сахар(а):" + sugarResult;

        //STORAGE INFO
        System.out.println(b.storageOutput());
        AdminMenu.statistics(ordersOutput);
        AdminMenu.storageStatistic(spentGrains, spentMilk, spentSugar);
        AdminMenu.totalCosts(grainsResult, milkResult, sugarResult);
        repeatOrder();
    }
    public void repeatOrder () {

        System.out.println("\nНажмите:\n1-сделать новый заказ\n2-выход в главное меню\n3-выход из программы");
        Scanner sc1 = new Scanner(System.in);
        String number = sc1.next();
        if (number.equals("1")) {
            CoffeeCar c1 = new CoffeeCar();
            c1.CoffeeMachine();
        }
        if (number.equals("2")) {
            menu();
        }
        if (number.equals("3")) {
            exit();
        }
    }
    public static void exit() {
        System.out.println("Всего доброго, досвидания!");
        java.lang.System.exit(0);
    }
}
