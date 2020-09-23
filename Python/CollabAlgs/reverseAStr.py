# reverseAStr.py
# https://www.freecodecamp.org/learn/javascript-algorithms-and-data-structures/basic-algorithm-scripting/reverse-a-string



def reverseAString ():
    string = input('Enter you name and it will be reveresed for you \n Name: ')
    emptyArr = []
    for charInStr in string:
        emptyArr.insert(0, charInStr)
    print(''.join(emptyArr))
reverseAString ()  


