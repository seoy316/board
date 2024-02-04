import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String date;

}
