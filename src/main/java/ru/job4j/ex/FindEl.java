package ru.job4j.ex;

public class FindEl extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1)  {
            throw new ElementNotFoundException("Такой элемент отсутствует");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"1", "2", "3"};
        try {
            indexOf(value, "5");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
