class Solution {

    public String removeDuplicateLetters(String s) {

        Set<Character> allComponent = toSortedSet(s); 

        for(char c:allComponent){
            String suffix = s.substring(s.indexOf(c));
            if(allComponent.equals(toSortedSet(suffix))){
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c),""));
            }
        }
        return "";
    }

    private Set<Character> toSortedSet(String s){
        Set<Character> set = new TreeSet<>();

        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
        }

        return set;
    }

}