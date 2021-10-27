package oneDay.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//r
//Ä£Äâ
public class l_211 {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("at");
		wordDictionary.addWord("and");
		wordDictionary.addWord("an");
		wordDictionary.addWord("add");
		wordDictionary.addWord("bat");
		String search = ".at";
		System.out.println(wordDictionary.search(search));
	}

}

class WordDictionary {
    Set<String> dictionary;
    Map<String, Boolean> res;

    public WordDictionary() {
        dictionary = new HashSet<>();
        res = new HashMap<>();
    }
    
    public void addWord(String word) {
    	dictionary.add(word);
    	for (String key : res.keySet()) {
    		int i = 0; // key
    		int j = 0; // word
    		while (i < key.length() && j < word.length()) {
    			if (key.charAt(i) == '.') {
    				i += 1;
    				j += 1;
    			}
    			else {
    				if (key.charAt(i) != word.charAt(j)) {
    					break;
    				}
    				i += 1;
    				j += 1;
    			}
    		}
    		if (i == key.length() && j == word.length()) {
    			res.put(key, true);
    		}
    		else {
    			res.put(key, false);
    		}
    	}
    }
    
    public boolean search(String word) {
    	if (res.containsKey(word)) {
    		return res.get(word);
    	}
    	for (String w: dictionary) {
    		int i = 0; //word
    		int j = 0; //w
    		while (i < word.length() && j < w.length()) {
    			if (word.charAt(i) == '.') {
    				i += 1;
    				j += 1;
    			}
    			else {
    				if (word.charAt(i) != w.charAt(j)) {
    					break;
    				}
    				i += 1;
    				j += 1;
    			}
    		}
    		if (i == word.length() && j == w.length()) {
    			res.put(word, true);
    			return true;
    		}
    	}
    	res.put(word, false);
    	return false;
    }
}