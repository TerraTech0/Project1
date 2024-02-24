import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Scanner data = new Scanner(System.in);
    static ArrayList<Double> results = new ArrayList<Double>();
    public static void main(String[] args) {
        try {
            operations();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void operations() throws Exception{

        while (true) {
            System.out.println("Choose the operation: ");
            System.out.println("Enter 1 to addition the numbers: ");
            System.out.println("Enter 2 to subtration the numbers: ");
            System.out.println("Enter 3 to multiplication the numbers: ");
            System.out.println("Enter 4 to division the numbers: ");
            System.out.println("Enter 5 to moduls the numbers: ");
            System.out.println("Enter 6 to find minmum number: ");
            System.out.println("Enter 7 to find maximum number: ");
            System.out.println("Enter 8 to find the average of numbers: ");
            System.out.println("Enter 9 to print the last results in calculater: ");
            System.out.println("Enter 10 to print the list of all results in calculater: ");
            try {
                if (data.hasNextInt()){
                    int operation = data.nextInt();

                    int number1, number2, number3;

                    double sum = 0.0;
                    switch (operation) {
                        case 1:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            sum = number1 + number2 + number3;
                            System.out.println(sum);
                            results.add((double) sum);
                            break;
                        case 2:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            int sub = number1 - number2 - number3;
                            System.out.println(sub);
                            results.add((double) sum);
                            break;
                        case 3:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            int mult = number1 * number2 * number3;
                            System.out.println(mult);
                            results.add((double) sum);
                            break;
                        case 4:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            int div = number1 / number2 / number3;
                            System.out.println(div);
                            results.add((double) sum);
                            break;
                        case 5:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            int mod = number1 % number2 % number3;
                            System.out.println(mod);
                            results.add((double) sum);
                            break;
                        case 6:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            if (number1 < number2 && number1 < number3) {
                                System.out.println("the min number is: " + number1);
                            } else if (number2 < number1 && number2 < number3) {
                                System.out.println("the min number is: " + number2);
                            } else {
                                System.out.println("the min number is: " + number3);
                            }
                            results.add((double) sum);
                            break;
                        case 7:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            if (number1 > number2 && number1 > number3) {
                                System.out.println("the max number is: " + number1);
                            } else if (number2 > number1 && number2 > number3) {
                                System.out.println("the max number is: " + number2);
                            } else {
                                System.out.println("the max number is: " + number3);
                            }
                            results.add((double) sum);
                            break;
                        case 8:
                            System.out.print("Enter first number: ");
                            number1 = data.nextInt();
                            System.out.print("Enter second number: ");
                            number2 = data.nextInt();
                            System.out.print("Enter third number: ");
                            number3 = data.nextInt();
                            sum = number1 + number2 + number3;
                            double avreage = sum / 3;
                            System.out.println("The average is: " + avreage);
                            results.add(sum);
                            results.add((double) sum);
                            break;
                        case 9:
                            if (!results.isEmpty()) {
                                System.out.println("Last resutl: " + results.get(results.size() - 1));
                            } else {
                                System.out.println("No results available.");
                            }
                            break;
                        case 10:
                            System.out.println("List of all results: ");
                            for (double result : results) {
                                System.out.println(result);
                            }
                            break;
                        default:
                            throw new Exception("Invalid input, Please enter a valid operation.");
                    }

                }else {
                    throw new InputMismatchException("Please enter a valid number: ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please etner number!:");
                data.nextLine();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            } finally {
                System.out.println("Thanks");
            }
        }
    }

}
