/*
 * Copyright (C) 2019 ss
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ss.algorithms.task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import ss.algorithms.constants.Algorithm;
import ss.algorithms.constants.Realm;
import ss.algorithms.constants.RealmTaskArg;
import ss.algorithms.core.RandomGenerator;
import ss.algorithms.core.Task;
import ss.algorithms.realm.sorting.SortAlgorithm;
import ss.algorithms.realm.sorting.SortStatistic;
import ss.console.ConsoleDrawer;

/**
 * Compare sort algorithms.
 * @author ss
 */
public class SortCompare implements Task {
    @Override
    public void run(Map<RealmTaskArg, Object> args) throws Exception {
        Integer arrayLength = (Integer) args.get(RealmTaskArg.ARRAY_LENGTH);
        System.out.println("Source array length: " + arrayLength);
        Map<Algorithm, SortAlgorithm> sortAlgorithms = new HashMap<>();
        for (Algorithm alg : Algorithm.values()) {
            if (Realm.SORTING == alg.getRealm()) {
                SortAlgorithm sortAlgorithm = (SortAlgorithm) alg.getImplementation()
                        .getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                sortAlgorithms.put(alg, sortAlgorithm);
            }
        }
        final int rows = 4;
        final int columns = sortAlgorithms.size() + 1;
        String[][] output = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] row = new String[columns];
            switch (i) {
                case 0:
                    row[0] = "Algorithm name";
                    break;
                case 1:
                    row[0] = "Exchanges";
                    break;
                case 2:
                    row[0] = "Comparisons";
                    break;
                case 3:
                    row[0] = "Elapsed time";
                    break;
                default:
                    break;
            }
            output[i] = row;
        }
        int currentColumn = 1;
        Comparable[] a = RandomGenerator.randomArrayOfNumbers(arrayLength);
        for (Algorithm alg : sortAlgorithms.keySet()) {
//            if (Algorithm.SORT_SELECTION == alg || Algorithm.SORT_INSERTION == alg) {
//                continue;
//            }
            Comparable[] aCopy = new Comparable[a.length];
            System.arraycopy(a, 0, aCopy, 0, a.length);
            SortAlgorithm sa = sortAlgorithms.get(alg);
            long start = System.currentTimeMillis();
            SortStatistic statistic = sa.sort(aCopy);
            long elapsedTime = System.currentTimeMillis() - start;
            long exchanges = statistic.getExchanges();
            long comparisons = statistic.getComparisons();
            for (int currentRow = 0; currentRow < rows; currentRow++) {
                String[] row = output[currentRow];
                switch (currentRow) {
                    case 0:
                        row[currentColumn] = alg.name();
                        break;
                    case 1:
                        row[currentColumn] = String.valueOf(exchanges);
                        break;
                    case 2:
                        row[currentColumn] = String.valueOf(comparisons);
                        break;
                    case 3:
                        row[currentColumn] = elapsedTime + " ms";
                        break;
                }
            }
            currentColumn++;
        }
        ConsoleDrawer.printTable(output);
        Comparable[] aCopy = new Comparable[a.length];
        System.arraycopy(a, 0, aCopy, 0, a.length);
        long start = System.currentTimeMillis();
        Arrays.sort(aCopy);
        System.out.println("Native Java sort: " + (System.currentTimeMillis() - start));
    }
}
