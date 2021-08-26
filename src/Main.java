import java.util.*;

public class Main {
    public static void main(String[] args) {
        int account; //открыто N корпоративных счетов
        int managers; //в компании работает M менеджеров
        long sumCorporateAccount = 0L; //общая сумма всех счетов
        long payment = 0L; // сумма выплаты менеджерам
        //Первая строка - целые числа N и M через пробел (1≤N≤100 000, 1≤M≤100 000)
        Scanner scanner = new Scanner(System.in);  //сканер для чтения потока
        String lineOne = scanner.nextLine();
        String[] strLine = lineOne.split(" ");
        account = Integer.parseInt(strLine[0]);
        managers = Integer.parseInt(strLine[1]);
        //Далее N строк, на каждой из которых одно целое число Cn (0≤Cn≤100 000 000)
        long[] amountsMoneyAll = new long[account]; // массив значений счетов
        for (int i = 0; i < amountsMoneyAll.length; i++) {
            amountsMoneyAll[i] = Long.parseLong(scanner.nextLine());
            sumCorporateAccount += amountsMoneyAll[i];
        }
        if (sumCorporateAccount > 0 && managers > 0) {
            payment = sumCorporateAccount / managers; // - возможная максимальная выплата в целом с любого счета
        }
        if (payment != 0) {
            while(true) {
                int resultManagers = 0; // сколько менеджеров получат такую сумму
                for (int i = 0; i < amountsMoneyAll.length; i++) {
                    // узнаем сколько менеджеров может получить такую сумму
                    resultManagers += amountsMoneyAll[i] / payment;
                }
                // проверим, всем ли достанется, если не всем, то сумму выплаты уменьшаем и повторяем проверку
                if (resultManagers >= managers) {
                    break;
                } else {
                    payment--;
                }
            }
        }
        System.out.println(payment);
    }
}