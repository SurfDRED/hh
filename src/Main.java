import java.util.*;

public class Main {
    public static void main(String[] args) {
        int account; //открыто N корпоративных счетов
        int managers; //в компании работает M менеджеров
        long payment = 0; // сумма выплаты
        int resultManagers = 0; // сколько менеджеров получат такую сумму
        long sumCorporateAccount = 0; //общая сумма всех счетов
        Scanner scanner = new Scanner(System.in);
        String lineOne = scanner.nextLine();
        String[] strLine = lineOne.split(" ");
        account = Integer.parseInt(strLine[0]);
        managers = Integer.parseInt(strLine[1]);
        //вносим данные о суммах на счетах до 100 000 000 и узнаем баланс всех счетов
        int[] amountsMoneyAll = new int[account];
        for (int i = 0; i < amountsMoneyAll.length; i++) {
            amountsMoneyAll[i] = Integer.parseInt(scanner.nextLine());
            sumCorporateAccount = sumCorporateAccount + amountsMoneyAll[i];
        }
        // Если денег на счетах компании не хватит на то, чтобы выдать премию хотя бы по 1 у.е.
        if (sumCorporateAccount / managers >= 1) {
            long minCorporateAccount = sumCorporateAccount / managers; // - возможная максимальная выплата в целом со всех счетов
            do {
                for (int i = 0; i < amountsMoneyAll.length; i++) {
                    // узнаем сколько менеджеров может получить таких сумм с каждого счета
                    if (amountsMoneyAll[i] != 0) {
                        resultManagers = resultManagers + (int)((amountsMoneyAll[i] - amountsMoneyAll[i] % minCorporateAccount) / minCorporateAccount);
                    }
                }
                // проверим, всем ли достанется, если не всем, то сумму выплаты уменьшаем и повторяем проверку
                if (resultManagers != managers) {
                    minCorporateAccount = minCorporateAccount - 1;
                    resultManagers = 0;
                } else {
                    payment = minCorporateAccount;
                }
            } while (resultManagers != managers);
        }
        System.out.println(payment);
    }
}