class Solution {
    public List<Integer> partitionLabels(String S) {
      List<Integer> partitionLengths = new ArrayList<>(); 
      if (S.length() == 0) {
        return new ArrayList<>();
      }
      Map<Character, Integer> firstOccurrence = new LinkedHashMap<>();
      int[] frequencyTable = new int[26]; 
      int[] lastOccurrence = new int[26]; 
      for (int index = 0; index < S.length(); ++index) { 
        char curChar = S.charAt(index);
        if (!firstOccurrence.containsKey(curChar)) {
          firstOccurrence.put(curChar, index);
        }
        lastOccurrence[curChar - 'a'] = index; 
        ++frequencyTable[curChar - 'a']; 
      }
      int curPartitionStart = 0;
      int curPartitionEnd = 0;
      int lengthCurPartition = 0;
      int charsInCurPartition = 0;
      for (char c : firstOccurrence.keySet()) {
        if (lastOccurrence[c - 'a'] > curPartitionEnd) { 
          curPartitionEnd = lastOccurrence[c - 'a'];
        }
        charsInCurPartition += frequencyTable[c - 'a'];
        lengthCurPartition = curPartitionEnd - curPartitionStart + 1;
        if (charsInCurPartition == lengthCurPartition) { 
          partitionLengths.add(lengthCurPartition); 
          curPartitionStart += lengthCurPartition; 
          curPartitionEnd = curPartitionStart; 
          charsInCurPartition = 0;
        }
      }
  
      return partitionLengths;
    }
  }