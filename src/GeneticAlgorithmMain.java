import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmMain {
    public static void main(String[] args) {
        // Инициализация начальной популяции
        List<ChromosomeTest> initialPopulation = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            double[] genes = {Math.random(), Math.random()}; // 2 гена
            initialPopulation.add(new ChromosomeTest(genes));
        }

        // Параметры алгоритма
        double mutationChance = 0.1; // 10% вероятность мутации
        double crossoverChance = 0.9; // 90% вероятность кроссовера
        GeneticAlgorithm<ChromosomeTest> ga = new GeneticAlgorithm<>(
                initialPopulation,
                mutationChance,
                crossoverChance,
                GeneticAlgorithm.SelectionType.ROULETTE
        );

        // Запуск алгоритма
        Chromosome best = ga.run(100, 2.5); // 100 генераций, целевое значение 2.5

        // Вывод результатов
        System.out.println("Best Fitness: " + best.fitness());
    }
}

