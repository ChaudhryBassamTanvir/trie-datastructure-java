class Trie1 {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;// null se initialize karna zaroori hai warna error aa sakta h
            }
            eow = false;
        }
    }

    static Node root = new Node();// mean trie ke root already exist karte hai

    public static void insert(String word) {// ek tym pr ek he word jye ga pehle the phir a phir there etc

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                // new node
                curr.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].eow = true;

            }
            curr = curr.children[idx];
        }
    }

    public static boolean Search(String key) {

        Node curr = root;
        for (int i = 0; i < key.length(); i++) {

            int idx = key.charAt(i) - 'a';
            // Node node = root.children[idx]; phir neechay har jga node aye ga jahan jahan
            // yay hai or hum har baar node ko compare kar rhy hote hain
            if (curr.children[idx] == null) {// agr yay letter null hai tu iss ka mtlb hai jo letter chahiyay wo exist
                                             // he nai karta
                return false;
            }
            if (i == key.length() - 1 && curr.children[idx].eow == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;

    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(Search("their"));// true
        System.out.println(Search("thor"));// false
        System.out.println(Search("an"));// false

    }
}