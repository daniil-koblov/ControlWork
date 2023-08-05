package TaskTwoToyShop;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Raffle r = new Raffle();
        Scanner sc = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.print("Меню работы приложения розыгрыша:\n"
                    + "1 - Добавление новой игрушки в список.\n"
                    + "2 - Изменение вероятности выпадения какой-нибуди игрушки.\n"
                    + "3 - Произведение розыгрыша игрушек\n"
                    + "0 - Завершение розыгрыша.\n");
            var selection = sc.next();
            switch (selection) {
                case "1" -> r.addToy();
                case "2" -> r.setFrequency();
                case "3" -> r.raffle();
                case "0" -> {
                    System.out.println("Работа окончена.");
                    System.exit(0);
                }
                default -> System.out.println("Incorrect selection. Try again.");
            }
        }
    }
}
