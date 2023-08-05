package TaskTwoToyShop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Raffle {

    private static ArrayList<Toy> toys = new ArrayList<>();
    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();

    private static int idCounter = 0;

    public void addToy() {
        Scanner scan = new Scanner(System.in, "UTF-8");
        String title;
        int frequency;
        while (true) {
            System.out.print("Введите имя игрушки: ");
            title = scan.nextLine();
            if (title.isEmpty()) {
                System.out.println("Некорректное значение. Повторите ввод.");
                break;
            }
            System.out.print("Введите вероятность выпадения: ");
            String value = scan.nextLine();
            if (isDigit(value)) {
                frequency = Integer.parseInt(value);
                if (frequency <= 0) {
                    System.out.println("Некорректное значение. Повторите ввод.");
                } else {
                    Toy toy = new Toy(idCounter, title, frequency);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        idCounter++;
                        toys.add(toy);
                        System.out.println("Новая игрушка добавлена");
                    } else {
                        System.out.println("Эта игрушка уже была добавлена ранее.");
                    }
                }
            } else {
                System.out.println("Некорректное значение. Повторите ввод.");
            }
            break;
        }
    }

    public void setFrequency() {
        Scanner scan = new Scanner(System.in, "UTF-8");
        System.out.print("Введите id игрушки: ");
        String value = scan.nextLine();
        if (isDigit(value)) {
            int selectedId = Integer.parseInt(value);
            if (selectedId >= 0 && selectedId < toys.size()) {
                System.out.println("Игрушка " + toys.get(selectedId).getToyTitle() +
                        " ее вероятность выпадения " + toys.get(selectedId).getFrequencyFallToy());
                System.out.print("Введите новую вероятность выпадения: ");
                value = scan.nextLine();
                if (isDigit(value)) {
                    int newFrequency = Integer.parseInt(value);
                    toys.get(selectedId).setFrequencyFallToy(newFrequency);
                    System.out.println("Вероятность выпадения изменена.");
                } else {
                    System.out.println("Некорректное значение. Повторите ввод.");
                }
            } else {
                System.out.println("Игрушки с таким id нет.");
            }
        } else {
            System.out.println("Некорректное значение. Повторите ввод.");
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Toy getPrize() {
        if (prizes.size() == 0) {
            Random rnd = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getFrequencyFallToy(); i++) {
                    Toy temp = new Toy(toy.getToyId(), toy.getToyTitle(), rnd.nextInt(1, 10));
                    prizes.add(temp);
                }
            }
        }
        return prizes.poll();
    }

    public void raffle() {
        if (toys.size() >= 2) {
            Toy prize = getPrize();
            System.out.println("Приз: " + prize.getToyTitle());
            saveResult(prize.getInfo());
        } else {
            System.out.println("Вы должны добавить минимум две игрушки.");
        }
    }

    private void saveResult(String text) {
        File file = new File("TaskTwoToyShop/Result.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("TaskTwoToyShop/Result.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}