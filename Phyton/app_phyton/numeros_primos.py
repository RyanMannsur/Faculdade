i = 1

while i <= 100:
    contador = 0
    for j in range(1, i+1):
        if i % j == 0:
            contador += 1
    if contador<=2:
        print("{} é primo".format(i))
    i += 1
