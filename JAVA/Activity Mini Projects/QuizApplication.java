import java.util.*;

class Question {
    final String q;
    final List<String> options;
    final int answerIndex;

    Question(String q, List<String> options, int idx) {
        this.q = q;
        this.options = options;
        this.answerIndex = idx;
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> bank = new ArrayList<>();

        bank.add(new Question("Capital of India?", List.of("Mumbai", "New Delhi", "Kolkata", "Chennai"), 1));
        bank.add(new Question("2+2=?", List.of("3", "4", "5", "6"), 1));

        int score = 0;
        for (int i = 0; i < bank.size(); i++) {
            Question qu = bank.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + qu.q);
            for (int j = 0; j < qu.options.size(); j++)
                System.out.println((j + 1) + ". " + qu.options.get(j));
            System.out.print("Answer: ");
            int a = Integer.parseInt(sc.nextLine()) - 1;
            if (a == qu.answerIndex) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong. Correct: " + qu.options.get(qu.answerIndex));
            }
        }
        System.out.println("Score: " + score + "/" + bank.size());
    }
}
