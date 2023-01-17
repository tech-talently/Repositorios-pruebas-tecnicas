Fue una prueba con 2 problemas en una plataforma, 30 mins para resolverlos.

Te dan un string con numeros, por eje: "0123456" y otro string, por ej: "210" hay que escribir una funcion que retorne los pasos que hay que hacer en el string principal para encontrar cada numero/caracter de "210". En este caso da 4. Ayuda: |a-b| pasos siempre se comienza desde 0.

from typing import List

def solution(digits: str, num: str) -> int:
    # write your solution here
    
    lst_digits = list(digits)
    lst_nums = list(num)
    lst_indexes = [0]
    steps = 0
    
    for n in lst_nums:
        if n in lst_digits:
            lst_indexes.append(lst_digits.index(n))
    print(lst_indexes)


    for n in range(0, len(lst_indexes)-1):
        steps += abs(lst_indexes[n] - lst_indexes[n + 1])
    
    return steps


# README
# DO NOT CHANGE the code below, we use it to grade your submission.

if __name__ == '__main__':
    #a = input()
    #b = input()
    #a = '8459761203'
    #b = '5439'
    a = '0123456789'
    b = '210'
    output = solution(a, b)
    print(output)