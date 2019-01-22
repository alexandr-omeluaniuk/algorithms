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
import ss.algorithms.constants.Algorithm;
import ss.algorithms.constants.RealmTaskArg;
import ss.algorithms.core.RandomGenerator;
import ss.algorithms.core.Task;
import ss.algorithms.realm.sorting.SortAlgorithm;
import ss.algorithms.realm.sorting.SortStatistic;

/**
 * Sort array task.
 * @author ss
 */
public class SortArrayTask implements Task {
    @Override
    public void run(Map<RealmTaskArg, Object> args) throws Exception {
        Integer arrayLength = (Integer) args.get(RealmTaskArg.ARRAY_LENGTH);
        Algorithm algorithm = (Algorithm) args.get(RealmTaskArg.ALGORITHM);
        Boolean enableTracing = (Boolean) args.get(RealmTaskArg.ENABLE_TRACING);
        Boolean isGraphicMode = (Boolean) args.get(RealmTaskArg.GRAPHIC_MODE);
        enableTracing = enableTracing == null ? Boolean.FALSE : enableTracing;
        isGraphicMode = isGraphicMode == null ? Boolean.FALSE : isGraphicMode;
        Comparable[] a = RandomGenerator.randomArrayOfNumbers(arrayLength);
        System.out.println("Source array:");
        outputArray(a);
        SortAlgorithm sortAlgorithm = (SortAlgorithm) algorithm.getImplementation()
                .getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        SortStatistic statistic = sortAlgorithm.sort(a, enableTracing, isGraphicMode);
        System.out.println("Sorted array:");
        outputArray(a);
        System.out.println("");
        statistic.print(a.length);
    }
    /**
     * Output an array of comparable items.
     * @param a array of comparable items.
     */
    private void outputArray(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}
