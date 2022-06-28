public class Osajonot {
    int laske(String s, String substr) {
    int count = 0;
    for (int pos = s.indexOf(substr); pos >= 0; pos = s.indexOf(substr, pos + 1)) {
        count++;
    }
        return count;
    }
}
