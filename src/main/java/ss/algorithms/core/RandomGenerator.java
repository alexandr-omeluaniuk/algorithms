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

import java.util.concurrent.ThreadLocalRandom;

/**
 * Random data generator.
 * @author ss
 */
public class RandomGenerator {
    /**
     * Get a random array of numbers.
     * @param length array length.
     * @return random array of numbers.
     */
    public static Integer[] randomArrayOfNumbers(int length) {
        Integer[] data = new Integer[length];
        for (int i = 0; i < length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(0, 99);
        }
        return data;
    }
}
