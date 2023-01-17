
package principalRyan;

import java.util.StringTokenizer;

public class Interpretadora {
    StringTokenizer tokens;

    public Interpretadora(String frase) {
        this.tokens = new StringTokenizer(frase," ");
    }

    public StringTokenizer getTokens() {
        return tokens;
    }

    public void setSeparador(StringTokenizer tokens) {
        this.tokens = tokens;
    }

    

}
