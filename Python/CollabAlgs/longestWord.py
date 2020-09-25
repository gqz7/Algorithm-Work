# longestWord.py

# ~Ch
def longestWord():
    string = input('Please enter a sentence and we will determine the longest word\nString: ')
    strSplit = string.split()
    longestWord = 0
    for word in strSplit:
      if len(word) > longestWord:
          longestWord = len(word)
    print(f"The longest word in your sentence was {longestWord} characters!")
# longestWord()

# ~A
def longestWord2(): 
    string = input("Enter string to dissect: ")
    wlist = string.split()
    
    maxLen = 0
    words = []
    
    for word in wlist:
        wlen = len(word)
        if maxLen < wlen: # Clears the words if a bigger is found
            words.clear()
            maxLen = wlen
            
        if maxLen == wlen: # Appends if the word matches max length
            words.append(word)
            
    print("Longest word:\n-Length: " + str(maxLen) + "\n-Count: " + str(len(words)) + "\n-Words: ")
    for word in words:
        print(" - " + word)
            
#longestWord2()

# ~Cu
def longestWord3():
    string = input('Enter sentence to find longest word\n')
    strSplit = string.split()
    strSplit.sort(key = len)
    print(strSplit[-1]) #-1 index will be the last element in list

# ~X
  for idx, word in enumerate(string_lst):
    if (idx + 1) < len(string_lst):
      if len(word) > len(string_lst[idx + 1]):
        longest = word
      else:
        longest = string_lst[idx + 1]
  print(f'\nThe longest word found was: {longest}')