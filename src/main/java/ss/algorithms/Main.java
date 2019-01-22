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
package ss.algorithms;

import java.util.HashMap;
import java.util.Map;
import ss.algorithms.constants.Algorithm;
import ss.algorithms.constants.RealmTask;
import ss.algorithms.constants.RealmTaskArg;
import ss.algorithms.core.Task;

/**
 * Entry point.
 * @author ss
 */
public class Main {
    /** Global argument. */
    private static final String GLOBAL_ARG_TASK = "task";
    /**
     * @param args the command line arguments
     * @throws Exception unexpected error.
     */
    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            //Help.printHelp();
            args = new String[] {
                "task=sort_array", "-algorithm=sort_shell", "-array_length=32"
            };
            runTask(args);
        } else {
            runTask(args);
        }
    }
    /**
     * Run task.
     * @param args the command line arguments.
     * @throws Exception error.
     */
    private static void runTask(String[] args) throws Exception {
        for (String arg : args) {
            if (arg.startsWith(GLOBAL_ARG_TASK) && arg.contains("=")) {
                String checkedString = arg.substring(arg.indexOf("=") + 1).trim().toUpperCase();
                for (RealmTask task : RealmTask.values()) {
                    if (task.name().equals(checkedString)) {
                        Task taskImpl = task.getImplementation()
                                .getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        Map<RealmTaskArg, Object> params = new HashMap<>();
                        for (String arg1 : args) {
                            if (arg1.contains("=") && arg1.startsWith("-")) {
                                String key = arg1.substring(1, arg1.indexOf("=")).trim()
                                        .toUpperCase();
                                String value = arg1.substring(arg1.indexOf("=") + 1).trim();
                                try {
                                    RealmTaskArg rta = RealmTaskArg.valueOf(key);
                                    Object valCast;
                                    if (Integer.class.equals(rta.getType())) {
                                        valCast = Integer.valueOf(value);
                                    } else if (Algorithm.class.equals(rta.getType())) {
                                        valCast = Algorithm.valueOf(value.toUpperCase());
                                    } else {
                                        valCast = value;
                                    }
                                    params.put(rta, valCast);
                                } catch (Exception e) {
                                    System.err.println("Unknown argument: " + arg1);
                                }
                            }
                        }
                        int index = 0;
                        for (RealmTaskArg rta : RealmTaskArg.values()) {
                            if (task.getRequiredMask()[index] && !params.containsKey(rta)) {
                                throw new RuntimeException(rta.name().toLowerCase()
                                        + " argument is required for this task!");
                            }
                            index++;
                        }
                        taskImpl.run(params);
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("task name is required, please define command like:"
                + " task=<task name>");
    }
}
