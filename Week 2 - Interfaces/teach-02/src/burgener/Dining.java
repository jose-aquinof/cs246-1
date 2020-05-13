package burgener;

public class Dining implements Expense {

    Destination _dest;
    int _nights;

    public Dining (Destination dest, int nights) {
        _dest = dest;
        _nights = nights;
    }

    public float getCost() {

        switch (_dest) {
            case Mexico:
                return 10.00f * _nights;
            case Europe:
                return 20.00f * _nights;
            case Japan:
                return 30.00f * _nights;
            default:
                return 0.0f;
        }
    }
}
