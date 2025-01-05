import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int exitNumber = 0;
        int number = scan.nextInt();
        scan.nextLine();
        String symbols = scan.nextLine();
        if (number > 1) {
            if (symbols.charAt(0) == '>' && symbols.charAt(number - 1) == '<') {
                // exitNumber = 0;
            } else {
                if (symbols.charAt(0) == '<') {
                    exitNumber++;
                }
                if (symbols.charAt(number - 1) == '>') {
                    exitNumber++;
                }

                if (symbols.charAt(0) == '<') {
                    int i = 0;
                    while (i < (number - 1)) {
                        exitNumber += CheckExit(symbols, i);
                        if (CheckExit(symbols, i) == 0) {
                            break;
                        }
                        i++;
                    }
                }
                if (symbols.charAt(number - 1) == '>') {
                    int i = (number - 1);
                    while (i > 0) {
                        exitNumber += UCheckExit(symbols, i);
                        if (UCheckExit(symbols, i) == 0) {
                            break;
                        }
                        i--;
                    }
                }
            }
        } else {
            exitNumber++;
        }
        System.out.println(exitNumber);
    }

    public static int CheckExit(String symbols, int i) {
        int exit = 0;
        if ((i + 1) >= 0) {
            if (symbols.charAt(i) == '<' && symbols.charAt(i + 1) == '<') {
                exit++;
            }
        }
        return exit;
    }

    public static int UCheckExit(String symbols, int i) {
        int exit = 0;
        if ((i - 1) >= 0) {
            if (symbols.charAt(i) == '>' && symbols.charAt(i - 1) == '>') {
                exit++;
            }
        }
        return exit;
    }
}