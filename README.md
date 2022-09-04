# Cartão Virtural
Projeto Vencedor do Hackthon Conjove 2015 que aconteceu em Belém do Pará.
 
<p> O projeto consiste em uma plataforma onde é possível criar cartões de créditos virtuais a partir de um cartão físico, 
compartilhando o crédito entre esses cartões, com opções de limitar o crédito de cada cartão criado. Isso parece familiar ?</p>

<p> Também é possível fazer comprar em estabelecimentos físicos sem o cartão de créditos físico, basta criar e vincular um cartão virtual a uma chave que pode ser seu cpf ou número de celular (ué, pix?) e procurar um estabelecimeto credenciado </p>
 
 <p>Hoje é muito comum (e recomendável) criar cartões virtuais para fazer compras on-line, mas em 2015, nenhum banco disponibilizavam essa funcionalidade (Será que somos os Pais dessa tecnologia? rs) </p>

<p> Também era um ideia inovadora na época usar o número de celular ou cpf pra realizar pagamentos ...</p>

#### Algumas matérias publicadas pela imprensa na época sobre o projeto:
- http://pctguama.org.br/?p=1265&lang=pt
- https://g1.globo.com/pa/para/jornal-liberal-2edicao/videos/t/edicoes/v/batalha-de-hackers-ocorre-dentro-de-shopping-em-belem/4641731/?fbclid=IwAR2mTzEdTFVo6_lirPfey1rk6ZKGgnB3CnlajR-PkYYFahUgCbDe3YyrBio
- https://dol.com.br/notired-351912-8-.html?fbclid=IwAR0R-cup9n3ZS-Mqdivoflo6rLFohu4_MadFMG1wOfSOF29z2g9YkV6Q3cA
- http://www.ormnews.com.br/noticia/cartao-virtual-e-apontado-como-solucao-ao-varejo?fbclid=IwAR15tv0IImjdLaLyITlsIHvLRtNtobqTgHg7JGnUvF2SNJKEO3HgtkFKBqo

<p> Desconsidere o código cheio de más praticas, na época éramos Programadores Júniors e tivemos 32 horas pra entregar 3 aplicações: Sistema Web do cliente, Sistema Web do Logista, App Mobile para o cliente. Além de integrações com meios de pagamento (PagSeguro).</p> 
<p> Sim! no dia fizemos transações reais pra demostar o produto funcionando</p>

<p> Infelizmente alguns repos, como o do app mobile não estão mais disponíveis :( </p>

# Executando

## Requisito
 - Java 8
 - Docker
 - Docker compose

Primeiro você precisa compilar o projeto. Abra o terminal e navegue até a pasta raís do projeto e então digite o seguinte comando:
``` 
mvn clean install 
```

E agora pode executar
``` 
docker compose up 
```

Após o termino do deploy a aplicação estará disponível em:
http://localhost:8080/cartao-virtual-1.0.0-SNAPSHOT/


