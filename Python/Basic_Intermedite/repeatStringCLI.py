import re

welcomeMsg = "\nWelcome to the String Repeater CLI\n\nYou will enter a word or phrase and how many times you want it repeated\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Word Or Phrase\nInput: ")

    if userInput.strip() == "":
      print(invalidMsg)
      init()
    
    times = input("\nEnter Number Of Times To Repeat String\nNumber: ")

    if not times.isnumeric():
      print(invalidMsg)
      init()

    newPhrase = repeater(userInput, int(times))

    print(f'\nYour New Phrase Is:\n\n{newPhrase}')
    tryAgain()

def repeater(string, num):
  count = 0
  newStr = ''
  while count < num:
    count+=1
    newStr+=string
  return newStr

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