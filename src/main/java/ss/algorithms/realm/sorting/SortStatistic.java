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

import java.util.List;

/**
 * Sort statistic.
 * @author ss
 */
public class SortStatistic {
    /** Theoretical comparisons. */
    private String theoreticalComparisons;
    /** Theoretical exchanges.*/
    private String theoreticalExchanges;
    /** Actual comparisons. */
    private long actualComparisons;
    /** Actual exchanges. */
    private long actualExchanges;
    /** Sort history. */
    private List<Comparable[]> history;
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
    /**
     * Print statistic.
     */
    public void print() {
        System.out.println("------------------------[ PRINT STATISTIC ]--------------------------");
        if (this.theoreticalComparisons != null || this.theoreticalExchanges != null) {
            System.out.println("* Theoretical information:");
            System.out.println("--- comparisons: "
                    + (this.theoreticalComparisons != null ? this.theoreticalComparisons : "-"));
            System.out.println("--- exchanges:   "
                    + (this.theoreticalExchanges != null ? this.theoreticalExchanges : "-"));
        }
        System.out.println("* Sort operation information:");
        System.out.println("--- comparisons: " + this.actualComparisons);
        System.out.println("--- exchanges:   " + this.actualExchanges);
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
     * @param theoreticalExchanges the theoreticalExchanges to set
     */
    public void setTheoreticalExchanges(String theoreticalExchanges) {
        this.theoreticalExchanges = theoreticalExchanges;
    }
}
