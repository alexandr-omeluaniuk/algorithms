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

import java.util.function.Function;

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
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    @Override
    public void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    @Override
    public void outputArray(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item);
        }
        System.out.println("");
    }
    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i = 1])) {
                return false;
            }
        }
        return true;
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
        int width = String.valueOf(n).length();
        for (int i = 0; i < n; i++) {
            sb.append(SEPARATOR.repeat(width - String.valueOf(i).length())).append(i)
                    .append(SEPARATOR);
        }
        System.out.println(sb);
        System.out.println("-".repeat(sb.length()));
    }
    protected void printTraceState(Comparable[] a, String[] values, int j,
            Function<Integer, Boolean> highlightCondition) {
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            int minLength = value.length() > String.valueOf(a.length).length()
                    ? value.length() : String.valueOf(a.length).length();
            sb.append(minLength > value.length()
                    ? SEPARATOR.repeat(minLength - value.length()) + value : value)
                    .append(SEPARATOR);
        }
        int repeatSeparator = String.valueOf(a.length).length() - 1;
        for (int k = 0; k < a.length; k++) {
            sb.append(SEPARATOR.repeat(repeatSeparator))
                    .append(highlightCondition.apply(k) ? CONSOLE_COLOR_GREEN : "")
                    .append(a[k]).append(highlightCondition.apply(k) ? CONSOLE_COLOR_NORMAL : "")
                    .append(SEPARATOR);
        }
        System.out.println(sb);
    }
}
