package solid.dependencyInversion;

import java.util.Collections;
import java.util.List;

public class TextReader implements Reader{
    @Override
    public List<String> readFile() {
        // write the code to read and convert to text
        return Collections.singletonList(new String("I convert Text to string"));    }
}
