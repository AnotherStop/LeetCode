/*
 * Key point: dfs, the idea is like Subsets, Permutation, Combination
 *  the recursive path is button by button
 */

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        if(digits == null)
            return null;
            
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer temp = new StringBuffer();
        
        int length = digits.length();
        if(length == 0){
            result.add("");
            return result;
        }
        
        //create a dictionary to map the digit and its characters
        //the order of dictionary is same as the number in phone number
        ArrayList<char []> dict = new ArrayList<char []>();
        for(int i = 0;i<length;i++){
            char c = digits.charAt(i);
            switch(c){  //there is no character on button 1
                case '2': char[] two = {'a','b','c'}; dict.add(two); break;
                case '3': char[] three = {'d','e','f'}; dict.add(three); break;
                case '4': char[] four = {'g','h','i'}; dict.add(four); break;
                case '5': char[] five = {'j','k','l'}; dict.add(five); break;
                case '6': char[] six = {'m','n','o'}; dict.add(six); break;
                case '7': char[] seven = {'p','q','r','s'}; dict.add(seven); break;
                case '8': char[] eight = {'t','u','v'}; dict.add(eight); break;
                case '9': char[] nine = {'w','x','y','z'}; dict.add(nine); break;
                case '0': char[] ten = {' '}; dict.add(ten); break;
                
                default: break;
            }
        }
        
        //start from position 0
        dfsWorker(dict, 0, result, temp);
        
        return result;
    }
    
    public void dfsWorker(ArrayList<char []> dict, int position, ArrayList<String> result, StringBuffer temp){
        if(position == dict.size()){
            result.add(temp.toString());
            return;
        }
        
        //recursive call dfsWorker() button by button
        //because the first character must be in the first digit's button
        //one level loop is enough
        char[] button = dict.get(position);
        for(int j = 0;j<button.length;j++){
            temp.append(button[j]);
            dfsWorker(dict, position+1, result, temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }
    
}