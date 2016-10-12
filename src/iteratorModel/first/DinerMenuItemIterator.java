package iteratorModel.first;

import iteratorModel.first.inter.Iterator;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class DinerMenuItemIterator implements Iterator {
    MenuItem[]items;
    int position=0;
    public DinerMenuItemIterator(MenuItem[]items){
        this.items=items;
    }
    @Override
    public boolean hasNext() {
        if (position>=items.length||items[position]==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {

        MenuItem menuItem=items[position];
        position=position+1;
        return menuItem;
    }
}
