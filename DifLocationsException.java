public class DifLocationsException extends Exception{
    public DifLocationsException(){
        super("Локации отличаются. Предмет и человек должны находиться в одной локации.");
    }
}
