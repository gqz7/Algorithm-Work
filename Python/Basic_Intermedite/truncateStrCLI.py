
welcomeMsg = "\nWelcome to the Truncate CLI\n\nYou will enter a string and how many characters you want to keep. Your result will be a truncated string\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Sentence, Phrase, Or Word To Truncate\nInput: ")

    if userInput.strip() == "":
      print(invalidMsg)
      init()

    
    maxChars = input("\nEnter Number Of Maximum Characters To Keep In The String\nNumber: ")

    if not maxChars.isnumeric():
      print(invalidMsg)
      init()
    else:
      maxChars = int(maxChars)

    result = truncate(userInput, maxChars) #enter user input as param
    
    print(f'\nYour truncated string is :\n\n{result}')
    tryAgain()

def truncate(string, number): #add args
  if len(string) <= number:
    print('\nThere was nothing to truncate\n')
    return string
  else:
    answer = string[0: number] + '...'
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