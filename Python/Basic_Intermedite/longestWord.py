strtMsg = '\nWelcome To The Longest Word CLI\n________________________________\n\n';
inputMsg = '\nEnter A Sentence To Find The Longest Word\nString: '
failedMsg = '\nPlease Enter A Vaild String, Try Again\n\n\n'
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '
def longestWord(str):
  sList = str.split()
  longestWs = []
  longestWordLength = 0
  for i in range(len(sList)):
    word = sList[i]
    if len(word ) == longestWordLength:
      longestWs.append(sList[i])
    elif len(word ) > longestWordLength:
      longestWordLength = len(word)
      longestWs = [sList[i]]
  return longestWs
def tryAgain():
  ta = input(tryAginMsg)[0].lower()
  if ta == 'y':
    q()
  elif ta == 'n':
    return
  else: 
    print('\nEnter yes or no')
    tryAgain()

def q ():
  sentence = input(inputMsg).strip()
  if len(sentence) == 0:
    print(failedMsg)
    q()
  longestWords = longestWord(sentence)
  multi = len(longestWords) > 1
  isAre = 'are' if multi else 'is'
  wordVar = 'words' if multi else 'word' 
  print(f"\nThe longest {wordVar} in...\n{sentence} {isAre}...\n'{longestWords}'\n\n")
  tryAgain()

print(strtMsg)
q()