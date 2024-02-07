import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
public class Main {
   public static void main(String[] args) {
   Arrays.sort(args);
        int index;
        Boolean outCar;
        String carout;
        String car = getRandom();
        String[] password = new String[]{"0", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};
        String[] parking = new String[]{"0", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};
        display(parking);
        boolean isempty=true;
        /////////
        while (isempty) {
            System.out.println();
            System.out.println("   Don't forget (eslatma) !!! ");
            System.out.println(" \t 🏍 is the plase (joyi) (11...14) ");
            System.out.println(" \t 🚛 is the plase (joyi) (15...18) ");
            System.out.println(" \t 🚗 is the plase (joyi) (19...26) ");
            System.out.println();
            ///////////
            car = getRandom();
            System.out.println("\t " + car + "  The car arrived (kirib keladigan mashina)");
            System.out.println();
            changepark(parking, password, car);
            LocalTime enter=LocalTime.now();
            System.out.println("\t Entry: " + enter);
            display(parking);
            outCar = outOrEnterTheCar();
            {
                if (outCar == true) {
                     carOut(parking,password);
                }else continue;
            }
            LocalTime out=LocalTime.now();
            System.out.println("\t Out: " + out);
            isempty=Empty(parking);
            System.out.println("\t Time(sekond): " + ChronoUnit.SECONDS.between(enter,out) + " s ");
            System.out.println("\t summa(sum): " + ChronoUnit.SECONDS.between(enter,out)*10 + " sum ");
        }
        display(parking);

        System.out.println();
        System.out.println("   park is empty (parkovka bush)  ✔✔✔✔ ");
    }

    private static boolean Empty(String[] parking) {
        for (int i=0;i<parking.length;i++) {
            if (parking[i].equals("🏍") || parking[i].equals("🚛") || parking[i].equals("🚗")) {
                return true;
            }
        }
                    return false;
    }

    private static void carOut(String[] parking , String[] password) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\t Which car do you want to take out (qaysi parkovkadagi mashina chiqsin ) : ");
            int number = scanner.nextInt();
            if (number < 11 || number > 26) {
                System.out.println("\t Wrong ???");
                continue;
            }
                if (parking[number-10].equals("🚗") || parking[number-10].equals("🚛") || parking[number-10].equals("🏍")) {
                  while (true) {
                      System.out.print("\t Enter the old password (eski parolni kiriting): ");
                      String parol=scanner.next();
                      if (password[number - 10].equals(parol)) {
                          System.out.println("\t Your password is correct (parol tug'ri va parkovka bush) ✔✔✔✔✔ ");
                          password[number - 10] = String.valueOf(number);
                          parking[number - 10] = String.valueOf(number);
                          return;
                      } else {
                          System.out.println("\t The password is incorrect (parol xato)???  ");
                      }
                  }
            }else
            System.out.println("\t empty (qaytadan kiriting)   ");
        }
    }

    private static boolean outOrEnterTheCar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(" \t enter or out (kirish yoki chiqish) : ");
            String str = scanner.next();
            if (str.equals("enter")) {
                return false;
            }
            if (str.equals("out")) {
                return true;
            }
            continue;
        }
    }

    private static void changepark(String[] parking, String[] password, String car) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(" \t Select a number (11...26) : ");
            int index = scanner.nextInt();
            if (index < 11 || index > 26) {
                System.out.println("\t Wrong ???");
                continue;
            }
            if (parking[index - 10].equals(String.valueOf(index))) {
                if (car == "🏍" && index > 10 && index < 15) {
                    parking[index - 10] = car;
                    System.out.print("  " + car + " : enter password:  ");
                    String str = scanner.next();
                    password[index - 10] = str;
                    return;
                }
                if (car == "🚛" && index > 14 && index < 19) {
                    parking[index - 10] = car;
                    System.out.print("  " + car + " : enter password:  ");
                    String str = scanner.next();
                    password[index - 10] = str;
                    return;
                }
                if (car == "🚗" && index > 18 && index < 27) {
                    parking[index - 10] = car;
                    System.out.print("  " + car + " : enter password:  ");
                    String str = scanner.next();
                    password[index - 10] = str;
                    return;
                }
            }
            System.out.println("\t Wrong ???");
        }
    }

    private static String getRandom() {
        Random random = new Random();
        int car1 = random.nextInt(3);
        if (car1 == 0) {
            return "🚛";
        } else if (car1 == 1) {
            return "🚗";
        } else {
            return "🏍";
        }
    }

    private static void display(String[] parking) {
        System.out.println();
        System.out.println("\t" + parking[1] + " || " + parking[2] + " || " + parking[3] + " || " + parking[4]);
        System.out.println("\t" + parking[5] + " || " + parking[6] + " || " + parking[7] + " || " + parking[8]);
        System.out.println("\t" + parking[9] + " || " + parking[10] + " || " + parking[11] + " || " + parking[12]);
        System.out.println("\t" + parking[13] + " || " + parking[14] + " || " + parking[15] + " || " + parking[16]);
        System.out.println();
    }
}
