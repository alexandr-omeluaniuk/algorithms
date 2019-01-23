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
    private String theoreticalComparisons;
    /**
     * Theoretical comparisons function, accepts an array length,
     * returns theoretical comparisons.
     * Calculated average value.
     */
    private Function<Integer, Integer> theoreticalComparisonsFuncAvg;
    /**
     * Theoretical comparisons function, accepts an array length,
     * returns theoretical comparisons.
     * Calculated the best value.
     */
    private Function<Integer, Integer> theoreticalComparisonsFuncBest;
    /**
     * Theoretical comparisons function, accepts an array length,
     * returns theoretical comparisons.
     * Calculated the worst value.
     */
    private Function<Integer, Integer> theoreticalComparisonsFuncWorst;
    /** Theoretical exchanges.*/
    private String theoreticalExchanges;
    /**
     * Theoretical exchanges function, accepts an array length,
     * returns theoretical exchanges.
     * Calculated average value.
     */
    private Function<Integer, Integer> theoreticalExchangesFuncAvg;
    /**
     * Theoretical exchanges function, accepts an array length,
     * returns theoretical exchanges.
     * Calculated the best value.
     */
    private Function<Integer, Integer> theoreticalExchangesFuncBest;
    /**
     * Theoretical exchanges function, accepts an array length,
     * returns theoretical exchanges.
     * Calculated the worst value.
     */
    private Function<Integer, Integer> theoreticalExchangesFuncWorst;
    /** Actual comparisons. */
    private long actualComparisons;
    /** Actual exchanges. */
    private long actualExchanges;
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
        System.out.println("--- comparisons: "
                + (this.theoreticalComparisons != null ? this.theoreticalComparisons : "-"));
        System.out.println("--- exchanges:   "
                + (this.theoreticalExchanges != null ? this.theoreticalExchanges : "-"));
        System.out.println("* Actual information:");
        System.out.println("--- comparisons: " + this.actualComparisons);
        System.out.println("--- exchanges:   " + this.actualExchanges);
        System.out.println("* Calculating via theoretical formulas, applied to the array: ");
        System.out.println("--- comparisons (the best):  "
                + (this.theoreticalComparisonsFuncBest == null ? "-"
                : this.theoreticalComparisonsFuncBest.apply(arrayLength)));
        System.out.println("--- comparisons (average):   "
                + (this.theoreticalComparisonsFuncAvg == null ? "-"
                : this.theoreticalComparisonsFuncAvg.apply(arrayLength)));
        System.out.println("--- comparisons (the worst): "
                + (this.theoreticalComparisonsFuncWorst == null ? "-"
                : this.theoreticalComparisonsFuncWorst.apply(arrayLength)));
        System.out.println("--- exchanges (the best):    "
                + (this.theoreticalExchangesFuncBest == null ? "-"
                : this.theoreticalExchangesFuncBest.apply(arrayLength)));
        System.out.println("--- exchanges (average):     "
                + (this.theoreticalExchangesFuncAvg == null ? "-"
                : this.theoreticalExchangesFuncAvg.apply(arrayLength)));
        System.out.println("--- exchanges (the worst):   "
                + (this.theoreticalExchangesFuncWorst == null ? "-"
                : this.theoreticalExchangesFuncWorst.apply(arrayLength)));
        System.out.println("---------------------------------------------------------------------");
    }
    /**
     * @return the actualComparisons
     */
    public long getComparisons() {
        return actualComparisons;
    }
    /**
     * @return the actualExchanges
     */
    public long getExchanges() {
        return actualExchanges;
    }
    /**
     * @param theoreticalComparisons the theoreticalComparisons to set
     */
    public void setTheoreticalComparisons(String theoreticalComparisons) {
        this.theoreticalComparisons = theoreticalComparisons;
    }
    /**
     * @param theoreticalComparisonsFuncAvg the theoreticalComparisonsFuncAvg to set
     */
    public void setTheoreticalComparisonsFuncAvg(Function<Integer, Integer> theoreticalComparisonsFuncAvg) {
        this.theoreticalComparisonsFuncAvg = theoreticalComparisonsFuncAvg;
    }
    /**
     * @param theoreticalComparisonsFuncBest the theoreticalComparisonsFuncBest to set
     */
    public void setTheoreticalComparisonsFuncBest(Function<Integer, Integer> theoreticalComparisonsFuncBest) {
        this.theoreticalComparisonsFuncBest = theoreticalComparisonsFuncBest;
    }
    /**
     * @param theoreticalComparisonsFuncWorst the theoreticalComparisonsFuncWorst to set
     */
    public void setTheoreticalComparisonsFuncWorst(Function<Integer, Integer> theoreticalComparisonsFuncWorst) {
        this.theoreticalComparisonsFuncWorst = theoreticalComparisonsFuncWorst;
    }
    /**
     * @param theoreticalExchanges the theoreticalExchanges to set
     */
    public void setTheoreticalExchanges(String theoreticalExchanges) {
        this.theoreticalExchanges = theoreticalExchanges;
    }
    /**
     * @param theoreticalExchangesFuncAvg the theoreticalExchangesFuncAvg to set
     */
    public void setTheoreticalExchangesFuncAvg(Function<Integer, Integer> theoreticalExchangesFuncAvg) {
        this.theoreticalExchangesFuncAvg = theoreticalExchangesFuncAvg;
    }
    /**
     * @param theoreticalExchangesFuncBest the theoreticalExchangesFuncBest to set
     */
    public void setTheoreticalExchangesFuncBest(Function<Integer, Integer> theoreticalExchangesFuncBest) {
        this.theoreticalExchangesFuncBest = theoreticalExchangesFuncBest;
    }
    /**
     * @param theoreticalExchangesFuncWorst the theoreticalExchangesFuncWorst to set
     */
    public void setTheoreticalExchangesFuncWorst(Function<Integer, Integer> theoreticalExchangesFuncWorst) {
        this.theoreticalExchangesFuncWorst = theoreticalExchangesFuncWorst;
    }
}
