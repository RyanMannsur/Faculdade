
package principalRyanAnelioTomaz;


public class teste {
    public static void main(String[] args) {
        Receita strogonoff = new Receita("Strogonoff");
        Ingrediente carneDeBoi = new Carnes("1 kg","File mignon");
        Ingrediente carneDeFrango = new Carnes("1 kg","Peito de Frango");
        Ingrediente cremeDeLeite = new Laticinios("2 caixas", "Creme de leite");
        Ingrediente cremeDeLeiteVegetal = new Laticinios("2 caixas", "Creme de leite Vegetal");
        Ingrediente oleo = new Oleos("3 colheres","Oleo de soja");
        Ingrediente azeite = new Oleos("3 colheres","Azeite");
        carneDeBoi.getSubstituto().add(carneDeFrango);
        cremeDeLeite.getSubstituto().add(cremeDeLeiteVegetal);
        oleo.getSubstituto().add(azeite);
        strogonoff.adicionarIngrediente(carneDeBoi);
        strogonoff.adicionarIngrediente(cremeDeLeite);
        strogonoff.adicionarIngrediente(oleo);
        
        Receita receitaProf = new Receita("Receita da Professora");
        Ingrediente cremeDeLeite2 = new Laticinios("1 caixa", "Creme de leite");
        Ingrediente iogurte = new Laticinios("1 xicara", "Iogurte");
        Ingrediente sucoDeLimao = new Frutas("1 colher", "Suco de limão");
        Ingrediente vinagre = new Oleos("1/2 colher de cha", "Vinagre");
        Ingrediente leite = new Laticinios("1 xicara", "Leite");
        Ingrediente leiteDeSoja = new Laticinios("1 xicara","Leite de soja");
        Ingrediente acucar = new Vegetal("1 xicara", "Açucar");
        Ingrediente mel = new Vegetal("1/2 xicara", "Mel");
        Ingrediente melaco = new Vegetal("1 xicara", "Melaço");
        Ingrediente nectarDeAgave = new Vegetal("1/4 xicara", "Nectar de Agave");
        Ingrediente manteiga = new Laticinios("1 xicara", "Manteiga");
        Ingrediente margarina = new Laticinios("1 xicara", "Margarina");
        Ingrediente farinhaDeTrigo = new Farinhas("1 xicara","Farinha de trigo");
        Ingrediente farinhaDeArroz = new Farinhas("1 xicara", "Farinha de arroz");
        Ingrediente farinhaDeCenteio = new Farinhas("1 xicara", "Farinha de Centeio");
        Ingrediente maionese = new Laticinios("1 xicara", "Maionese");
        Ingrediente queijoCottage = new Laticinios("1 xicara", "Queijo cottage");
        Ingrediente ovo = new Vegetal("1", "ovo");
        Ingrediente amidoDeMilho = new Cereais("2 colheres de sopa", "Amido de milho");
        Ingrediente farinhaDeAraruta = new Farinhas("2 colheres de sopa", "Farinha de araruta");
        Ingrediente feculaDeBatata = new Vegetal("2 colheres de sopa","Fecula de batata");
        Ingrediente oleo2 = new Oleos("1/4 de xicara","Oleo de soja");
        Ingrediente sucoDeMaca = new Frutas("1/4 xicara", "Suco de maçã");
        Ingrediente paoBranco = new Farinhas("1", "Pão branco");
        Ingrediente paoIntegral = new Farinhas("1", "Pão integral");
        cremeDeLeite2.getSubstituto().add(iogurte);
        sucoDeLimao.getSubstituto().add(vinagre);
        leite.getSubstituto().add(leiteDeSoja);
        acucar.getSubstituto().add(mel);
        acucar.getSubstituto().add(melaco);
        acucar.getSubstituto().add(nectarDeAgave);
        manteiga.getSubstituto().add(margarina);
        manteiga.getSubstituto().add(iogurte);
        farinhaDeTrigo.getSubstituto().add(farinhaDeArroz);
        farinhaDeTrigo.getSubstituto().add(farinhaDeCenteio);
        maionese.getSubstituto().add(queijoCottage);
        ovo.getSubstituto().add(amidoDeMilho);
        ovo.getSubstituto().add(farinhaDeAraruta);
        ovo.getSubstituto().add(feculaDeBatata);
        oleo2.getSubstituto().add(sucoDeMaca);
        paoBranco.getSubstituto().add(paoIntegral);
        receitaProf.adicionarIngrediente(cremeDeLeite2);
        receitaProf.adicionarIngrediente(leite);
        receitaProf.adicionarIngrediente(sucoDeLimao);
        receitaProf.adicionarIngrediente(acucar);
        receitaProf.adicionarIngrediente(manteiga);
        receitaProf.adicionarIngrediente(farinhaDeTrigo);
        receitaProf.adicionarIngrediente(maionese);
        receitaProf.adicionarIngrediente(ovo);
        receitaProf.adicionarIngrediente(oleo2);
        receitaProf.adicionarIngrediente(paoBranco);
        
     
        strogonoff.imprimirReceita();
        receitaProf.imprimirReceita();
        
    }
}
