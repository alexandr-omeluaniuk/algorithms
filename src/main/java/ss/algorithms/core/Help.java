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

import java.util.Optional;
import ss.algorithms.constants.Realm;
import ss.algorithms.constants.RealmTask;
import ss.algorithms.constants.RealmTaskArg;
import ss.console.ConsoleTextDrawer;

/**
 * Program help.
 * @author ss
 */
public class Help {
    /**
     * Print help.
     */
    public static void printHelp() {
        final int lineLength = 100;
        System.out.println(ConsoleTextDrawer.line('#', lineLength));
        System.out.println(ConsoleTextDrawer.lineTextInMiddle(lineLength, "ALGORITHMS",
                Optional.of('#'), Optional.of(' ')));
        System.out.println(ConsoleTextDrawer.line('#', lineLength));
        System.out.println("");
        for (Realm realm : Realm.values()) {
            System.out.println(ConsoleTextDrawer.line('-', lineLength));
            System.out.println("> " + realm.getDescription());
            System.out.println("\tList of tasks:");
            for (RealmTask task : realm.getTasks()) {
                System.out.println("\t\t* " + task.name().toLowerCase() + " ("
                        + task.getDescription() + ") with arguments:");
                int index = 0;
                for (RealmTaskArg arg : task.getArgs()) {
                    System.out.println("\t\t-" + arg.name().toLowerCase()
                            + " [" + arg.getDescription() + "], is required ["
                            + task.getRequiredMask()[index] + "], with type ["
                            + arg.getType().getSimpleName().toLowerCase() + "]");
                    index++;
                }
            }
        }
    }
}
