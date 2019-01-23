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
 * Algorithmic realm.
 * @author ss
 */
public enum Realm {
    /** Sorting. */
    SORTING(new RealmTask[] {RealmTask.SORT_ARRAY, RealmTask.COMPARE_SORT_ALGORITHMS},
            "Sorting algorithms");
    /** Tasks. */
    private final RealmTask[] tasks;
    /** Description. */
    private final String description;
    /**
     * Constructor.
     * @param tasks realm tasks.
     * @param description realm description.
     */
    private Realm(RealmTask[] tasks, String description) {
        this.tasks = tasks;
        this.description = description;
    }
    /**
     * @return the tasks
     */
    public RealmTask[] getTasks() {
        return tasks;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
