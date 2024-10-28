import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChromosomeTest extends Chromosome<ChromosomeTest> {
    private double[] genes;
    private java.util.Arrays Arrays;

    public ChromosomeTest(double[] genes) {
        this.genes = genes;
    }

    public double[] getGenes() {
        return genes;
    }

    @Override
    public double fitness() {
        return Arrays.stream(genes).sum();
    }

    @Override
    public List<ChromosomeTest> crossover(ChromosomeTest other) {
        double[] newGenes = new double[genes.length];
        for (int i = 0; i < genes.length; i++) {
            newGenes[i] = (this.genes[i] + other.genes[i]) / 2; // Среднее значение генов
        }
        return Collections.singletonList(new ChromosomeTest(newGenes));
    }

    @Override
    public void mutate() {
        int index = new Random().nextInt(genes.length);
        genes[index] += new Random().nextDouble() - 0.5; // Модификация значения в диапазоне -0.5 до +0.5
    }

    @Override
    public ChromosomeTest copy() {
        return new ChromosomeTest(genes.clone()); // Клонирование массива генов
    }
}

