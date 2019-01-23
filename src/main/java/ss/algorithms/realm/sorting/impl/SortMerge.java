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
import ss.algorithms.realm.sorting.BaseSorting;
import ss.algorithms.realm.sorting.SortStatistic;

/**
 * Sort using merging.
 * @author ss
 */
public class SortMerge extends BaseSorting {
    @Override
    public SortStatistic sort(Comparable[] a, boolean tracing, boolean isGraphicMode) {
        int n = a.length;
        SortStatistic statistic = new SortStatistic();
        Optional<SortStatistic> optionalStatistic = Optional.of(statistic);
        if (tracing) {
            printTraceHead(n, new String[] {"low", "high"}, isGraphicMode);
        }
        Comparable[] aux = new Comparable[n];
        elemenarySort(a, 0, n - 1, aux, optionalStatistic, tracing, isGraphicMode);
        return statistic;
    }
    private void elemenarySort(Comparable[] a, int low, int high, Comparable[] aux, 
            Optional<SortStatistic> optionalStatistic, boolean tracing, boolean isGraphicMode) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        elemenarySort(a, low, middle, aux, optionalStatistic, tracing, isGraphicMode);
        elemenarySort(a, middle + 1, high, aux, optionalStatistic, tracing, isGraphicMode);
        merge(a, low, middle, high, aux, optionalStatistic, tracing, isGraphicMode);
    }
}
