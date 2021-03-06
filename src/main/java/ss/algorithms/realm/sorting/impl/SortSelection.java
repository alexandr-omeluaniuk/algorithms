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
 * Sort using selection.
 * @author ss
 */
public class SortSelection extends BaseSorting {
    @Override
    public String[] getTableLabels() {
        return new String[] {"i", "min"};
    }
    @Override
    public SortStatistic sort(Comparable[] a) {
        int n = a.length;
        SortStatistic statistic = new SortStatistic();
        statistic.setTheoreticalComparisons("always N^2/2 - N/2");
        statistic.setTheoreticalExchanges("always N");
        if (isTracing()) {
            printTraceHead(n);
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min], statistic)) {
                    min = j;
                }
            }
            exchange(a, i, min, statistic);
            if (isTracing()) {
                final int index = i;
                final int index2 = min;
                Function<Integer, Boolean> func = (k) -> k == index || k == index2;
                printTraceState(a, new String[] {String.valueOf(i), String.valueOf(min)}, func,
                        CONSOLE_COLOR_GREEN);
            }
        }
        return statistic;
    }
}
