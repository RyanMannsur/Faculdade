
package pratica13a;

import java.util.ArrayList;
import java.util.List;


public class CareTaker {
     protected List<Memento> mementoList;
    
    public CareTaker(){
        mementoList = new ArrayList<>();
    }
    
    public void add(Memento memento){
        mementoList.add(memento);
    }
    
    public Memento get(int memento){
        return mementoList.get(memento);
    }
}
