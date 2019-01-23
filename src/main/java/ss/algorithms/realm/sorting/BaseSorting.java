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
    protected static final String CONSOLE_COLOR_GREEN = "\u001B[32m";
    /** Console color: green. */
    protected static final String CONSOLE_COLOR_RED = "\u001B[31m";
    /** Console color: nornal. */
    private static final String CONSOLE_COLOR_NORMAL = "\033[0m";
    /** Graphic symbols. */
    private static final char[] SYMBOLS = new char[] {
        0x2581, 0x2582, 0x2583, 0x2584, 0x2585, 0x2586, 0x2587, 0x2588
    };
    /** Is tracing enabled. */
    private boolean tracing = false;
    /** Is tracing graphic mode enabled. */
    private boolean isGraphicMode = false;
    /** Trace table head labels. */
    protected String[] tableLabels;
    @Override
    public boolean less(Comparable v, Comparable w, SortStatistic statistic) {
        if (statistic != null) {
            statistic.incrementComparisons();
        }
        return v.compareTo(w) < 0;
    }
    @Override
    public void exchange(Comparable[] a, int i, int j, SortStatistic statistic) {
        if (statistic != null) {
            statistic.incrementExchanges();
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1], null)) {
                return false;
            }
        }
        return true;
    }
// ===================================== PROTECTED ================================================
    /**
     * Print trace head.
     * @param n array length.
     */
    protected void printTraceHead(int n) {
        System.out.println("");
        StringBuilder sb = new StringBuilder();
        for (String label : getTableLabels()) {
            int minLength = label.length() > String.valueOf(n).length()
                    ? label.length() : String.valueOf(n).length();
            sb.append(minLength > label.length()
                    ? SEPARATOR.repeat(minLength - label.length()) + label : label)
                    .append(SEPARATOR);
        }
        sb.append("|");
        int labelsWidth = sb.length();
        int width = isGraphicMode ? 1 : String.valueOf(n).length() + 1;
        for (int i = 0; i < n; i++) {
            sb.append(isGraphicMode ? "" : SEPARATOR.repeat(width - String.valueOf(i).length()))
                    .append(isGraphicMode ? "" : i).append(SEPARATOR);
        }
        System.out.println(sb);
        System.out.println("-".repeat(isGraphicMode ? labelsWidth + n * 2 : sb.length()));
    }
    /**
     * Print intermediate array state.
     * @param a array.
     * @param values values for the first 'info' columns, depends on header configuration.
     * @param highlightCondition highlight cell condition.
     * @param color highlight color.
     */
    protected void printTraceState(Comparable[] a, String[] values,
            Function<Integer, Boolean> highlightCondition, String color) {
        int n = a.length;
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (String value : values) {
            int minLength = value.length() > String.valueOf(n).length()
                    ? value.length() : String.valueOf(n).length();
            minLength = minLength < this.getTableLabels()[counter].length()
                    ? this.getTableLabels()[counter].length() : minLength;
            sb.append(minLength > value.length()
                    ? SEPARATOR.repeat(minLength - value.length()) + value : value)
                    .append(SEPARATOR);
            counter++;
        }
        sb.append("|");
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
                Double tm2 = tmp * (SYMBOLS.length - 1) / max * 100;
                int index = tm2.intValue();
                value = String.valueOf(
                        SYMBOLS[index > SYMBOLS.length - 1 ? SYMBOLS.length - 1 : index]);
            } else {
                value = a[k];
            }
            sb.append(SEPARATOR.repeat(isGraphicMode ? width : width - a[k].toString().length()))
                    .append(highlightCondition.apply(k) ? color : "")
                    .append(value)
                    .append(highlightCondition.apply(k) ? CONSOLE_COLOR_NORMAL : "")
                    .append(SEPARATOR);
        }
        System.out.println(sb);
    }
// ========================================== SETTERS =============================================
    /**
     * @param tracing the tracing to set
     */
    @Override
    public void setTracing(boolean tracing) {
        this.tracing = tracing;
    }
    /**
     * @param isGraphicMode the isGraphicMode to set
     */
    @Override
    public void setIsGraphicMode(boolean isGraphicMode) {
        this.isGraphicMode = isGraphicMode;
    }
// ========================================= GETTERS ==============================================
    /**
     * @return the tracing
     */
    public boolean isTracing() {
        return tracing;
    }
    protected abstract String[] getTableLabels();
}
