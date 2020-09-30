import numpy as np

welcomeMsg = "\nWelcome to the Binary Converted CLI\n\nEnter a string and it will be converted to binary as UTF-8 number codes\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Word OR Phrase\nInput: ")

    if userInput.strip() == "":
      print(invalidMsg)
      init()

    binary = stringToBinary(userInput) #enter user input as param

    print(f'\nYour Binary String Is...\n\n{binary}')
    tryAgain()

def stringToBinary(string):
  
  binary = ''
  
  for char in string:
    utf8Num = ord(char) 
    base=8
    biStr = ''
    while base > -1:
      if utf8Num - (2 ** base) >= 0:
        utf8Num-=2**base
        # print(utf8Num, base, 2**base) 
        biStr = biStr+'1'
      else:
        biStr = biStr+'0'
      base-=1

    binary += biStr + ' ' 

  return binary

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