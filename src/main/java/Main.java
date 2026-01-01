import java.util.Scanner;

public class Main {

    private static final int CARS_COUNT = 3;
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 250;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= CARS_COUNT; i++) {
            String name = readCarName(scanner, i);
            int speed = readCarSpeed(scanner, i);

            Car car = new Car(name, speed);
            race.consider(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }

    private static String readCarName(Scanner scanner, int carNumber) {
        while (true) {
            System.out.println("Введите название машины №" + carNumber + ":");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Ошибка: название не может быть пустым. Повторите ввод.");
                continue;
            }
            return name;
        }
    }

    private static int readCarSpeed(Scanner scanner, int carNumber) {
        while (true) {
            System.out.println("Введите скорость машины №" + carNumber + ":");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: скорость не может быть пустой. Повторите ввод.");
                continue;
            }

            if (input.contains(".") || input.contains(",")) {
                System.out.println("Ошибка: скорость должна быть целым числом. Повторите ввод.");
                continue;
            }

            int speed;
            try {
                speed = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число. Повторите ввод.");
                continue;
            }

            if (speed < MIN_SPEED || speed > MAX_SPEED) {
                System.out.println("Неправильная скорость (допустимо " + MIN_SPEED + "–" + MAX_SPEED + ").");
                continue;
            }

            return speed;
        }
    }
}
