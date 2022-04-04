public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int length = word.length();
        Deque<Character> d = new ArrayDeque<>();
        for(int i=0; i<length; i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        if(length==1 || length==0 || word==null){
            return true;
        }
        for(int i=0; i<length/2; i++){
            if(word.charAt(i) != word.charAt(length - i -1)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        int length = word.length();
        if(length==1 || length==0 || word==null){
            return true;
        }
        for(int i=0; i<length/2; i++){
            if(cc.equalChars(word.charAt(i), word.charAt(length - i -1)) != true){
                return false;
            }
        }
        return true;
    }
}
