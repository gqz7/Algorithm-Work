strtMsg = '\nWelcome To The Factorialize CLI\n______________________________\n\n';
inputMsg = '\nEnter A Number To Find Its Factorial\nNumber: '
failedMsg = '\nPlease Enter A Vaild Number, Try Again\n\n\n'
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '
def factorialize(num):
  ans = 1
  count = 1
  while count <= num:
    ans *= count
    count += 1
  return ans

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
  try:
    inNum = int(input(inputMsg))
    fact = factorialize(inNum)
    print(f'\nThe Factorial of {inNum} is {fact}\n\n')
    tryAgain()
  except ValueError:
    print(failedMsg)
    q()

print(strtMsg)
q()