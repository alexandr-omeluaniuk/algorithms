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

import java.util.UUID;
import java.util.function.Function;
import ss.algorithms.realm.sorting.BaseSorting;

/**
 * Sort using selection.
 * @author ss
 */
public class SortSelection extends BaseSorting {
    @Override
    public void sort(Comparable[] a, boolean tracing) {
        int n = a.length;
        if (tracing) {
            printTraceHead(n, new String[] {"i", "min"});
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
            if (tracing) {
                final int index = i;
                Function<Integer, Boolean> func = (k) -> k == index;
                printTraceState(a, new String[] {String.valueOf(i), String.valueOf(min)}, i, func);
            }
        }
        if (tracing) {
            System.err.println("");
        }
        assert(isSorted(a));
    }
    @Override
    public void run() {
        String random = UUID.randomUUID().toString();
        Comparable[] a = random.split("");
        System.out.println("Source array:");
        outputArray(a);
        sort(a, true);
        System.out.println("Sorted array:");
        outputArray(a);
    }
}
