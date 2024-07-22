import java.util.HashMap;
import java.util.Map;

public class SimpleNaiveBayesClassifier {
    private final String[] categories = {"sports", "politics", "technology"};
    private final Map<String, double[]> categoryProbabilities = new HashMap<>();

    public SimpleNaiveBayesClassifier() {
        // Predefined probabilities for words in each category
        categoryProbabilities.put("sports", new double[]{0.1, 0.3, 0.6});
        categoryProbabilities.put("politics", new double[]{0.2, 0.5, 0.3});
        categoryProbabilities.put("technology", new double[]{0.4, 0.2, 0.4});
    }

    public String classify(String text) {
        double[] textVector = textToVector(text);
        double[] scores = new double[categories.length];

        for (int i = 0; i < categories.length; i++) {
            double[] probabilities = categoryProbabilities.get(categories[i]);
            scores[i] = dotProduct(textVector, probabilities);
        }

        int bestCategoryIndex = indexOfMax(scores);
        return categories[bestCategoryIndex];
    }

    private double[] textToVector(String text) {
        double[] vector = new double[3]; // Assuming 3 features

        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.equalsIgnoreCase("football") || word.equalsIgnoreCase("basketball")) {
                vector[0]++;
            } else if (word.equalsIgnoreCase("election") || word.equalsIgnoreCase("government")) {
                vector[1]++;
            } else if (word.equalsIgnoreCase("technology") || word.equalsIgnoreCase("innovation")) {
                vector[2]++;
            }
        }

        return vector;
    }

    private double dotProduct(double[] vector1, double[] vector2) {
        double result = 0;
        for (int i = 0; i < vector1.length; i++) {
            result += vector1[i] * vector2[i];
        }
        return result;
    }

    private int indexOfMax(double[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
