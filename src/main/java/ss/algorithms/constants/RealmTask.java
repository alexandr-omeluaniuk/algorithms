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

import ss.algorithms.task.SortArrayTask;
import ss.algorithms.core.Task;
import ss.algorithms.task.SortCompare;

/**
 * Realm task.
 * @author ss
 */
public enum RealmTask {
    /** Sort using a single algorithm. */
    SORT_ARRAY(
            new RealmTaskArg[] {RealmTaskArg.ALGORITHM, RealmTaskArg.ARRAY_LENGTH,
                RealmTaskArg.ENABLE_TRACING, RealmTaskArg.GRAPHIC_MODE},
            new boolean[] {true, true, false, false},
            "Sort an array using a certain algorithm",
            SortArrayTask.class
    ),
    /** Compare sort algorithms. */
    COMPARE_SORT_ALGORITHMS(new RealmTaskArg[] {RealmTaskArg.ARRAY_LENGTH},
            new boolean[] {true},
            "Compare sort algorithms",
            SortCompare.class
    );
    /** Task arguments. */
    private final RealmTaskArg[] args;
    /** Required arguments mask. */
    private final boolean[] requiredMask;
    /** Description. */
    private final String description;
    /** Task implementation. */
    private final Class<? extends Task> implementation;
    /**
     * Constructor.
     * @param args task arguments.
     * @param requiredMask required arguments mask.
     */
    private RealmTask(RealmTaskArg[] args, boolean[] requiredMask, String description,
            Class<? extends Task> implementation) {
        this.args = args;
        this.requiredMask = requiredMask;
        this.description = description;
        this.implementation = implementation;
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
    /**
     * @return the implementation
     */
    public Class<? extends Task> getImplementation() {
        return implementation;
    }
}
