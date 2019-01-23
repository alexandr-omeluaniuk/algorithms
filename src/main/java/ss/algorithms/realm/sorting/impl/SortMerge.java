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
package ss.algorithms.realm.sorting.impl;

import java.util.function.Function;
import ss.algorithms.realm.sorting.BaseSorting;
import ss.algorithms.realm.sorting.SortStatistic;

/**
 * Sort using merging.
 * @author ss
 */
public class SortMerge extends BaseSorting {
    @Override
    public String[] getTableLabels() {
        return new String[] {"low", "high"};
    }
    @Override
    public SortStatistic sort(Comparable[] a) {
        int n = a.length;
        SortStatistic statistic = new SortStatistic();
        statistic.setTheoreticalComparisons("the best 1/2 * NlgN, the worst NlgN");
        if (isTracing()) {
            printTraceHead(n);
        }
        Comparable[] aux = new Comparable[n];
        sortSubArray(a, 0, n - 1, aux, statistic);
        return statistic;
    }
    /**
     * Sort two sub arrays.
     * @param a full array.
     * @param low low full array index.
     * @param high high full array index.
     * @param aux auxiliary array for copy.
     * @param statistic sort statistic.
     */
    private void sortSubArray(Comparable[] a, int low, int high, Comparable[] aux, 
            SortStatistic statistic) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        sortSubArray(a, low, middle, aux, statistic);
        sortSubArray(a, middle + 1, high, aux, statistic);
        merge(a, low, middle, high, aux, statistic);
    }
    /**
     * Merge two sorted sub-arrays into one array.
     * @param a two sorted sub-arrays.
     * @param low the first sub-array start index.
     * @param middle the second sub-array start index.
     * @param high the second sub-array end index.
     * @param aux auxiliary array, length must match with 'a' array.
     * @param statistic sort statistic.
     */
    private void merge(Comparable[] a, int low, int middle, int high, Comparable[] aux,
            SortStatistic statistic) {
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i], statistic)) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
            statistic.incrementExchanges();
        }
        if (isTracing()) {
            Function<Integer, Boolean> func = (idx) -> idx >= low && idx <= high;
            printTraceState(a, new String[] {String.valueOf(low), String.valueOf(high)}, func,
                    CONSOLE_COLOR_GREEN);
        }
    }
}
