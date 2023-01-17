conjunto1 = {1, 2, 3 , 4}
conjunto2 = {1, 5, 6, 7, 8}
conjuntoA = {1, 2 , 3}
conjuntoB = {1, 2 , 3, 4, 5}
conjunto1.add(5)
conjunto2.discard(1)
print("Conjunto 1: {}" .format(conjunto1))
print("Conjunto 2: {}" .format(conjunto2))
conjunto_union = conjunto1.union(conjunto2)
conjunto_intersection = conjunto1.intersection(conjunto2)
conjunto_difference = conjunto1.difference(conjunto2)
conjunto_diff_asymmetric = conjunto1.symmetric_difference(conjunto2)
print("União: {}" .format(conjunto_union))
print("Interseção: {}" .format(conjunto_intersection))
print("Diferença: {}" .format(conjunto_difference))
print("Diferença Assimetrica: {}" .format(conjunto_diff_asymmetric))
conjunto_subset = conjunto1.issubset(conjuntoA) #ve se é subconjunto
print(conjunto_subset)
conjunto_subset2 = conjunto1.issubset(conjuntoB)
print(conjunto_subset2)
conjunto_superset = conjuntoA.issuperset(conjuntoB)
print(conjunto_superset)