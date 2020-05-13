package burgener;

public class Lodging implements Expense {

    Destination _dest;
    int _nights;

    public Lodging (Destination dest, int nights) {
        _dest = dest;
        _nights = nights;
    }

    public float getCost() {

        switch (_dest) {
            case Mexico:
                return 100.00f * _nights;
            case Europe:
                return (200.00f * _nights) + ((200.00f * _nights) * 0.10f);
            case Japan:
                return (300.00f * _nights) + ((300.00f * _nights) * 0.30f);
            default:
                return 0.0f;
        }
    }
}
