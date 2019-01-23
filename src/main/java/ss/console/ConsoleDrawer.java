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
package ss.console;

import java.util.Optional;

/**
 * Console drawer.
 * @author ss
 */
public class ConsoleDrawer {
    /**
     * Draw a line with a single character.
     * @param ch character.
     * @param length line length.
     * @return line.
     */
    public static String line(char ch, int length) {
        return String.valueOf(ch).repeat(length);
    }
    /**
     * Draw line with a text in a middle.
     * @param length line length.
     * @param text text.
     * @param filler filler character.
     * @param framing framing character.
     * @return line.
     */
    public static String lineTextInMiddle(int length, String text, Optional<Character> filler,
            Optional<Character> framing) {
        String result;
        if (text == null) {
            result = "NULL";
        } else if (length + (framing.isPresent() ? 2 : 0) <= text.length()) {
            result = text;
        } else {
            double fillerLength = (length - text.length()) / 2 - (framing.isPresent() ? 2 : 0);
            StringBuilder sb = new StringBuilder();
            String fillChar = filler.isPresent() ? String.valueOf(filler.get()) : " ";
            sb.append(fillChar.repeat(Math.toIntExact(Math.round(fillerLength))));
            sb.append(framing.isPresent() ? framing.get() : "");
            sb.append(text);
            sb.append(framing.isPresent() ? framing.get() : "");
            sb.append(fillChar.repeat(length - sb.length()));
            result = sb.toString();
        }
        return result;
    }
    /**
     * Print table.
     * @param table table data.
     */
    public static void printTable(String[][] table) {
        int rows = table.length;
        int columns = table[0].length;
        int[] widths = new int[columns];
        for (int row = 0; row < rows; row++) {
            String[] rowData = table[row];
            for (int column = 0; column < columns; column++) {
                String val = rowData[column];
                int width = widths[column];
                if (val != null && val.length() > width) {
                    widths[column] = val.length();
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            String[] rowData = table[row];
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for (int column = 0; column < columns; column++) {
                String val = rowData[column];
                int width = widths[column];
                String valTmp = val + "";
                while (valTmp.length() < width) {
                    valTmp = valTmp + " ";
                }
                sb.append(" ").append(valTmp).append(" |");
            }
            System.out.println(sb);
        }
    }
}
