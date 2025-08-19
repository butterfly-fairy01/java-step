import java.util.*;

public class TextProcessor {

    // Clean input
    public static String cleanInput(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    // Analyze text
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replace(" ", "").length();
        int sentenceCount = text.split("[.!?]").length;

        // Longest word
        String longestWord = "";
        for (String w : words) {
            if (w.length() > longestWord.length()) {
                longestWord = w;
            }
        }

        // Most common character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommon = ' ';
        int maxCount = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) > maxCount) {
                mostCommon = c;
                maxCount = freq.get(c);
            }
        }

        System.out.println("\n=== ANALYSIS ===");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommon);
    }

    // Get sorted words
    public static String[] getWordsSorted(String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);

        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\nWords in Alphabetical Order:");
        for (String w : sortedWords) {
            System.out.println(w);
        }

        // Word search
        System.out.print("\nEnter word to search: ");
        String search = scanner.nextLine();
        boolean found = Arrays.stream(sortedWords).anyMatch(w -> w.equalsIgnoreCase(search));
        System.out.println("Word Found? " + (found ? "Yes" : "No"));

        scanner.close();
    }
}