class Solution {
private:
    void solve(string digits, vector<string> &ans, string output, int index, string mapping[]){
        //Base Case - input kahi keypad se bhar na nikal jaye
        if(index >= digits.length()){
            ans.push_back(output);
            return;
        }
        int number = digits[index] - '0'; // this returns a char but for int we will use - '0' 
        string value = mapping[number]; // jo number mila hai input me usse mapping pe dhundho

        for (int i = 0; i<value.length(); i++){
            output.push_back(value[i]);
            solve(digits, ans, output, index + 1, mapping);
            output.pop_back(); //backtracking
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        string mapping[10] = {"", "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> ans; // vector named ans for storing ans
        string output = "";
        int index = 0;

        //edge case hai yeh
        if(digits.length() == 0){
            return ans;
        }
        
        solve(digits, ans, output, index, mapping);
        return ans;
    }
};