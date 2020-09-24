import re

welcomeMsg = "\nWelcome to the Pig-Latin CLI\n\nYou will enter a word or phrase and your entry will be responded back in Pig-Latin\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Word Or Phrase\nInput: ")

    if userInput.strip() == "":
      print(invalidMsg)
      init()
    
    stringList = userInput.split()

    newPhrase = ''

    for word in stringList:
      newWord = toPigLatin(word)
      newPhrase += newWord + ' ' 
    print(f'\nYour Pig Latin Phrase Translates To:\n\n{newPhrase}')
    tryAgain()

def toPigLatin(str):
  if not re.search("[a-zA-Z]", str):
    return str
  elif not re.search("a|e|i|o|u?i", str):
    return str + 'ay'
  else:
    vIndex = int(re.search("a|e|i|o|u?i", str).start())
    pStr = str[vIndex:] + str[0:vIndex] + 'ay'
    return pStr

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