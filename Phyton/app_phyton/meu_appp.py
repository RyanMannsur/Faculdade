a = int(input("Digite um Numero: "))
b = int(input("Digite outro Numero: "))
soma = a + b
multiplicacao = a * b
resto = a % b

print("Soma: {soma} \nMultiplicacao: {mult}\n"
      "Resto: {resto}".format(soma=soma, resto=resto, mult=multiplicacao))