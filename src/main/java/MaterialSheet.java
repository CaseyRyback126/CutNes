import java.util.ArrayList;
import java.util.List;

public class MaterialSheet {

    private int width;
    private int height;
    private List<Detail> details;

    public MaterialSheet(int width, int height) {
        this.width = width;
        this.height = height;
        this.details = new ArrayList<>();
    }
}
