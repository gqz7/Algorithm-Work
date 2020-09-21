welcomeMsg = "\nWelcome to the Pig-Latin CLI\n\nYou will enter a word or phrase and your entry will be responded back in Pig-Latin\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"

def init():
    userInput = input("Enter A Word Or Phrase\nInput: ")

    if userInput.strip() == "":
      print(invalidMsg)
      init()
    
    stringList = userInput.split()

    for word in stringList:
      newWord = toPigLatin(word) 

def toPigLatin(str):
  print(str)

print(welcomeMsg)
init()