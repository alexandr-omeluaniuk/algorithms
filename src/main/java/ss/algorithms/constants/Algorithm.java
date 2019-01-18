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

/**
 * Algorithm.
 * @author ss
 */
public enum Algorithm {
    /** Sort using selection. */
    SORT_SELECTION(Realm.SORTING, "Sort using selection algorithm");
    /** Realm. */
    private final Realm realm;
    /** Description. */
    private final String description;
    /**
     * Constructor.
     * @param realm realm.
     * @param description description.
     */
    private Algorithm(Realm realm, String description) {
        this.realm = realm;
        this.description = description;
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
}
