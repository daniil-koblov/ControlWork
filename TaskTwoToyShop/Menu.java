package TaskTwoToyShop;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Raffle r = new Raffle();
        Scanner option = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    Main menu:
                    1 - Добавьте новую игрушку.
                    2 - Измените частоту выпадения какой-нибудь игрушки.
                    3 - Проведите розыгрыш игрушек и сохраните результат в файл.
                    0 - Выход.
                    >\s""");
            String selection = option.next();
            switch (selection) {
                case "1" -> r.addToy();
                case "2" -> r.setFrequency();
                case "3" -> r.raffle();
                case "0" -> {
                    System.out.println("Розыгрыш закончен. Результат в файле.");
                    System.exit(0);
                }
                default -> System.out.println("Не корректный выбор. Проведите повторно.");
            }
            option.close();
        }
        
    }
}
