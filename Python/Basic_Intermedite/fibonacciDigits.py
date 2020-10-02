from functools import reduce

welcomeMsg = "\nWelcome to the Fibonnaci Digits CLI\n\nEnter the number and this program will calculate the nth term of fibonacci that has the given number of digits\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Target Number Of Digits\nInput: ")

    if not userInput.isnumeric():
      print(invalidMsg)
      init()
    else:
      userInput = int(userInput)

      result = fib(userInput) #enter user input as param

      number = result[1]
      place = result[0]
      # [str(element) for element in a_list]
      ordinal = getOrdinal(str(place))

      print(f'\nThe first Fibonacci number with {userInput} digits is {number}.\nIt is the {place}{ordinal} number of the Fibonacci  sequence.')
      tryAgain()

def fib(digits): 
  
  num1 = 0
  num2 = 1
  count = 1
  fib = 1

  while len(str(fib)) < digits:
    count += 1
    fib = num1 + num2
    num1 = num2
    num2 = fib
    # print(fib)a 

  answer = [count, fib]

  return answer

def getOrdinal(numStr):
  ones = int(numStr[-1])
  tens = int(numStr[-2]) if len(numStr) > 1 else None

  print(ones, tens)

  if ones == 1 and not tens == 1 :
    return 'st'
  elif ones == 1 and not tens == 2 :
    return 'nd'
  elif ones == 1 and not tens == 3 :
    return 'rd'
  else:
    return 'th'


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