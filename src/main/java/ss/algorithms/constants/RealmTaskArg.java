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
 * Realm task argument.
 * @author ss
 */
public enum RealmTaskArg {
    /** Algorithm. */
    ALGORITHM(Algorithm.class, "Algorithm name"),
    /** Array length for sorting. */
    ARRAY_LENGTH(Integer.class, "Array length for sorting"),
    /** Enable tracing. */
    ENABLE_TRACING(Boolean.class, "Enable tracing"),
    /** Enable graphic mode for tracing. */
    GRAPHIC_MODE(Boolean.class, "Enable graphic mode for tracing");
    /** Argument type. */
    private final Class type;
    /** Description. */
    private final String description;
    /**
     * Constructor.
     * @param type argument type.
     * @param description argument description.
     */
    private RealmTaskArg(Class type, String description) {
        this.type = type;
        this.description = description;
    }
    /**
     * @return the type
     */
    public Class getType() {
        return type;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
