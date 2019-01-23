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
 * Sort using 'Shell' algorithm.
 * @author ss
 */
public class SortShell extends BaseSorting {
    @Override
    public String[] getTableLabels() {
        return new String[] {"i", "j", "h"};
    }
    @Override
    public SortStatistic sort(Comparable[] a) {
        int n = a.length;
        SortStatistic statistic = new SortStatistic();
        if (isTracing()) {
            printTraceHead(n);
        }
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h], statistic); j -= h) {
                    exchange(a, j, j - h, statistic);
                    if (isTracing()) {
                        final int index = j;
                        final int index2 = j - h;
                        Function<Integer, Boolean> func = (k) -> k == index || k == index2;
                        printTraceState(a, new String[] {String.valueOf(i), String.valueOf(j),
                            String.valueOf(h)}, func, CONSOLE_COLOR_GREEN);
                    }
                }
            }
            h = h / 3;
        }
        return statistic;
    }
}
