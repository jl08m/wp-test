package com.jli.wp.patternmatch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jia on 4/23/2017.
 */
public class InputDTO {

    private List<MyPattern> patterns;
    private List<MyPath> paths;

    public InputDTO(List<String> patterns, List<String> paths) {
        this.patterns = patterns.stream().map(MyPattern::new).collect(Collectors.toList());
        this.paths = paths.stream().map(MyPath::new).collect(Collectors.toList());
    }

    public List<MyPattern> getPatterns() {
        return patterns;
    }

    public List<MyPath> getPaths() {
        return paths;
    }
}
