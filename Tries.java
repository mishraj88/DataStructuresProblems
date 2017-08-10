import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tries {

	static class Node{
		Node parent = null;
		boolean isWord = false;
		int asPrefixCount =0;
		Node[] charArray = new Node[26];
	}

	static Node root = new Node();

	public static void add(String str){

		char[] wordArray = str.toCharArray();
		add(wordArray, root, 0);
	}

	private static void add(char[] strChars, Node start, int charIndex){

		if(charIndex < strChars.length-1){
			int charCorrespondingIntIndex = strChars[charIndex] - 'a';
			if(start.charArray[charCorrespondingIntIndex] == null ){
				Node newCharNode = new Node();

				start.charArray[charCorrespondingIntIndex] =newCharNode;
				//newCharNode.asPrefixCount++;
				newCharNode.parent = start;

				//start.asPrefixCount++;
				charIndex++;
				start = newCharNode;
				System.out.println("start entries: "+start.asPrefixCount+" and is startA WOrd: "+start.isWord+" and newIndex: "+charIndex);
				add(strChars, start, charIndex);
			}
			else{
				//start.asPrefixCount++;
				start = start.charArray[charCorrespondingIntIndex];
				charIndex++;
				System.out.println("start entries: "+start.asPrefixCount+" and is startA WOrd: "+start.isWord+" and newIndex: "+charIndex);
				add(strChars, start,charIndex);
			}
		}
		else{
			int charCorrespondingIntIndex = strChars[charIndex] - 'a';

			if(start.charArray[charCorrespondingIntIndex] == null){
				Node newCharNode = new Node();
				newCharNode.asPrefixCount++;
				newCharNode.isWord = true;
				newCharNode.parent = start;
				Node parent = newCharNode.parent;
				while(parent.parent != null){
					parent.asPrefixCount++;
					parent=parent.parent;
				}
				start.charArray[charCorrespondingIntIndex] = newCharNode;
				//start.asPrefixCount++;
				start = newCharNode;
				System.out.println("start entries: "+start.asPrefixCount+" and is startA WOrd: "+start.isWord+" and newIndex: "+charIndex);

			}
			else{
				Node parent = start;
				while(parent.parent != null){
					parent.asPrefixCount++;
					parent=parent.parent;
				}
				//start.asPrefixCount++;
				start = start.charArray[charCorrespondingIntIndex];
				start.isWord=true;
				start.asPrefixCount++;

			}


		}
	}

	public static int find(String str){
		char[] strChars = str.toCharArray();
		return find(strChars, root, 0);
	}

	private static int find(char[] strChars, Node start, int index){

		int result =0;

		if(index < strChars.length -1){
			int charCorrespondingIntIndex = strChars[index] - 'a';
			System.out.println("index: "+index+" and charCorrespondingIntIndex: "+charCorrespondingIntIndex);
			if(start.charArray[charCorrespondingIntIndex] !=null){
				System.out.println("in if not null");
				start = start.charArray[charCorrespondingIntIndex];

				index++;
				System.out.println("before last character in if and start.asPrefixCount: "+start.asPrefixCount+" and is startA WOrd: "+start.isWord+" and newIndex: "+index);
				return find(strChars, start, index);
			}else{
				result= 0;
				return result;
			}
		}
		else{ 
			if(index == strChars.length -1){
				int charCorrespondingIntIndex = strChars[index] - 'a';
				if(start.charArray[charCorrespondingIntIndex] !=null){
					start = start.charArray[charCorrespondingIntIndex];
					System.out.println("at last char in else if and start.asPrefixCount: "+start.asPrefixCount+" and is startA WOrd: "+start.isWord+" and newIndex: "+index);
					//index++;
					result=start.asPrefixCount;
					return result;

				}else{
					System.out.println("in else at last char of search string & start.charArray[charCorrespondingIntIndex]: "
							+ start.charArray[charCorrespondingIntIndex]);
					return result=0;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			if(op.equalsIgnoreCase("add")){
				add(contact);
			}else{
				int count = find(contact);
				System.out.println(count);
			}
		}
	}
}

