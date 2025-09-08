class Solution {
private:
    void solve(vector<int> array, vector<int> output, int index,vector<vector<int>>& ans){
        //base case - it means ki agar mera index jo hai agar vo mere array k bhar chala gya then return, but agar hum waha tak poch gaye hai then outputs are generated toh unhe vector me daal do.
        if(index >= array.size()){
            ans.push_back(output);
            return;
        }
        //exclude
        solve(array, output, index+1, ans);

        //include
        int element = array[index];
        output.push_back(element);
        solve(array, output, index+1, ans);
    }

public:
    vector<vector<int>> subsets(vector<int>& array) {
        vector<vector<int>> ans;
        vector<int> output;
        int index = 0;
        solve(array, output, index, ans);
        return ans;
    }
};