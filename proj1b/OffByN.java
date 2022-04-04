public class OffByN implements CharacterComparator{
    public int CompareParameter;
    public OffByN(int n){
        CompareParameter = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x-y) == this.CompareParameter){
            return true;
        }
        else{
            return false;
        }
    }
}
