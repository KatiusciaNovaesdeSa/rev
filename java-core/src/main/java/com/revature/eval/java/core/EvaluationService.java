package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 * 
	 * public String acronym(String phrase) {
		System.out.println("HERe is me debug");
		return null;
	}
	 */
	public String acronym(String phrase) {
		String acron = "";

        String[] letters = phrase.split("[-\\s]");

        for(String word : letters) {
          acron += word.substring(0, 1).toUpperCase();

        }

		//System.out.println("HERe is me debug");
		//return null;

        return acron;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			 if (sideOne == sideTwo && sideTwo == sideThree ) {
				 return true;
			 }
			return false;
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideTwo == sideThree || sideThree == sideOne ) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideThree != sideOne) {
				return true;
			}
			return false;
		}

	}



	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		string = string.toUpperCase();
	
		
		for(int x=0; x < string.length(); x++) {
			char letter = string.charAt(x);
			switch(letter) {
				case 'A':
				case 'E':
				case 'i':
				case 'I':
				case 'O':
				case 'U':
				case 'L':
				case 'N':
				case 'R':
				case 'S':
				case 'T':
					score += 1;
					break;
				case 'D':
				case 'G':
					score += 2;
					break;
				case 'B':
				case 'C':
				case 'M':
				case 'P':
					score += 3;
					break;
				case 'f':
				case 'F':
				case 'h':
				case 'H':
				case 'v':
				case 'V':
				case 'w':
				case 'W':
				case 'y':
				case 'Y':
					score += 4;
					break;
				case 'K':
					score += 5;
					break;
				case 'J':
				case 'X':
					score += 8;
					break;
				case 'Q':
				case 'Z':
					score += 10;
					break;
			}
		}
		
		return score;
	}
	

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		 String phone = string.replaceAll("\\D",""); //remove all no digit numbers
				 			 
			if (phone.length() != 10) {

				throw new IllegalArgumentException();

			} else {             
				return phone;

	  }
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string)  {
		string = string.replaceAll("[^a-zA-Z]", " ");
		Map<String, Integer> map = new HashMap<String, Integer> ();
		String[] strings = string.split(" ");

		for (String i:strings) {
			if (i.isEmpty()) {
		      continue;
	      	}
		    
		    if (!map.containsKey(i)) {  // first time we've seen this string
		      map.put(i, 1);
		    }
		    else {
		      int count = map.get(i);
		      map.put(i, count + 1);
		    }
		  }
		  return map;
	}



	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			List<Integer> items = new ArrayList();
			int value;
			if (sortedList.get(0) instanceof String) {
				for (T s : sortedList) {
					items.add(Integer.valueOf((String) s)); //add 
				}
				value = Integer.valueOf((String) t); //converts different types of values into string
			} else {
				for (T s : sortedList) {
					items.add((int) s);
				}
				value = (int) t;
			}
			int start = 0;  //starting point
			int end = sortedList.size();  //ending point

			while (start < end) {
				int middle = (end + start) / 2;  //middle point
				if (items.get(middle) == value) {
					return middle;
				} else if (items.get(middle) < value) {
					start = middle + 1;
				} else {
					end = middle;
				}
			}
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {

		String[] words = string.split(" ");
		
		char[] vowelLetters = { 'a', 'e', 'i', 'o', 'u' };

		StringBuilder pig = new StringBuilder(); //to create objects (like String) that can be modified

		for (String word : words) {
			boolean letters = false;
			char firstIndex = word.charAt(0);
     		char secondIndex = word.charAt(1);
		

    		if (Character.toLowerCase(firstIndex) == 't' && Character.toLowerCase(secondIndex) == 'h') {
				pig.append(word.substring(2) + "thay ");
				continue;
			}	
			if (Character.toLowerCase(firstIndex) == 's' && Character.toLowerCase(secondIndex) == 'c') {
				pig.append(word.substring(3) + "schay ");
				continue;
     		}
			if (Character.toLowerCase(firstIndex) == 'q' && Character.toLowerCase(secondIndex) == 'u') {
				pig.append(word.substring(2) + "quay ");
				continue;
		   }
			
			for (int i = 0; i < vowelLetters.length; i++) {
				if (Character.toLowerCase(firstIndex) == vowelLetters[i]) {
     				pig.append(word + "ay ");
					letters = true;
					break;
				}
			}
			if (letters) {
				continue;
			}

			pig.append(word.substring(1) + firstIndex + "ay ");

		}

		return pig.toString().trim(); //removes whitespace from both ends of a string
	   
	 }

	



	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		ArrayList<Integer> numbers = new ArrayList<>();
		int temp = input;
		boolean check = true;
		while (temp > 0) {
			int n = temp % 10;
			numbers.add(n);
			temp /= 10;
		}
		int result = 0;
		for (int n : numbers) {
			result += Math.pow(n, numbers.size());
			
		}
		if(result == input) {
			return check;
		}
		return false;
	}
 
		

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> prime = new ArrayList();
		long num = l;
		for (long i = 2; i <= num; i++) {  
			while (num % i == 0) {
				prime.add(i);
				num = num/i;
			}
		}
		return prime;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String cipher = "";

			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (Character.isLetter(c)) {
					if (Character.isLowerCase(c)) {
						char x = (char) (c + this.key);
						if (x > 'z') {
							cipher += (char) (c - (26 - this.key));
						} else {
							cipher += x;
						}
					} else if (Character.isUpperCase(c)) {
						char x = (char) (c + this.key);
						if (x > 'Z') {
							cipher += (char) (c - (26 - this.key));
						} else {
							cipher += x;
						}
					}
				} else {
					cipher += c;
				}
			}

			return cipher;
		}
	}


	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) { 
		
	       int count=0;
	       int num = 0;
	       
	       if (i < 1) {
				throw new IllegalArgumentException();
			}
	     
	       int nth;
		   while (count < i){
		          num=num+1;
		          for (nth = 2; nth <= num; nth++){ //loop from 2 to num
		            if (num % nth == 0) {
		              break;
		            }
		          }
		          if ( nth == num){//if it is a prime number
		            count = count+1;
		          }
		        }
	       		return num;
		      }
		    
	
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 *
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * @param string
		 * @return
		 */
		public static String encode(String string) {

          return convert(string).replaceAll(".{5}(?=.)", "$0 ");
		}

	    private static String convert(String input)
	    {
	        return input.toLowerCase().chars().mapToObj(c -> (char)c).
	                filter(Character::isLetterOrDigit).
	                map(c -> Character.isLetter(c) ? (char)(122 - (c - 97)) : c).
	                map(String::valueOf).
	                collect(Collectors.joining());  //join various elements into a single string object
	    }
	
		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
	    public static String decode(String string) {
	    	return convert(string);
			
		}
    }
	

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	
	//ONLY 2 TESTS
	public boolean isValidIsbn(String string) {
		string = string.replace("-", "");
		if (string.length() != 10)
			return false;
		if (string.contains("X") && string.charAt(string.length() - 1) != 'X')
			return false;
		
		int sum = 0;
		int mult = 10;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'X') 
				sum += mult-- * 10;
			else if (isNum(string.charAt(i)))
				sum += mult-- * (string.charAt(i) - '0');
		}
		return sum % 11 == 0;
    }
	
	private boolean isNum(char c) {
		for (int i = 0; i < 10; i++)
			if (c - '0' == i)
				return true;
		return false;
	}
	
	
	
	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	
	public boolean isPangram(String string) {
        for(char x = 'a'; x <= 'z'; x++) {
            if(string.toLowerCase().indexOf(x) < 0) {
                return false;
            }
        }
        return true;
	}

	/**
	 * 17. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	
	public int getSumOfMultiples(int i, int[] set) {  
	        int sum = 0;
	        for(int index = 1; index < i; index++){
	            for (int x : set) {
	                if (index % x == 0) {
	                    sum += index;
	                    break;
	                }
	            }
	        }
	        return sum;
	    }
	

	/**
	 * 18. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replaceAll(" ", "");
		int digits = string.length();
		 
	    int sum = 0;
	    boolean isSecond = false;
	    for (int i = digits - 1; i >= 0; i--)
	    {
	 
	        int d = string.charAt(i) - '0';
	 
	        if (isSecond == true)
	            d = d * 2;
	 
	        
	        sum += d / 10;    // add two digits to handle
	        sum += d % 10;
	 
	        isSecond = !isSecond;
	    }
	    if(sum % 10 == 0){
			return true;
		}
		
		return false;
		
	}
	

	/**
	 * 19. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem (String string) { 
	        List<String> list = Arrays.asList(string.split(" "));
	        List<String> text = new ArrayList<>(list);

	        Stack<String> operation = new Stack<>();
	        Stack<Integer> numbers = new Stack<>();


	        //multiplication/division
	        if (!text.get(0).equals("What") || !text.get(1).equals("is"))
	            throw new IllegalArgumentException();
	        while (text.contains("by")) {
	            text.remove("by");
	        }
	        while (text.contains("?")) {
	            text.remove("?");
	        }


	        for (int i = 2; i < text.size(); i++) {
	            if (i % 2 == 0) {
	                int num;	       
	                num = Integer.parseInt(text.get(i).replace("?", ""));
	                numbers.push(num);
	            } else {
	                String op = text.get(i);
	                if (op.equals("multiplied") || op.equals("plus") || op.equals("minus")
	                        || op.equals("divided")) {
	                    operation.push(op); 
	                    }
	            }
	            if (operation.size() == 1 && numbers.size() == 2) {
	                String op = operation.pop();
	                if (op.equals("multiplied")) numbers.push(numbers.pop() * numbers.pop());
	                if (op.equals("plus")) numbers.push(numbers.pop() + numbers.pop());
	                if (op.equals("minus")) {
	                    int two = numbers.pop();
	                    int one = numbers.pop();
	                    numbers.push(one - two);
	                } ;
	                if (op.equals("divided")) {
	                    int two = numbers.pop();
	                    int one = numbers.pop();
	                    numbers.push(one / two);
	                }
	            }
	        }
	       

          if (operation.size() == 0 && numbers.size() == 1) {
        	  return numbers.pop();
          }
	        else throw new IllegalArgumentException();
	        
	}

}

