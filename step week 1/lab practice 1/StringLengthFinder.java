import java.util.Scanner;

class StringLengthFinder {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) { }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int lengthCustom = findLength(input);
        int lengthBuiltIn = input.length();

        System.out.println("Length (without length()): " + lengthCustom);
        System.out.println("Length (using length()): " + lengthBuiltIn);
        sc.close();
    }
}