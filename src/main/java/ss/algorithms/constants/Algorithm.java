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
package ss.algorithms.constants;

import ss.algorithms.realm.sorting.impl.SortInsertion;
import ss.algorithms.realm.sorting.impl.SortSelection;
import ss.algorithms.realm.sorting.SortAlgorithm;
import ss.algorithms.realm.sorting.impl.SortMerge;
import ss.algorithms.realm.sorting.impl.SortShell;

/**
 * Algorithm.
 * @author ss
 */
public enum Algorithm {
    /** Sort using selection. */
    SORT_SELECTION(Realm.SORTING, "Sort using selection algorithm", SortSelection.class),
    /** Sort using insertion. */
    SORT_INSERTION(Realm.SORTING, "Sort using insertion algorithm", SortInsertion.class),
    /** Sort using 'Shell' algorithm. */
    SORT_SHELL(Realm.SORTING, "Sort using 'Shell' algorithm", SortShell.class),
    /** Sort using 'Shell' algorithm. */
    SORT_MERGING(Realm.SORTING, "Sort with merging", SortMerge.class);
    /** Realm. */
    private final Realm realm;
    /** Description. */
    private final String description;
    /** Algorithm implementation. **/
    private final Class<? extends SortAlgorithm> implementation;
    /**
     * Constructor.
     * @param realm realm.
     * @param description description.
     */
    private Algorithm(Realm realm, String description,
            Class<? extends SortAlgorithm> implementation) {
        this.realm = realm;
        this.description = description;
        this.implementation = implementation;
    }
    /**
     * @return the realm
     */
    public Realm getRealm() {
        return realm;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the implementation
     */
    public Class<? extends SortAlgorithm> getImplementation() {
        return implementation;
    }
}
