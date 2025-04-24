

public class ProbabilitySet {
    private Integer[] probabilities = new Integer[93];
    public ProbabilitySet(int i) {
        probabilities[i] = 1;
    }

    public void inc(int i) {
        probabilities[i] ++;
    }
}
