package com.jli.wp.patternmatch;

import java.util.List;

/**
 * Created by Jia on 4/17/2017.
 */
public class PatternMatcher {


    public static String NO_MATCH = "NO MATCH";
    private static MyPattern NO_MATCH_PATTERN = new MyPattern(NO_MATCH);

    public static String match(List<MyPattern> patterns, MyPath path) {
        MyPattern bestMatch = patterns.stream()
                .filter(pattern -> pattern.getTokenSize() == path.getTokenSize()) //remove patterns not matching path size
                .filter(pattern -> isMatch(pattern, path))  //remove patterns not matching path
                .min((p1, p2) -> {
                    int compareWildcards = Integer.compare(p1.getNumberOfWildcards(),
                            p2.getNumberOfWildcards());
                    if(compareWildcards != 0) return compareWildcards; //not same # of wildcards
                    return compareWildcardPosition(p1, p2); //compare each wildcard position
                }).orElse(null);
            return bestMatch != null ? bestMatch.getPattern() : NO_MATCH;
    }

    /*
    Return true if each token in path matches a pattern
     */
    private static boolean isMatch(MyPattern pattern, MyPath path) {
        for(int i=0; i<pattern.getTokenSize(); i++) {
            if(!isTokenMatch(pattern.getTokens().get(i), path.getTokens().get(i))) return false;
        }
        return true;
    }

    /*
    Return true if path token matches pattern token or pattern wildcard
     */
    private static boolean isTokenMatch(String patternToken, String pathToken) {
        return patternToken.equals(pathToken) || MyPattern.WILDCARD.equals(patternToken);
    }

    private static int compareWildcardPosition(MyPattern p1, MyPattern p2) {
        for(int i=0; i<p1.getTokenSize(); i++) {
            String p1Token = p1.getTokens().get(i);
            String p2Token = p2.getTokens().get(i);
            if (MyPattern.WILDCARD.equals(p1Token) && !MyPattern.WILDCARD.equals(p2Token))
                return 1;
            else if (!MyPattern.WILDCARD.equals(p1Token) && MyPattern.WILDCARD.equals(p2Token))
                return -1;
        }
        //No requirements on if 2 patterns match exactly, assume this does not happen.
        throw new IllegalStateException("Unexpected clash in comparing patterns: " + p1 + " " + p2);
    }
}
