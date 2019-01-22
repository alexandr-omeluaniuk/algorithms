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
    /** Graphic symbols. */
    private static final char[] SYMBOLS = new char[] {
        0x2581, 0x2582, 0x2583, 0x2584, 0x2585, 0x2586, 0x2587, 0x2588
    };
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
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i = 1], null)) {
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
     * @param isGraphicMode enable graphic mode for tracing.
     */
    protected void printTraceHead(int n, String[] labels, boolean isGraphicMode) {
        System.out.println("");
        StringBuilder sb = new StringBuilder();
        for (String label : labels) {
            int minLength = label.length() > String.valueOf(n).length()
                    ? label.length() : String.valueOf(n).length();
            sb.append(minLength > label.length()
                    ? SEPARATOR.repeat(minLength - label.length()) + label : label)
                    .append(SEPARATOR);
        }
        sb.append(" |");
        int labelsWidth = sb.length();
        int width = isGraphicMode ? 1 : String.valueOf(n).length() + 1;
        for (int i = 0; i < n; i++) {
            sb.append(isGraphicMode ? "" : SEPARATOR.repeat(width - String.valueOf(i).length()))
                    .append(isGraphicMode ? "" : i).append(SEPARATOR);
        }
        System.out.println(sb);
        System.out.println("-".repeat(isGraphicMode ? labelsWidth + n : sb.length()));
    }
    /**
     * Print intermediate array state.
     * @param a array.
     * @param values values for the first 'info' columns, depends on header configuration.
     * @param highlightCondition highlight cell condition.
     * @param isGraphicMode enable graphic mode.
     */
    protected void printTraceState(Comparable[] a, String[] values,
            Function<Integer, Boolean> highlightCondition, boolean isGraphicMode) {
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
        int width = isGraphicMode ? 0 : String.valueOf(n).length() + 1;
        int max = 0;
        for (Comparable item : a) {
            if (item instanceof Integer) {
                Integer itemI = (Integer) item;
                if (itemI > max) {
                    max = itemI;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            Object value;
            if (isGraphicMode && max > 0) {
                double tmp = Double.valueOf(a[k].toString()) / max;
                int index = (int) Math.ceil(tmp * (SYMBOLS.length - 1) / max * 100);
                value = String.valueOf(SYMBOLS[index - 1]);
            } else {
                value = a[k];
            }
            sb.append(SEPARATOR.repeat(isGraphicMode ? width : width - a[k].toString().length()))
                    .append(highlightCondition.apply(k) ? CONSOLE_COLOR_GREEN : "")
                    .append(value)
                    .append(highlightCondition.apply(k) ? CONSOLE_COLOR_NORMAL : "")
                    .append(SEPARATOR);
        }
        System.out.println(sb);
    }
}
