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
 * Sort statistic.
 * @author ss
 */
public class SortStatistic {
    /** Theoretical comparisons. */
    private final String theoreticalComparisons;
    /**
     * Theoretical comparisons function, accepts an array length,
     * returns theoretical comparisons.
     * Calculated average value.
     */
    private final Function<Integer, Integer> theoreticalComparisonsFuncAvg;
    /**
     * Theoretical comparisons function, accepts an array length,
     * returns theoretical comparisons.
     * Calculated the best value.
     */
    private final Function<Integer, Integer> theoreticalComparisonsFuncBest;
    /**
     * Theoretical comparisons function, accepts an array length,
     * returns theoretical comparisons.
     * Calculated the worst value.
     */
    private final Function<Integer, Integer> theoreticalComparisonsFuncWorst;
    /** Theoretical exchanges.*/
    private final String theoreticalExchanges;
    /**
     * Theoretical exchanges function, accepts an array length,
     * returns theoretical exchanges.
     * Calculated average value.
     */
    private final Function<Integer, Integer> theoreticalExchangesFuncAvg;
    /**
     * Theoretical exchanges function, accepts an array length,
     * returns theoretical exchanges.
     * Calculated the best value.
     */
    private final Function<Integer, Integer> theoreticalExchangesFuncBest;
    /**
     * Theoretical exchanges function, accepts an array length,
     * returns theoretical exchanges.
     * Calculated the worst value.
     */
    private final Function<Integer, Integer> theoreticalExchangesFuncWorst;
    /** Actual comparisons. */
    private int actualComparisons;
    /** Actual exchanges. */
    private int actualExchanges;
    /**
     * Constructor.
     * @param theoreticalComparisons theoretical comparisons.
     * @param theoreticalComparisonsFuncAvg theoretical comparisons function, average case.
     * @param theoreticalComparisonsFuncBest theoretical comparisons function, the best case.
     * @param theoreticalComparisonsFuncWorst theoretical comparisons function, the worst case.
     * @param theoreticalExchanges theoretical exchanges.
     * @param theoreticalExchangesFuncAvg theoretical exchanges function, average case.
     * @param theoreticalExchangesFuncBest theoretical exchanges function, the best case.
     * @param theoreticalExchangesFuncWorst theoretical exchanges function, the worst case.
     */
    public SortStatistic(String theoreticalComparisons,
            Function<Integer, Integer> theoreticalComparisonsFuncAvg,
            Function<Integer, Integer> theoreticalComparisonsFuncBest,
            Function<Integer, Integer> theoreticalComparisonsFuncWorst,
            String theoreticalExchanges,
            Function<Integer, Integer> theoreticalExchangesFuncAvg,
            Function<Integer, Integer> theoreticalExchangesFuncBest,
            Function<Integer, Integer> theoreticalExchangesFuncWorst) {
        this.theoreticalComparisons = theoreticalComparisons;
        this.theoreticalComparisonsFuncAvg = theoreticalComparisonsFuncAvg;
        this.theoreticalComparisonsFuncBest = theoreticalComparisonsFuncBest;
        this.theoreticalComparisonsFuncWorst = theoreticalComparisonsFuncWorst;
        this.theoreticalExchanges = theoreticalExchanges;
        this.theoreticalExchangesFuncAvg = theoreticalExchangesFuncAvg;
        this.theoreticalExchangesFuncBest = theoreticalExchangesFuncBest;
        this.theoreticalExchangesFuncWorst = theoreticalExchangesFuncWorst;
    }
    /**
     * Increment comparisons count.
     */
    public void incrementComparisons() {
        this.actualComparisons++;
    }
    /**
     * Increment exchanges count.
     */
    public void incrementExchanges() {
        this.actualExchanges++;
    }
    public void print(int arrayLength) {
        System.out.println("------------------------[ PRINT STATISTIC ]--------------------------");
        System.out.println("* Theoretical information:");
        System.out.println("--- comparisons: " + this.theoreticalComparisons);
        System.out.println("--- exchanges:   " + this.theoreticalExchanges);
        System.out.println("* Actual information:");
        System.out.println("--- comparisons: " + this.actualComparisons);
        System.out.println("--- exchanges:   " + this.actualExchanges);
        System.out.println("* Calculating via theoretical formulas, applied to the array: ");
        System.out.println("--- comparisons (the best):  "
                + this.theoreticalComparisonsFuncBest.apply(arrayLength));
        System.out.println("--- comparisons (average):   "
                + this.theoreticalComparisonsFuncAvg.apply(arrayLength));
        System.out.println("--- comparisons (the worst): "
                + this.theoreticalComparisonsFuncWorst.apply(arrayLength));
        System.out.println("--- exchanges (the best):    "
                + this.theoreticalExchangesFuncBest.apply(arrayLength));
        System.out.println("--- exchanges (average):     "
                + this.theoreticalExchangesFuncAvg.apply(arrayLength));
        System.out.println("--- exchanges (the worst):   "
                + this.theoreticalExchangesFuncWorst.apply(arrayLength));
        System.out.println("---------------------------------------------------------------------");
    }
}
