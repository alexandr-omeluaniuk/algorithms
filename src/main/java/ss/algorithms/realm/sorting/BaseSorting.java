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
package ss.algorithms.realm.sorting;

import java.util.Optional;
import java.util.function.Function;
import ss.algorithms.core.RandomGenerator;

/**
 * Sorting common methods.
 * @author ss
 */
public abstract class BaseSorting implements SortAlgorithm {
    /** Separator. */
    private static final String SEPARATOR = " ";
    /** Console color: green. */
    private static final String CONSOLE_COLOR_GREEN = "\u001B[32m";
    /** Console color: nornal. */
    private static final String CONSOLE_COLOR_NORMAL = "\033[0m";
    @Override
    public boolean less(Comparable v, Comparable w, Optional<SortStatistic> statistic) {
        if (statistic.isPresent()) {
            statistic.get().incrementComparisons();
        }
        return v.compareTo(w) < 0;
    }
    @Override
    public void exchange(Comparable[] a, int i, int j, Optional<SortStatistic> statistic) {
        if (statistic.isPresent()) {
            statistic.get().incrementExchanges();
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    @Override
    public void outputArray(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }
    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i = 1], null)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        Comparable[] a = RandomGenerator.randomArrayOfNumbers(32);
        System.out.println("Source array:");
        outputArray(a);
        SortStatistic statistic = sort(a, true);
        System.out.println("Sorted array:");
        outputArray(a);
        System.out.println("");
        statistic.print(a.length);
    }
// ===================================== PROTECTED ================================================
    /**
     * Print trace head.
     * @param n array length.
     * @param labels first columns labels.
     */
    protected void printTraceHead(int n, String[] labels) {
        System.out.println("");
        StringBuilder sb = new StringBuilder();
        for (String label : labels) {
            int minLength = label.length() > String.valueOf(n).length()
                    ? label.length() : String.valueOf(n).length();
            sb.append(minLength > label.length()
                    ? SEPARATOR.repeat(minLength - label.length()) + label : label)
                    .append(SEPARATOR);
        }
        sb.append("|");
        int width = String.valueOf(n).length() + 1;
        for (int i = 0; i < n; i++) {
            sb.append(SEPARATOR.repeat(width - String.valueOf(i).length())).append(i)
                    .append(SEPARATOR);
        }
        System.out.println(sb);
        System.out.println("-".repeat(sb.length()));
    }
    /**
     * Print intermediate array state.
     * @param a array.
     * @param values values for the first 'info' columns, depends on header configuration.
     * @param highlightCondition highlight cell condition.
     */
    protected void printTraceState(Comparable[] a, String[] values,
            Function<Integer, Boolean> highlightCondition) {
        int n = a.length;
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            int minLength = value.length() > String.valueOf(n).length()
                    ? value.length() : String.valueOf(n).length();
            sb.append(minLength > value.length()
                    ? SEPARATOR.repeat(minLength - value.length()) + value : value)
                    .append(SEPARATOR);
        }
        sb.append(" |");
        int width = String.valueOf(n).length() + 1;
        for (int k = 0; k < n; k++) {
            sb.append(SEPARATOR.repeat(width - a[k].toString().length()))
                    .append(highlightCondition.apply(k) ? CONSOLE_COLOR_GREEN : "")
                    .append(a[k]).append(highlightCondition.apply(k) ? CONSOLE_COLOR_NORMAL : "")
                    .append(SEPARATOR);
        }
        System.out.println(sb);
    }
}
