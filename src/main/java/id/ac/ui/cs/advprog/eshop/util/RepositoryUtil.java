package id.ac.ui.cs.advprog.eshop.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepositoryUtil {
    public static <T> List<T> iteratorToList(Iterator<T> iterator) {
        List<T> list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
        return list;
    }
}