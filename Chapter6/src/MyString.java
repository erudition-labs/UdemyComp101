public class MyString {
    private final char[] string;
    public int length;

    public MyString(char[] string) {
        this.string = string;
        length = string.length;
    }

    public char charAt(int index) {
        return string[index];
    }

    public MyString substring(int begin, int end) {
        char[] result = new char[end - begin];

        int counter = 0;
        for(int i=begin; i<end; i++) {
            result[counter] = string[i];
            counter++;
        }

        return new MyString(result);
    }

    public MyString toLowerCase() {
        char[] result = new char[length];
        for(int i=0; i<length; i++) {
            char c = string[i];
            if((c >= 'A') && (c <= 'Z')) {
                c += 32;
            }
            result[i] = c;
        }
        return new MyString(result);
    }

    public boolean equals(MyString s) {
        if(length != s.length) return false;

        for(int i=0; i<length; i++) {
            if(string[i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return new String(string);
    }

    public static void main(String[] args) {
        MyString s1 = new MyString(new char[] {'a', 'B', 'C', 'd'});
        MyString s2 = new MyString(new char[] {'a', 'B', 'C', 'd', 'e', 'f'});
        MyString s4 = new MyString(new char[] {'a', 'b', 'c', 'd'});

        System.out.println(s1.charAt(2));
        System.out.println(s1.toLowerCase().toString());
        System.out.println(s1.equals(s2));
        System.out.println(s1.toLowerCase().equals(s4));
        System.out.println(s2.substring(2, 4).toString());

    }
}
