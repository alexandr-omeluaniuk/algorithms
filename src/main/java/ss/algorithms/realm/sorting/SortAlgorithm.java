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

import ss.algorithms.core.AlgorithmImplementation;

/**
 * Sort algorithm.
 * @author ss
 */
public interface SortAlgorithm extends AlgorithmImplementation {
    /**
     * Sort array of comparable items.
     * @param a array of comparable items.
     * @param tracing trace output.
     */
    void sort(Comparable[] a, boolean tracing);
    /**
     * Check if v less than w;
     * @param v the first comparable item.
     * @param w the second comparable item.
     * @return true if v less than w.
     */
    boolean less(Comparable v, Comparable w);
    /**
     * Make items exchange into array.
     * @param a array of comparable items.
     * @param i index of the first exchangeable item.
     * @param j index of the second exchangeable item.
     */
    void exchange(Comparable[] a, int i, int j);
    /**
     * Output an array of comparable items.
     * @param a array of comparable items.
     */
    void outputArray(Comparable[] a);
    /**
     * Check if an array is sorted properly.
     * @param a an array of comparable items.
     * @return true if it is sorted.
     */
    boolean isSorted(Comparable[] a);
}
