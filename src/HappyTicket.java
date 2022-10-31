import java.util.Scanner;

public class HappyTicket {
    // метод ввода данных
    public static int enterNumber() {
        Scanner sc = new Scanner(System.in);
        int number;
        for(;;){
            if (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число. Повторите ввод.");
                sc.nextLine();
                continue;
            }
            number = sc.nextInt();
            if (number > 99999 && number <1000000)
                return number;
            else
                System.out.println("Введите шестизначное число.");
        }
    }
    // метод Москвоского счастливого билета
    public static boolean isHappyMoscow(int x) {
        int s1 =0, s2 = 0;
        for(int i = 0; i < 3; i++) {
            s1 += x % 10;
            x = x / 10;
        }
        for(int i = 0; i < 3; i++) {
            s2 += x % 10;
            x = x / 10;
        }
        if (s1 == s2)
            return true;
        else
            return false;
    }
    // метод Санкт-Петербургского счастливого билета
    public static boolean isHappyStPetersburg(int x) {
        int s1 =0, s2 = 0;
        for(int i = 0; i < 3; i++) {
            s1 += x % 10;
            x = x / 10;
            s2 += x % 10;
            x = x / 10;
        }
        if (s1 == s2)
            return true;
        else
            return false;
    }
    // выполнение потока
    public static void main(String[] args) {
        System.out.println("Введите номер билета");
        System.out.print("a = ");
        int a = enterNumber();
        if (isHappyMoscow(a))
            System.out.println("Московский счастливый билет");
        if (isHappyStPetersburg(a))
            System.out.println("Питерский счастливый билет");
        if (! isHappyMoscow(a) && !isHappyStPetersburg(a))
            System.out.println("Обычный билет");
    }
}
