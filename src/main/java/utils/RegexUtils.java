package utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class to perform regex operations like finding matches, replacing matches and retrieving matching values.
 */
public class RegexUtils {
    /**
     * Method to find and replace a match with the provided regex.
     * @param text text to suffer the transformation/replacement.
     * @param regex regex for finding matches in the text.
     * @param newValue New value for the replacement.
     * @return String representing the original text with the replaced value.
     */
    public static String findAndReplace(String text, String regex, String newValue) {
        StringBuilder toReturn = new StringBuilder().append(text);

        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        matcher.find();

        toReturn.replace(matcher.start(0), matcher.end(0), newValue);

        return toReturn.toString();
    }

    /**
     * Method to find and return the requested matching group with the provided regex.
     * @param text text to find the match in.
     * @param regex regex for finding matches in the text.
     * @param groupToReturn index for the matching group to return.
     * @return Optional object containing the required match or null if no match exists.
     */
    public static Optional<String> findAndReturn(String text, String regex, int groupToReturn) {

        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher attributeMatcher = pattern.matcher(text);
        attributeMatcher.find();

        return Optional.ofNullable(attributeMatcher.group(groupToReturn));
    }

    /**
     * Method to verify if a given regex has any matches in a String.
     * @param text text to check if sequence exists.
     * @param regex regex to be found on the provided text.
     * @return true if the regex finds matches, false otherwise.
     */
    public static boolean sequenceExists(String text, String regex) {

        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher attributeMatcher = pattern.matcher(text);

        return attributeMatcher.find();
    }
}
