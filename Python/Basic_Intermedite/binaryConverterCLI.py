import numpy as np

welcomeMsg = "\nWelcome to the Binary Converted CLI\n\nEnter a string and it will be converted to binary as UTF-8 number codes\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():

    choice = input('Would you like to convert...\n0. Binary To String\n1. String To Binary\n\nNumber: ')

    if not choice == '0' and not choice == '1' :
      print('\nYou must enter 1 or 0\n')
      init()

    inputMsg = "\nEnter A Word OR Phrase\nString: " if choice == '1' else "\nEnter A Binary String (ASCII UTF-8)\nBinary: "
    userInput = input(inputMsg) 
    if userInput.strip() == "":
      print(invalidMsg)
      init()

    if choice == '1':  
      binary = stringToBinary(userInput) #enter user input as param
      print(f'\nYour Binary String Is...\n\n{binary}')
    else:
      string = biToStr(userInput) #enter user input as param
      print(f'\nYour String Is...\n\n{string}')

    tryAgain()

def biToStr (binary): 

  finalStr = ''
  splitBi = binary.split(' ')
  for charInBi in splitBi:  
    base = len(charInBi)-1
    index = 0
    charNum = 0
    while base >= 0:
      if charInBi[index] == '1':
        charNum += 2 ** base
      index += 1
      base -= 1
    finalStr += chr(charNum)
  return finalStr

def stringToBinary(string):
  
  binary = ''
  
  for char in string:
    utf8Num = ord(char) 
    base=8
    biStr = ''
    while base >= 0:
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