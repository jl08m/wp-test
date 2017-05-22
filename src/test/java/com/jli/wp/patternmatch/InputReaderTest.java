package com.jli.wp.patternmatch;

import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jia on 4/17/2017.
 */
public class InputReaderTest {

    @Test
    public void testReadPatterns_testInput() throws URISyntaxException {
        //More than necessary complex retrieval for Windows paths.
        String input = Paths.get(this.getClass().getResource("/testInput.txt").toURI())
                .toAbsolutePath().toString();
        InputDTO readResult = InputReader.readPatterns(input);

        MyPattern expectedPattern = new MyPattern("a,b");
        assertEquals(1, readResult.getPatterns().size());
        assertEquals(expectedPattern, readResult.getPatterns().get(0));

        MyPath expectedPath = new MyPath("a/b");
        assertEquals(1, readResult.getPaths().size());
        assertEquals(expectedPath, readResult.getPaths().get(0));
    }

}
