import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class GeneticAlgorithmTest extends TestCase {

    public void testResult() {
        List<ChromosomeTest> initialPopulation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double[] genes = {Math.random(), Math.random(), Math.random()};  //3 гена
            initialPopulation.add(new ChromosomeTest(genes));
        }

//         Параметры алгоритма
        double mutationChance = 0.1;  //10% вероятность мутации
        double crossoverChance = 0.9;  //90% вероятность кроссовера
        GeneticAlgorithm<ChromosomeTest> ga = new GeneticAlgorithm<>(
                initialPopulation,
                mutationChance,
                crossoverChance,
                GeneticAlgorithm.SelectionType.ROULETTE
        );

//         Запуск алгоритма
        Chromosome best = ga.run(100, 2.5);  //100 генераций, целевое значение 2.5

        assertTrue(Math.abs(best.fitness() - 2.5) <= 1);
    }

    public void testCrossover() {
        var daniil = new ChromosomeTest(new double[] { 1.0, 2.0 });
        var denis = new ChromosomeTest(new double[] { 2.0, 1.0 });
        var expected = new double[] { 1.5, 1.5 };
        var res = daniil.crossover(denis).get(0).getGenes();
        assertEquals(expected.length, res.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], res[i]);
        }
    }

}
