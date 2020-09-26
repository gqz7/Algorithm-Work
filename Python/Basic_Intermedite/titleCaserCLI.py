
welcomeMsg = "\nWelcome to the Title Case CLI\n\nYou will enter a string and it will be title cased\nexample: this is a title = This Is A Title\n\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Sentence\nInput: ")

    if userInput.strip() == "":
      print(invalidMsg)
      init()

    result = titleCaseSentence(userInput) #enter user input as param

    print(f'\nYour Title is...\n\n{result}')
    tryAgain()

def titleCaseSentence(text): #add args
  strList = text.split()
  answer = ' '.join(map(lambda word: word[0].upper() + word[1:].lower(), strList))
  return answer

def tryAgain():
  ta = input(tryAginMsg)[0].lower()
  if ta == 'y':
    init()
  elif ta == 'n':
    return
  else: 
    print('\nEnter yes or no')
    tryAgain()

print(welcomeMsg)

init()