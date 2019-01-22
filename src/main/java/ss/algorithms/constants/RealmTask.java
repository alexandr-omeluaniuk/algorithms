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
 * Realm task.
 * @author ss
 */
public enum RealmTask {
    /** Sorting. */
    SORT_ARRAY(
            new RealmTaskArg[] {RealmTaskArg.ALGORITHM, RealmTaskArg.ARRAY_LENGTH},
            new boolean[] {true, true},
            "Sort an array using a certain algorithm"
    );
    /** Task arguments. */
    private final RealmTaskArg[] args;
    /** Required arguments mask. */
    private final boolean[] requiredMask;
    /** Description. */
    private final String description;
    /**
     * Constructor.
     * @param args task arguments.
     * @param requiredMask required arguments mask.
     */
    private RealmTask(RealmTaskArg[] args, boolean[] requiredMask, String description) {
        this.args = args;
        this.requiredMask = requiredMask;
        this.description = description;
    }
    /**
     * @return the args
     */
    public RealmTaskArg[] getArgs() {
        return args;
    }
    /**
     * @return the requiredMask
     */
    public boolean[] getRequiredMask() {
        return requiredMask;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
