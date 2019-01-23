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
package ss.algorithms.task;

import java.util.Map;
import ss.algorithms.constants.RealmTaskArg;
import ss.algorithms.core.Task;

/**
 * Compare sort algorithms.
 * @author ss
 */
public class SortCompare implements Task {
    @Override
    public void run(Map<RealmTaskArg, Object> args) throws Exception {
        Integer arrayLength = (Integer) args.get(RealmTaskArg.ARRAY_LENGTH);
    }
}
