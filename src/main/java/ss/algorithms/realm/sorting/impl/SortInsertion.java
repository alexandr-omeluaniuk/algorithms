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

import java.util.Optional;
import java.util.function.Function;
import ss.algorithms.realm.sorting.BaseSorting;
import ss.algorithms.realm.sorting.SortStatistic;

/**
 * Sort using insertion.
 * @author ss
 */
public class SortInsertion extends BaseSorting {
    @Override
    public String[] getTableLabels() {
        return new String[] {"i", "j"};
    }
    @Override
    public SortStatistic sort(Comparable[] a) {
        int n = a.length;
        SortStatistic statistic = new SortStatistic();
        statistic.setTheoreticalComparisons("avarage N^2/2, the best N-1, the worst N^2");
        statistic.setTheoreticalExchanges("average N^2/2, the best 0, the worst N^2");
        Optional<SortStatistic> optionalStatistic = Optional.of(statistic);
        if (isTracing()) {
            printTraceHead(n);
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j -1], optionalStatistic); j--) {
                exchange(a, j, j-1, optionalStatistic);
                if (isTracing()) {
                    final int index = j;
                    final int index2 = j-1;
                    Function<Integer, Boolean> func = (k) -> k == index || k == index2;
                    printTraceState(a, new String[] {String.valueOf(i), String.valueOf(j)}, func);
                }
            }
        }
        assert(isSorted(a));
        return statistic;
    }
}
