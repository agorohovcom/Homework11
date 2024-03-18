import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Методы
        // Задача 1
        printLeapYearOrNo(2024);

        // Задача 2
        printAppVersion(0, 2024);

        // Задача 3
        printCardDeliveryInfo(35);
    }

    public static boolean checkLeapYear(int year) {
        return year > 1584 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    public static void printLeapYearOrNo(int year) {
        boolean isLeapYear = checkLeapYear(year);

        if (isLeapYear) {
            System.out.printf("%d год - високосный год\n", year);
        } else {
            System.out.printf("%d год - невисокосный год\n", year);
        }
        System.out.println();
    }

    public static boolean checkIsDeviceOld(int deviceYear) {
        return deviceYear < LocalDate.now().getYear();
    }

    public static void printAppVersion(int deviceOS, int deviceYear) {
        boolean isDeviceOld = checkIsDeviceOld(deviceYear);

        if (deviceOS == 0 && isDeviceOld) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке\n");
        } else if (deviceOS == 0 && !isDeviceOld) {
            System.out.println("Установите версию приложения для iOS по ссылке\n");
        } else if (deviceOS == 1 && isDeviceOld) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке\n");
        } else if (deviceOS == 1 && !isDeviceOld) {
            System.out.println("Установите версию приложения для Android по ссылке\n");
        } else {
            System.out.println("Для вашей ОС доступна веб-версия по ссылке\n");
        }
    }

    public static int countCardDeliveryDays(int deliveryDistance) {
        int deliveryTime = 0;

        if (deliveryDistance <= 20) {
            deliveryTime++;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            deliveryTime += 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            deliveryTime += 3;
        } else if (deliveryDistance > 100) {
            deliveryTime = -1;
        }

        return deliveryTime;
    }

    public static void printCardDeliveryInfo(int distance) {
        if (distance < 0) {
            throw new RuntimeException("Расстояние не может быть меньше 0 км");
        } else if (countCardDeliveryDays(distance) < 0) {
            System.out.println("Доставки нет, слишком далеко");
        } else {
            System.out.printf("Для доставки карты потребуется дней: %d\n", countCardDeliveryDays(distance));
        }
    }
}