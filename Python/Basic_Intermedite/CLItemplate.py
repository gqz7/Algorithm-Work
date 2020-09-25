
welcomeMsg = "\nWelcome to the <alg name> CLI\n\n<instructions>\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A <input type>\nInput: ")

    if <inputcheck>:
      print(invalidMsg)
      init()

    result = algorithm() #enter user input as param

    print(f'\nYour is :\n\n{result}')
    tryAgain()

def algorithm(): #add args
  
  answer = #define answer

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