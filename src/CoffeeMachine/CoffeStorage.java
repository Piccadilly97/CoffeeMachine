package CoffeeMachine;

import java.util.Scanner;
    public class CoffeStorage {
        private static double grains;

        public void setGrains(double grainsLoad) {
            grains += grainsLoad;
        }

        double getGrains() {
            return grains;
        }

        private static double milk;

        public void setMilk(double milkLoad) {
            milk += milkLoad;
        }

        double getMilk() {
            return milk;
        }

        private static double sugar;

        public void setSugar(double sugarLoad) {
            sugar += sugarLoad;
        }

        double getSugar() {
            return sugar;
        }

        public void shipment() {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Добрый день, босс, сколько продуктов пришло на склад?");
            System.out.println("Введите колличество зёрен которые нужно загрузить на склад");
            setGrains(scanner1.nextInt());
            System.out.println(getGrains());


            System.out.println("Введите колличество молока, которое нужно загрузить на склад");
            setMilk(scanner1.nextInt());
            System.out.println(getMilk());

            System.out.println("Введите колличество сахара, которое нужно загрузить на склад");
            setSugar(scanner1.nextInt());
            System.out.println(getSugar());
            int z = 0;
            while (z < 3) {
                System.out.println("\nНажмите:\n1-меню поставок\n2-просмотр продуктов на складе\n3-переход в кофемашину\n4-Меню администрирования");
                int inShipment = scanner1.nextInt();
                if (inShipment == 1) {
                    shipment();
                    z = 3;
                }
                if (inShipment == 2) {
                    System.out.println(storageOutput());
                }
                if (inShipment == 3) {
                    CoffeeCar coffee = new CoffeeCar();
                    coffee.CoffeeMachine();
                    z = 3;
                }
                if (inShipment == 4) {
                    AdminMenu.Admin();
                }
            }
        }

        //метода для вывода остатков склада
        public String storageOutput() {
            String milkStorage = "На складе:\nМолока: " + getMilk();
            String grainsStorage = "\nЗерна: " + getGrains();
            String sugarStorage = "\nСахара: " + getSugar();
            return milkStorage + grainsStorage + sugarStorage;
        }
    }