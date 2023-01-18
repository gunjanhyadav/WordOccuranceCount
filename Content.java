public class Content {
    private String paragraph;
    public Content (String p){
        paragraph = p;
    }
    public int getCount (String word){
        String trimmed = paragraph.trim();
        int count = 0, wl = word.length();
        int tl = trimmed.length();
        // "the"
        if (tl<wl){
            return 0;
        }
        // count the match if trimmed string equals to the target
        if (tl==wl && trimmed.substring(0,wl).equals(word)){
            return 1;
        }
        // now tl> wl  is implied
        // count the first word if it matches the search
        // "the cat"
        if (trimmed.substring(0,wl).equals(word)){
            count++;
        }
        // count the last word if mathces the search
        // eg "is the"
        if (trimmed.substring(tl-wl).equals(word)
                && trimmed.charAt(tl-wl-1)==' '){
            count++;
        }
        // finished  checking the first and last words.
        // now go through the middle substrings with a window
        // count word if it is surrounded by spaces
        for (int i = wl; i < tl-wl; i++){
            if (trimmed.substring(i,i+wl).equals(word)
                    && trimmed.charAt(i+wl)==' '
                    && trimmed.charAt(i-1) == ' ')
                count++;

        }
        return count;
    }
}