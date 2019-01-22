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
 * Sort using selection.
 * @author ss
 */
public class SortSelection extends BaseSorting {
    @Override
    public SortStatistic sort(Comparable[] a, boolean tracing) {
        int n = a.length;
        Function<Integer, Integer> comparisionsAlways =
                (arrayLength) -> Math.round((float) Math.pow(arrayLength, 2) / 2
                        - Math.round(arrayLength / 2));
        Function<Integer, Integer> exchangesAlways = (arrayLength) -> arrayLength;
        SortStatistic statistic = new SortStatistic("always N^2/2 - N/2",
                comparisionsAlways, comparisionsAlways, comparisionsAlways,
                "always N",
                exchangesAlways, exchangesAlways, exchangesAlways);
        Optional<SortStatistic> optionalStatistic = Optional.of(statistic);
        if (tracing) {
            printTraceHead(n, new String[] {"i", "min"});
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min], optionalStatistic)) {
                    min = j;
                }
            }
            exchange(a, i, min, optionalStatistic);
            if (tracing) {
                final int index = i;
                Function<Integer, Boolean> func = (k) -> k == index;
                printTraceState(a, new String[] {String.valueOf(i), String.valueOf(min)}, func);
            }
        }
        if (tracing) {
            System.out.println("");
        }
        assert(isSorted(a));
        return statistic;
    }
}
