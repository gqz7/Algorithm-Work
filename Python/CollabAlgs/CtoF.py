# https://www.freecodecamp.org/learn/javascript-algorithms-and-data-structures/basic-algorithm-scripting/convert-celsius-to-fahrenheit

import math

# create cli to convert cel to fah
# celsius * 9/5 + 32
cel = int(input('\nPlease enter a cel degree: '))

fah = math.ceil(((cel * (9/5) + 32)))

# "My name is {0}, I'am {1}".format("John",36)

print(f'\nThe cel for {cel}: fah = {fah}')