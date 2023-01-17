notas = [0, 0, 0, 0]
for i in range(4):
    notas[i] = float(input("Digite a noda do {} bimestre: " .format(i+1)))
    while notas[i]>10:
        notas[i] = float(input("Erro. Digite a nota novamente: "))
if 0 in notas:
    notas.remove(0) #Remove toda nota 0
tupla_notas = tuple(notas) #Uma tupla nao pode editar os valores dentro
nota_final = sum(notas)
nota_final = nota_final/4
if nota_final<6:
    print("Nota final foi: {}" .format(nota_final))
    especial = float(input("Digite a nota da prova especial: "))
    notas.append(especial)
    nota_final = sum(notas)
    nota_final = nota_final/4
    #print(len(tupla_notas)) #A nota da especial vai para lista e nao para tupla
    notas.sort()
    print("A menor nota anulando nota 0 foi {}" .format(notas[0]))
    notas.reverse()
    print("A maior nota foi {}".format(notas[0]))
    if nota_final < 6:
        print("Aluno reprovado\nNota final foi: {}".format(nota_final))
    else:
        print("Aluno Aprovado\nNota final foi: {}".format(nota_final))
else:
    print("Nota final foi: {}\nAluno Aprovado".format(nota_final))

#notas.pop(1) isso tiraria a nota na posiçao 1

