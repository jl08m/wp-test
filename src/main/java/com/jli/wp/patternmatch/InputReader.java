package com.jli.wp.patternmatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jia on 4/17/2017.
 */
public class InputReader {

    public static InputDTO readPatterns(String inputFile) {
        try(BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {
            int numberOfPatterns = Integer.valueOf(br.readLine());
            List<String> patterns = readLines(numberOfPatterns, br);
            int numberOfPaths = Integer.valueOf(br.readLine());
            List<String> paths = readLines(numberOfPaths, br);
            return new InputDTO(patterns, paths);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Problem parsing expected integer");
        }

        return null;
    }

    private static List<String> readLines(int numberOfLines, BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>(numberOfLines);
        lines.add(reader.readLine());
        return lines;
    }

}
