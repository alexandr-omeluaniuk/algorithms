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
package ss.algorithms.core;

import java.util.Map;
import ss.algorithms.constants.RealmTaskArg;

/**
 * Algorithm implementation.
 * @author ss
 */
public interface AlgorithmImplementation {
    /**
     * Run algorithm using embedded test data.
     * @param args task arguments.
     */
    void run(Map<RealmTaskArg, Object> args);
}
