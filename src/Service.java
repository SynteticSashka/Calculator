import java.util.Arrays;
import java.util.Scanner;

public class Service {

    public static String[] loadStringArray() {
        return new String[]{"-IX", "-VIII", "-VII", "-VI", "-V", "-IV", "-III", "-II", "-I", "N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
                "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
    }

    public static int[] loadIntArray(){
        return new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
                51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,
                81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};

    }

    public static boolean isArabic(String a, int[] array) {
        int b = 0;
        String s ="";
        for (int i = 0; i<array.length; i++){
            s = Integer.toString(array[i]);
            if (s.equals(a)) b++;

        }

        return (b>0);



    }

    public static boolean isLatin(String a, String[] array) {
        int b = 0;
        String s ="";
        for (int i = 0; i<array.length; i++){
            s = array[i];
            if (s.equals(a)) b++;

        }

        return (b>0);
    }

    public static int convertLatinToArabic(String s){
        int index = 0;
        String a = "";
        for (int i =0; i<Application.latinianNumbers.length; i++){
            a = Application.latinianNumbers[i];
            if (s.equals(a)) index = i;
        }
        return Application.arabicNumbers[index];
    }

    public static String convertArabicToLatin(int i){
        int index = Arrays.binarySearch(Application.arabicNumbers, i);
        return Application.latinianNumbers[index];
    }

    public static int calculate (String[] expression, int first, int second){
        switch (expression[1]) {
            case ("+"):
                return first+second;
            case ("-"):
                return first-second;
            case ("*"):
                return first*second;
            case ("/"):
                return first/second;
        }
        return 0;
    }

    public static String[] readFromConsole(String[] array) {
        Scanner scanner = new Scanner(System.in);
        array[0] = scanner.next();
        array[1] = scanner.next();
        array[2] = scanner.next();
        scanner.close();
        return array;
    }

    public static void check(String[] array) throws Exception {

        String[] checkArray = {"1","2","3","4","5","6","7","8","9","10","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int gotIt = 0;
        for (int i = 0; i<checkArray.length; i++){
            if (array[0].equals(checkArray[i])) gotIt++;
            if (array[2].equals(checkArray[i])) gotIt++;
        }
        if (gotIt<2) throw new Exception("Некорректные числа на входе!");


        boolean isFirstArabic = isArabic(array[0], Application.arabicNumbers);
        boolean isFirstLatin = isLatin(array[0], Application.latinianNumbers);
        boolean isSecondArabic = isArabic(array[2], Application.arabicNumbers);
        boolean isSecondLatin = isLatin(array[2], Application.latinianNumbers);

        if (!((isFirstArabic && isSecondArabic) || (isFirstLatin && isSecondLatin))) throw new Exception("Разный формат входных данных!");

        String[] marks = {"+", "-", "*", "/"};
        Arrays.sort(marks);
        if (Arrays.binarySearch(marks, array[1]) < 0) throw new Exception("Некорректный ввод действия");
    }

    public static String convert(String[] array){
        int first, second;
        String result;
        if (Service.isLatin(array[0], Application.latinianNumbers)) {
            first = Service.convertLatinToArabic(array[0]);
            second = Service.convertLatinToArabic(array[2]);
            result = (Service.convertArabicToLatin(Service.calculate(array, first, second)));
        } else {
            first = Integer.parseInt(array[0]);
            second = Integer.parseInt(array[2]);
            result = String.valueOf((Service.calculate(array, first, second)));
        }
        return result;
    }

}
