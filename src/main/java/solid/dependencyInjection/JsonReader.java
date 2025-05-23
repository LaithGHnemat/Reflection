package solid.dependencyInjection;

import java.util.Collections;
import java.util.List;

public class JsonReader implements Reader{
    @Override
    public List<String> readFile() {
        // here write whatever the file that you wannt
      return Collections.singletonList(new String("I convert Json to string"));
    }
}
