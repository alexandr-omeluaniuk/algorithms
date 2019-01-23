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

import ss.algorithms.realm.sorting.BaseSorting;
import ss.algorithms.realm.sorting.SortStatistic;

/**
 * Quick sort.
 * @author ss
 */
public class QuickSort extends BaseSorting {
    @Override
    protected String[] getTableLabels() {
        return new String[] {"low", "j", "high"};
    }
    @Override
    public SortStatistic sort(Comparable[] a) {
        int n = a.length;
        SortStatistic statistic = new SortStatistic();
        if (isTracing()) {
            printTraceHead(n);
            printTraceState(a, new String[] {"", "", ""}, (k) -> false, null);
        }
        sortSubArray(a, 0, a.length - 1, statistic);
        return statistic;
    }
    private void sortSubArray(Comparable[] a, int low, int high, SortStatistic statistic) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high, statistic);
        sortSubArray(a, low, j - 1, statistic);
        sortSubArray(a, j + 1, high, statistic);
    }
    private int partition(Comparable[] a, int low, int high, SortStatistic statistic) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v, statistic)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, a[--j], statistic)) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j, statistic);
            if (isTracing()) {
                final int index = i;
                final int index2 = j;
                printTraceState(a, new String[] {String.valueOf(low), String.valueOf(j),
                        String.valueOf(high)}, (k) -> k == index || k == index2,
                        CONSOLE_COLOR_GREEN);
            }
        }
        exchange(a, low, j, statistic);
        if (isTracing()) {
            final int index = j;
            final int index2 = low;
            printTraceState(a, new String[] {String.valueOf(low), String.valueOf(j),
                String.valueOf(high)}, (k) -> k == index || k == index2, CONSOLE_COLOR_RED);
        }
        return j;
    }
}
